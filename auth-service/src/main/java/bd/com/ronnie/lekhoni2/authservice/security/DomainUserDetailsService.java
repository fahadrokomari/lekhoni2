package bd.com.ronnie.lekhoni2.authservice.security;

import bd.com.ronnie.lekhoni2.authservice.domain.User;
import bd.com.ronnie.lekhoni2.authservice.repository.UserRepository;
import bd.com.ronnie.lekhoni2.authservice.security.exception.UserNotActivatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

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
        String loginLowerCase = login.toLowerCase(Locale.ENGLISH);
        Optional<User> userOptional = userRepository.findByEmail(loginLowerCase);

        return userOptional.map(
                user -> {
                    if (!user.getIsActivated()) {
                        throw new UserNotActivatedException("User " + loginLowerCase + " is not yet activated.");
                    } else {
                        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                                .collect(Collectors.toList());
                        return new org.springframework.security.core.userdetails.User(loginLowerCase, user.getPassword(), grantedAuthorities);
                    }
                }
        ).orElseThrow(() -> new UsernameNotFoundException("User " + loginLowerCase + " was not found in database."));

    }
}
