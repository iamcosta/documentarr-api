package dev.kitnet.documentarapi.rest.dto;

import lombok.Data;

@Data
public class LoginReqDTO {
    private String login;
    private String senha;
}
