package dev.jordanoliveira.mspedido.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.jordanoliveira.mspedido.dto.ResponseErrorDto;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseErrorDto> handleEntityNotFound(EntityNotFoundException ex) {
        ResponseErrorDto error = new ResponseErrorDto(
            ex.getMessage() != null ? ex.getMessage() : "Recurso não encontrado",
            HttpStatus.NOT_FOUND.toString()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> handleValidationException(MethodArgumentNotValidException ex) {
        StringBuilder message = new StringBuilder("Erro de validação: ");
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            message.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ")
        );
        
        ResponseErrorDto error = new ResponseErrorDto(
            message.toString(),
            HttpStatus.BAD_REQUEST.toString()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDto> handleGenericException(Exception ex) {
        ResponseErrorDto error = new ResponseErrorDto(
            "Erro interno do servidor",
            HttpStatus.INTERNAL_SERVER_ERROR.toString()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}