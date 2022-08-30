package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComposedAppTests {

  @LocalServerPort
  private int port;

  @Test
  void composes() throws IOException, InterruptedException {
    assertEquals("first",
      HttpClient.newHttpClient()
        .send(HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:" + port + "/first")).build(),
          HttpResponse.BodyHandlers.ofString()
        )
        .body()
    );
    assertEquals("second",
      HttpClient.newHttpClient()
        .send(HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:" + port + "/second")).build(),
          HttpResponse.BodyHandlers.ofString()
        )
        .body()
    );
    assertEquals("custom",
      HttpClient.newHttpClient()
        .send(HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:" + port + "/custom")).build(),
          HttpResponse.BodyHandlers.ofString()
        )
        .body()
    );
  }

}
