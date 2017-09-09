package bd.com.ronnie.lekhoni2.authservice.service;

import bd.com.ronnie.lekhoni2.authservice.domain.User;
import bd.com.ronnie.lekhoni2.authservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        User existing = userRepository.findOne(user.getId());
        Assert.isNull(existing, "user already exists: " + user.getEmail());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
