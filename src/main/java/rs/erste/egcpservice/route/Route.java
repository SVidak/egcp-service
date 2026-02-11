package rs.erste.egcpservice.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import rs.erste.egcpservice.model.egcp.EGCPEvent;
import rs.erste.egcpservice.service.EgcpEventService;

@Component
public class Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("jms:queue:{{jms_url}}")
                .routeId("egcp-jms-route")
                .transacted()
                .unmarshal().json(EGCPEvent.class)
                .bean(EgcpEventService.class, "save");
    }
}
