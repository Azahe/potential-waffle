package com.example.custom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

  @GetMapping("/custom")
  public String custom() {
    return "custom";
  }

}
