package com.example.library.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public String signupAdmin(Admin admin) {
        boolean userExists = adminRepository.findByUsername(admin.getUsername()).isPresent();
        if(userExists) {
            throw new IllegalStateException("username already taken");
        }
        adminRepository.save(admin);
        Logger logger = Logger.getLogger(AdminService.class.getName());
        logger.info("saving new admin to database");

        return "admin has been registered successfully";
    }

    public String loginAdmin(Admin admin) {
        Optional<Admin> userExists = adminRepository.findByUsername(admin.getUsername());

        if(!userExists.isPresent()) {
            throw new IllegalStateException("username does not exist");
        }
        String password = admin.getPassword();
        String dbPassword = userExists.get().getPassword();

        System.out.println("password db: "+dbPassword);
        System.out.println("password admin encoded: "+password);
        if (Objects.equals(dbPassword, password)) {
            return "admin has been logged in successfully";
        }
        else {
            throw new IllegalStateException("password incorrect");
        }
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
