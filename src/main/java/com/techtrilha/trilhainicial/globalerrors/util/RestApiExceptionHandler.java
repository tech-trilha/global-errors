package com.techtrilha.trilhainicial.globalerrors.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.UUID;

@ControllerAdvice
public class RestApiExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<ErrorResponse> handleApiException(Exception error) {
    final var correlationId = UUID.randomUUID().toString();
    final var responseBody = new ErrorResponse(correlationId, "UNKNOW_ERROR", error.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(responseBody);
  }

}
