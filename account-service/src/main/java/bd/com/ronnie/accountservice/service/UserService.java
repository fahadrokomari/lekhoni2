package bd.com.ronnie.accountservice.service;

import bd.com.ronnie.accountservice.domain.User;

import java.util.List;

public interface UserService {

    User findOne(Long id);

    List<User> findAll();

}
