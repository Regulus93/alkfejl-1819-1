package elte.nevjegy.nevjegy.model;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.enumtype.UserRole;
import elte.nevjegy.nevjegy.repository.BusinessCardRepository;
import elte.nevjegy.nevjegy.repository.FeedbackRepository;
import elte.nevjegy.nevjegy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessCardRepository businessCardRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(User user){
        Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());

        if(optionalUser.isPresent()){
            return null;
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(UserRole.ROLE_USER);
            return userRepository.save(user);
        }
    }

    public User updateProfile(User updateUser){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = userRepository.findByUserName(auth.getName())
                .orElseThrow(() -> new RuntimeException("No User found with the given id!"));

        if(updateUser.getUserName() != null) currentUser.setUserName(updateUser.getUserName());
        if(updateUser.getEmail() != null) currentUser.setEmail(updateUser.getEmail());
        if(updateUser.getFullName() != null) currentUser.setFullName(updateUser.getFullName());
        if(updateUser.getPassword() != null) currentUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        updateUser.setRole(UserRole.ROLE_USER);

        return userRepository.save(updateUser);
    }

    public User deleteProfile(int id){
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User found with the given id!"));

        List<Feedback> feedbacks = userToDelete.getFeedbacks();
        feedbackRepository.deleteAll(feedbacks);

        List<BusinessCard> cards = userToDelete.getBusinessCard();
        for (BusinessCard bc : cards){
            List<User> users = bc.getUser();
            users.remove(userToDelete);
            businessCardRepository.save(bc);
        }

        userRepository.delete(userToDelete);

        return userToDelete;
    }

    public User getProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUserName(auth.getName()).orElseThrow(() -> new RuntimeException("No User found with the given id!"));
    }

    public User changeUserRole(User updateUser) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(auth.getName()).orElseThrow(() -> new RuntimeException("No User found with the given id!"));
        user.setRole(updateUser.getRole());
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
