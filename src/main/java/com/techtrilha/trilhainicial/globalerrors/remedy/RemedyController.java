package com.techtrilha.trilhainicial.globalerrors.remedy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemedyController {

  @GetMapping("/remedies/{id}")
  public String getRemedy(@PathVariable final String id) {
    if ("1".equals(id)) {
      return "Remedy with id 1 found";
    }
    final var message = String.format("Remedy with id %s not found.", id);
    throw new RuntimeException(message);
  }

}