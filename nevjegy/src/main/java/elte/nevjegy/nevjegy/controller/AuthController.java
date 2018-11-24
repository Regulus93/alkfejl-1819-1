package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.repository.UserRepository;
import elte.nevjegy.nevjegy.security.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    Session session;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> dbUser =
                userRepository.findByUserName(user.getUserName());
        if (dbUser.isPresent() && passwordEncoder.matches(user.getPassword(),
                dbUser.get().getPassword())) {
            session.setUser(dbUser.get());
            return ResponseEntity.ok(dbUser.get());
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @RequestMapping("/logout")
    public ResponseEntity logout() {
        session.setUser(null);
        return ResponseEntity.ok(false);
    }

    @GetMapping("/user")
    public ResponseEntity getUser() {
        if (session.getUser() == null) {
            return ResponseEntity.ok(false);
        } else {
            return ResponseEntity.ok(session.getUser());
        }
    }
}
