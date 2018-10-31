package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.repository.UserRepository;
import elte.nevjegy.nevjegy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        Optional<User> oUser = userRepository.findByUserName(user.getUserName());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("users")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
