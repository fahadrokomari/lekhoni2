package bd.com.ronnie.accountservice.web.rest;

import bd.com.ronnie.accountservice.domain.User;
import bd.com.ronnie.accountservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    /*@PostMapping("")
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }*/

    @GetMapping("{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    /*@PutMapping("{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }*/

}
