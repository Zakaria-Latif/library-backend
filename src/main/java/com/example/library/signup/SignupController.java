package com.example.library.signup;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth/signup")
@AllArgsConstructor
public class SignupController {

    private SignupService signupService;

    @PostMapping
    public String signup(@RequestBody SignupRequest request) {
        return signupService.signup(request);
    }
}
