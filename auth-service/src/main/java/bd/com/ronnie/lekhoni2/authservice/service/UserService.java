package bd.com.ronnie.lekhoni2.authservice.service;

import bd.com.ronnie.lekhoni2.authservice.domain.User;

import java.util.Optional;

public interface UserService {

    void create(User user);

    Optional<User> findByEmail(String email);

}
