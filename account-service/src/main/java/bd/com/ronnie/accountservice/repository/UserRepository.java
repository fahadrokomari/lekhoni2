package bd.com.ronnie.accountservice.repository;

import bd.com.ronnie.accountservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findOneById(Long id);

    User findOneById(Long id);

}
