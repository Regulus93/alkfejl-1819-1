package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.repository.UserRepository;
import elte.nevjegy.nevjegy.service.UserDetailsServiceImpl;
import elte.nevjegy.nevjegy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.register(user);
        if(savedUser == null){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(savedUser);
        }
    }

    @GetMapping("users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("getProfile")
    public ResponseEntity<User> getProfile(){
        return ResponseEntity.ok(userService.getProfile());
    }

    @PutMapping("updateProfile")
    public ResponseEntity<User> updateProfile(@RequestBody User updateUser) {
        return ResponseEntity.ok(userService.updateProfile(updateUser));
    }

    @DeleteMapping("superuser/deleteUser")
    public ResponseEntity<User> deleteUser(@RequestParam("id") int id){
        return ResponseEntity.ok(userService.deleteProfile(id));
    }

    @PutMapping("superuser/changeUserRole")
    public ResponseEntity<User> changeUserRole(@RequestBody User updateUser){
        return ResponseEntity.ok(userService.changeUserRole(updateUser));
    }


}
