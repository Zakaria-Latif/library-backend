package com.example.library.signup;

import com.example.library.admin.Admin;
import com.example.library.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignupService {

    private final AdminService adminService;
    private final EmailValidator emailValidator;

    public String signup(SignupRequest request) {
        boolean isValidEmail = emailValidator.test(request.getUsername());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return adminService.signupAdmin(
                new Admin(
                        request.getName(),
                        request.getUsername(),
                        request.getPassword()
                )
        );
    }
}
