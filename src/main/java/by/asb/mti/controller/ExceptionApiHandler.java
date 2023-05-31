package by.asb.mti.controller;

import by.asb.mti.dto.ErrorMessage;
import by.asb.mti.exception.TokenGenerationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionApiHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorMessage> usernameNotFoundException(UsernameNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder()
                        .timestamp(LocalDateTime.now().toString())
                        .status(HttpStatus.NOT_FOUND.value())
                        .error(HttpStatus.NOT_FOUND.name())
                        .message(exception.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }

    @ExceptionHandler(TokenGenerationException.class)
    public ResponseEntity<ErrorMessage> usernameNotFoundException(TokenGenerationException exception, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorMessage.builder()
                        .timestamp(LocalDateTime.now().toString())
                        .status(HttpStatus.NOT_FOUND.value())
                        .error(HttpStatus.NOT_FOUND.name())
                        .message(exception.getMessage())
                        .path(request.getRequestURI())
                        .build());
    }

}
