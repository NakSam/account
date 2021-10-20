package com.naksam.account.presentation;

import com.naksam.account.dto.JsonWebToken;
import com.naksam.account.service.ConsoleJwtService;
import com.naksam.account.dto.MemberPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class AccountController {
    private final ConsoleJwtService consoleJwtService;

    public AccountController(ConsoleJwtService consoleJwtService) {
        this.consoleJwtService = consoleJwtService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createToken(@RequestBody MemberPayload memberPayload) {
        String token = consoleJwtService.createToken(memberPayload, ZonedDateTime.now()
                .plusYears(1));
        return ResponseEntity.ok(new JsonWebToken(token));
    }

    @PostMapping("/info")
    public ResponseEntity<?> findInfo(@RequestBody JsonWebToken jsonWebToken) {
        Object info = consoleJwtService.decodeInfo(jsonWebToken.getJsonWebToken());
        return ResponseEntity.ok(info);
    }
}
