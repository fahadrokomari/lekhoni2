package bd.com.ronnie.authservice.security;

import bd.com.ronnie.authservice.domain.User;
import bd.com.ronnie.authservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.Locale;
import java.util.Optional;

@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final UserRepository userRepository;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        log.debug("Authenticating {}", login);
        String lowerCaseLogin = login.toLowerCase(Locale.ENGLISH);
        Optional<User> userOptional = userRepository.findByEmail(lowerCaseLogin);
        return userOptional.map(user -> {
                    if(user.getA)
                }
        ).orElseThrow(() -> new RuntimeException());
    }
}
