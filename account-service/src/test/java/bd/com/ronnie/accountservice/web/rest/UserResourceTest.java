package bd.com.ronnie.accountservice.web.rest;


import bd.com.ronnie.accountservice.domain.User;
import bd.com.ronnie.accountservice.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class UserResourceTest {
    @InjectMocks
    private UserResource userResource;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOne() {
        final User user = new User();
        user.setId(1L);
        //when(userService.findOneById(user.getId())).thenReturn(user);
    }

}
