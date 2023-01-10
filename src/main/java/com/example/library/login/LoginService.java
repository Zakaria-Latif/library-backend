package com.example.library.login;

import com.example.library.admin.Admin;
import com.example.library.admin.AdminService;
import com.example.library.signup.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private final AdminService adminService;
    private final EmailValidator emailValidator;

    public String login(LoginRequest request) {
        boolean isValidEmail = emailValidator.test(request.getUsername());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        return adminService.loginAdmin(
                new Admin(
                        request.getUsername(),
                        request.getPassword()
                )
        );
    }
}

