package bd.com.ronnie.authservice.web.rest;

import bd.com.ronnie.authservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.security.Principal;

@RestController
//@RequestMapping("users")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String ENTITY_NAME = "user";

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @GetMapping(value = "admin/test")
    public String getUser() {
        return "Admin page";
    }



}
