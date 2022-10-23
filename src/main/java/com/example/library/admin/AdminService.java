package com.example.library.admin;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user with username " + username + " not found"));
    }

    public String signupAdmin(Admin admin) {
        boolean userExists = adminRepository.findByUsername(admin.getUsername()).isPresent();
        if(userExists) {
            throw new IllegalStateException("username already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(admin.getPassword());

        admin.setPassword(encodedPassword);

        adminRepository.save(admin);
        Logger logger = Logger.getLogger(AdminService.class.getName());
        logger.info("saving new admin to database");

        return "admin has been registered successfully";
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
