package elte.nevjegy.nevjegy.service;

import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.model.UserDao;
import elte.nevjegy.nevjegy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;

    public User updateProfile(User user) throws Exception {
        return userDao.updateProfile(user, passwordEncoder);
    }

    public User deleteProfile(int id) throws Exception {
        return userDao.deleteProfile(id);
    }

    public User getProfile() {
        return userDao.getProfile();
    }

    public User register(User user) {
        return userDao.register(user, passwordEncoder);
    }

    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    public User changeUserRole(User updateUser) {
        return userDao.changeUserRole(updateUser);
    }

}
