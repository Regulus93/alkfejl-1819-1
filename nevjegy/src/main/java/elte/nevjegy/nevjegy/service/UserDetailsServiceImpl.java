package elte.nevjegy.nevjegy.service;

import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.enumtype.UserRole;
import elte.nevjegy.nevjegy.model.UserDao;
import elte.nevjegy.nevjegy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> oUser = userRepository.findByUserName(username);
        if(!oUser.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        User user = oUser.get();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }


    @Autowired
    private UserDao userDao;

    public User updateProfile(User user) {
        return userDao.updateProfile(user, passwordEncoder);
    }

    public User deleteProfile(int id) {
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
