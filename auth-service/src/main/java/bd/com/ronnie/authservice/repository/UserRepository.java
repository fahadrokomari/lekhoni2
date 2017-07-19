package bd.com.ronnie.authservice.repository;

import bd.com.ronnie.authservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
