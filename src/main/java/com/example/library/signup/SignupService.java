package com.example.library.signup;

import com.example.library.user.Role;
import com.example.library.user.User;
import com.example.library.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignupService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String signup(SignupRequest request) {
        boolean isValidEmail = emailValidator.test(request.getUsername());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return userService.signupUser(
                new User(
                        request.getName(),
                        request.getUsername(),
                        request.getPassword()
                )
        );
    }
}
