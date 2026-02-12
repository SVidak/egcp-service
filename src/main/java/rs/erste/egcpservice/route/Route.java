package rs.erste.egcpservice.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.springframework.stereotype.Component;
import rs.erste.egcpservice.dto.EGCPEventDTO;
import rs.erste.egcpservice.service.EgcpEventService;

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
        onException(BeanValidationException.class)
                .handled(true)
                .useOriginalMessage()
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
                .routeId("egcp-jms-route")
                .transacted()
                .unmarshal().json(EGCPEventDTO.class)
                .to("bean-validator:egcpEventDTO")
                .bean(EgcpEventService.class, "save");

    }
}
