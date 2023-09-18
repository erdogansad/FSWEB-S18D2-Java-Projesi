package com.workintech.S18D2.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class FruitException extends RuntimeException {
    private HttpStatus status;

    public FruitException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
