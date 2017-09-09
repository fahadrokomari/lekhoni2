package bd.com.ronnie.lekhoni2.accountservice.repository;

import bd.com.ronnie.lekhoni2.accountservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
