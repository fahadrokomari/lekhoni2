package bd.com.ronnie.lekhoni2.authservice.service.security;

import bd.com.ronnie.lekhoni2.authservice.domain.User;
import bd.com.ronnie.lekhoni2.authservice.domain.common.CurrentUser;
import bd.com.ronnie.lekhoni2.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent()) {
            return new CurrentUser(user.get());
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
