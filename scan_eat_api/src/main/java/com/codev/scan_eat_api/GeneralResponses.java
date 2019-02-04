package com.codev.scan_eat_api;

import org.springframework.http.ResponseEntity;

public class GeneralResponses {

    public static ResponseEntity<Object> internalServerError() {
        return generateJSONResponse(500,
                "This is not normal, please contact the IT support so that we can correct this problem as quickly as possible");
    }

    public static ResponseEntity<Object> generateJSONResponse(int htmlErrorCode, String errorMsg) {
        return ResponseEntity.status(htmlErrorCode).body("{'errorMsg':' " + errorMsg + "'}");
    }
}
