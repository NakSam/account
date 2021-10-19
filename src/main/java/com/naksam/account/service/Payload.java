package com.naksam.account.service;

import com.naksam.account.dto.MemberPayload;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Set;

class Payload {
    private final Claims claims = new Claims();

    private final ZonedDateTime expirationDateTime;

    public Payload(MemberPayload memberPayload, ZonedDateTime expirationDateTime) {
        addClaim("info", memberPayload);
        this.expirationDateTime = expirationDateTime;
    }

    public void addClaim(String key, Object value) {
        claims.put(key, value);
    }

    public Set<Map.Entry<String, Object>> entrySetOfClaims() {
        return claims.entrySet();
    }

    public Date expirationDate() {
        return Date.from(this.expirationDateTime.toInstant());
    }
}