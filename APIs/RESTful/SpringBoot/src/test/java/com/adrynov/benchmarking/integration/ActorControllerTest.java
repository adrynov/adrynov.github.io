package com.adrynov.benchmarking.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActorControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getHello() throws Exception {
        var url = new URL("http://localhost:" + port + "/api/actors").toString();
        var response = restTemplate.getForEntity(url, String.class);

        assertEquals("Hello World", response.getBody());


        //    ResponseEntity<String> response = restTemplate.getForEntity(
        //			new URL("http://localhost:" + port + "/").toString(), String.class);
        //        assertEquals("Hello Controller", response.getBody());
    }

}
