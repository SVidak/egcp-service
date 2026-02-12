package rs.erste.egcpservice.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.springframework.stereotype.Component;
import rs.erste.egcpservice.dto.EGCPEventDTO;
import rs.erste.egcpservice.service.EgcpEventService;
import tools.jackson.core.JacksonException;

@Component
public class Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // ============================================================
        // GLOBAL ERROR HANDLER
        // ============================================================
        errorHandler(deadLetterChannel("direct:deadLetterChannel")
                .useOriginalMessage()
                .maximumRedeliveries(5)
                .redeliveryDelay(1000)
                .backOffMultiplier(2.0)
                .retryAttemptedLogLevel(LoggingLevel.WARN)
                .logExhaustedMessageHistory(true)
                .logExhaustedMessageBody(true)
                .onRedelivery(exchange -> {
                    int redeliveryCount = exchange.getIn().getHeader(Exchange.REDELIVERY_COUNTER, Integer.class);
                    log.warn("Redelivery attempt {}", redeliveryCount);
                })
        );

        // ============================================================
        // POISON MESSAGES (don't retry): invalid JSON / validation
        // ============================================================
        onException(JacksonException.class, JsonProcessingException.class)
                .handled(true)
                .useOriginalMessage()
                .maximumRedeliveries(0)
                .redeliveryDelay(0)
                .log(LoggingLevel.ERROR, "JSON parsing failed. message=${exception.message}")
                .to("direct:deadLetterChannel");

        onException(BeanValidationException.class)
                .handled(true)
                .useOriginalMessage()
                .maximumRedeliveries(0)
                .redeliveryDelay(0)
                .log(LoggingLevel.ERROR, "JSON validation failed. message=${exception.message}")
                .to("direct:deadLetterChannel");

        onException(Exception.class)
                .log(LoggingLevel.ERROR, "Processing failed. exception=${exception.class} message=${exception.message}");

        // ============================================================
        // DLQ ROUTE
        // ============================================================
        from("direct:deadLetterChannel")
                .routeId("egcp-dead-letter")
                .log(LoggingLevel.ERROR, "DLQ message. originalBody=${body}")
                .to("jms:queue:egcp.dlq");

        // ============================================================
        // CONSUME MESSAGE FROM JMS ROUTE
        // ============================================================
        from("jms:queue:{{jms_url}}")
                .log(LoggingLevel.INFO, "Received message: ${body}")
                .routeId("egcp-jms-route")
                .transacted()
                .unmarshal().json(EGCPEventDTO.class)
                .to("bean-validator:egcpEventDTO")
                .bean(EgcpEventService.class, "save")
                .log(LoggingLevel.INFO, "Saved message: ${body}");

    }
}
