package bd.com.ronnie.accountservice.repository;

import bd.com.ronnie.accountservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
