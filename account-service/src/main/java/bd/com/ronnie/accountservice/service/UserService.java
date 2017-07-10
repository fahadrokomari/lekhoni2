package bd.com.ronnie.accountservice.service;

import bd.com.ronnie.accountservice.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Optional<User> findOneById(Long id);

    Page<User> findAll(Pageable pageable);

    User save(User user);

    void delete(Long id);
}
