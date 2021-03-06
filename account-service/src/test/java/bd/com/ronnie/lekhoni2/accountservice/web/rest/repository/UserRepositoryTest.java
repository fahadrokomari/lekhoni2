package bd.com.ronnie.lekhoni2.accountservice.web.rest.repository;

import bd.com.ronnie.lekhoni2.accountservice.domain.User;
import bd.com.ronnie.lekhoni2.accountservice.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOneById_() {
        User user = createUserWithOutId();
        entityManager.persist(user);
        //Optional<User> user1 = userRepository.findOne(1L);
        User user1 = userRepository.findOne(1L);
    }

    private static final Long DEFAULT_ID = 1L;
    private static final String DEFAULT_EMAIL = "test@test.com";
    private static final String DEFAULT_FIRSTNAME = "john";
    private static final String DEFAULT_LASTNAME = "doe";
    //private static final UserStatus DEFAULT_STATUS = UserStatus.ACTIVE;
    private static final String DEFAULT_PHONE = "12345679";

    public static User createUserWithOutId() {
        User user = new User();
        user.setEmail(DEFAULT_EMAIL);
        user.setFirstName(DEFAULT_FIRSTNAME);
        user.setLastName(DEFAULT_LASTNAME);
        //user.setStatus(DEFAULT_STATUS);
        user.setPhone(DEFAULT_PHONE);
        return user;
    }

    public static User createUserWithId() {
        User user = createUserWithOutId();
        user.setId(DEFAULT_ID);
        return user;
    }

}
