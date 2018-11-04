package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.enumtype.UserRole;
import elte.nevjegy.nevjegy.repository.UserRepository;
import elte.nevjegy.nevjegy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> oUser = userRepository.findByUserName(user.getUserName());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("getProfile")
    public User getProfile(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUserName(auth.getPrincipal().toString()).get();
    }

    @PutMapping("updateProfile")
    public void updateProfile(@RequestBody User updateUser) {
        User user = userRepository.findByUserName(updateUser.getUserName())
                .orElseThrow(() -> new RuntimeException("No User found with the given id!"));

        if(updateUser.getUserName() != null) user.setUserName(updateUser.getUserName());
        if(updateUser.getEmail() != null) user.setEmail(updateUser.getEmail());
        if(updateUser.getFullName() != null) user.setFullName(updateUser.getFullName());

        userRepository.save(user);
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(@RequestParam("Id") int id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(userRepository.findByUserName(auth.getPrincipal().toString()).get().getRole() == UserRole.ROLE_USER)
            id = userRepository.findByUserName(auth.getPrincipal().toString()).get().getId();
        userRepository.deleteById(id);
    }

    @PutMapping("changeUserRole")
    public void changeUserRole(@RequestBody User updateUser){
        User user = userRepository.findByUserName(updateUser.getUserName()).get();
        user.setRole(updateUser.getRole());
        userRepository.save(user);
    }


}
