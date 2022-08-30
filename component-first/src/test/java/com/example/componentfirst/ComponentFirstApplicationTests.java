package com.example.componentfirst;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComponentFirstApplicationTests {

  @LocalServerPort
  private int port;

  @Test
  void contextLoads() throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:" + port + "/first")).build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    assertEquals("first", response.body());
  }

}
