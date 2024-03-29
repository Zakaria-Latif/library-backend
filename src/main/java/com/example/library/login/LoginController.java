package com.example.library.login;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/login")
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public ResponseEntity login(@RequestBody LoginRequest  request) {
        return ResponseEntity.ok().body(loginService.login(request));
    }
}
