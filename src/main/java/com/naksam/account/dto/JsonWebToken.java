package com.naksam.account.dto;

import lombok.Data;

@Data
public class JsonWebToken {
    private String jsonWebToken;

    public JsonWebToken(String jsonWebToken) {
        this.jsonWebToken = jsonWebToken;
    }

    public JsonWebToken() {
    }
}
