package elte.nevjegy.nevjegy.service;

import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.model.UserDao;
import elte.nevjegy.nevjegy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User updateProfile(User user) {
        return userDao.updateProfile(user);
    }

    public User deleteProfile(int id) {
        return userDao.deleteProfile(id);
    }

    public User getProfile() {
        return userDao.getProfile();
    }

    public User register(User user) {
        return userDao.register(user);
    }

    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    public User changeUserRole(User updateUser) {
        return userDao.changeUserRole(updateUser);
    }
}
