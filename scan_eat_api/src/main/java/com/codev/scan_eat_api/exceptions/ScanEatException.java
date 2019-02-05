package com.codev.scan_eat_api.exceptions;

import org.springframework.http.ResponseEntity;

public class ScanEatException extends Exception {
    protected ResponseEntity<Object> responseEntity;

    public ScanEatException(int htmlError, ErrorMessage errorMessage) {
        this.responseEntity = ResponseEntity.status(htmlError).body(errorMessage);
    }

    public ResponseEntity<Object> getResponseEntity() {
        return responseEntity;
    }
}
