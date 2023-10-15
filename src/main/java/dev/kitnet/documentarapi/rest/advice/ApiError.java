package dev.kitnet.documentarapi.rest.advice;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private List<String> errors;

    public ApiError(String error) {
        this.errors = List.of(error);
    }
}
