package elte.nevjegy.nevjegy.repository;

import elte.nevjegy.nevjegy.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUserName(String username);
}
