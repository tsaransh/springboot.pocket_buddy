package com.pocketbuddy.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ApiException extends RuntimeException{

    private final String title;

    public ApiException(String title) {
        super(String.format("Resource Not Found with %s", title));
        this.title = title;
    }

}
