package com.spring.tennisV2.advice;

import com.spring.tennisV2.exception.IllegalScorerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TennisExceptionHandler {

        @ExceptionHandler(IllegalScorerException.class)
        public ResponseEntity<Object> invalidScoreException(IllegalScorerException ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("errorCode", "400");
            body.put("message", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }

}
