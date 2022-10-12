package fr.aelion.agedi.springdemo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void helloEndpointShouldReturnDefaultMessage() {
        String url = "http://localhost:"+ this.port + "/intro/hello";
        Boolean hasDefaultMessage = this.restTemplate.getForObject(url, String.class).contains("Hello world !!");
        assertTrue(hasDefaultMessage);
    }
}
