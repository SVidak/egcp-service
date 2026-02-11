package rs.erste.egcpservice;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.apache.camel.CamelContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.activemq.ActiveMQContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import rs.erste.egcpservice.repository.EgcpEventRepository;

@SpringBootTest
@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JmsToDbIntegrationTest {

    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:16-alpine").withReuse(false);

    @Container
    @ServiceConnection
    static final ActiveMQContainer activeMQContainer =
            new ActiveMQContainer("apache/activemq-classic:6.1.0").withReuse(false);

    @DynamicPropertySource
    static void testProperties(DynamicPropertyRegistry registry) {
        registry.add("jms_url", () -> "test.queue");
    }

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    EgcpEventRepository egcpEventRepository;

    @BeforeEach
    void cleanDb() {
        egcpEventRepository.deleteAll();
    }

    @Test
    void whenMessageSentToQueue_thenEventIsPersistedToDb() {
        String json = """
            {
              "apiVersion": "1.0",
              "cardID": "CARD-123",
              "customerId": 42,
              "acsAuthenticationData": {
                "purchaseExponent": "2",
                "dsTransID": "DST-1",
                "purchaseCurrency": "EUR",
                "deviceChannel": "APP",
                "merchantName": "Demo",
                "purchaseAmount": "100"
              },
              "acsCardholderData": {
                "acctNumber": "4111111111111111",
                "requestCardImage": "N"
              }
            }
            """;

        jmsTemplate.convertAndSend("test.queue", json);

        await()
                .atMost(Duration.ofSeconds(10))
                .pollInterval(Duration.ofMillis(200))
                .untilAsserted(() -> assertEquals(1L, egcpEventRepository.count()));
    }
}
