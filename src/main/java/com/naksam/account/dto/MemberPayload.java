package com.naksam.account.dto;

import lombok.Data;

@Data
public class MemberPayload {
    private Long id;
    private String email;
    private String name;
}
