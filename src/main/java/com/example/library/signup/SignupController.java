package com.example.library.signup;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/signup")
@AllArgsConstructor
public class SignupController {

    private SignupService signupService;

    @PostMapping
    public ResponseEntity signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok().body(signupService.signup(request));
    }
}
