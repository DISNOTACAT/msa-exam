package com.sparta.msa_exam.auth.controller;

import com.sparta.msa_exam.auth.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam String user_id) {
        String role = "ADMIN";
        return ResponseEntity.ok(new AuthResponse(authService.createAccessToken(user_id, role)));
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AuthResponse {

        private String access_token;
    }
}
