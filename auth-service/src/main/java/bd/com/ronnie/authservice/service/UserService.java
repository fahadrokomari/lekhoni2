package bd.com.ronnie.authservice.service;

import bd.com.ronnie.authservice.domain.User;

import java.util.Optional;

public interface UserService {

    void create(User user);

    Optional<User> findByEmail(String email);

}
