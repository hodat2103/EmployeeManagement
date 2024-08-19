package com.example.demo.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseObject {
    private String status;
    private String message;
    private Object data;

    public ResponseObject(String status, String message) {
        this.status = status;
        this.message = message;

    }
}
