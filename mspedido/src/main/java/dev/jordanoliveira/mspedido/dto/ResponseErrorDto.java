package dev.jordanoliveira.mspedido.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseErrorDto {
    private final String message;
    private String error;
    private final String status;
    private LocalDateTime timestamp = LocalDateTime.now();
}