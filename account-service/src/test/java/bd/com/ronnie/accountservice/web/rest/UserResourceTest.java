package bd.com.ronnie.accountservice.web.rest;

import bd.com.ronnie.accountservice.config.enumvalue.UserStatus;
import bd.com.ronnie.accountservice.domain.User;
import bd.com.ronnie.accountservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit testing for UserResource
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserResource.class)
public class UserResourceTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    private static final Long DEFAULT_ID = 1L;
    private static final String DEFAULT_EMAIL = "test@test.com";
    private static final String DEFAULT_FIRSTNAME = "john";
    private static final String DEFAULT_LASTNAME = "doe";
    private static final String DEFAULT_PASSWORD = "ABCDEFGHJIABCDEFGHJIABCDEFGHJIABCDEFGHJIABCDEFGHJIABCDEFGHJI";
    private static final UserStatus DEFAULT_STATUS = UserStatus.ACTIVE;
    private static final String DEFAULT_PHONE = "12345679";

    public static User createUserWithOutId() {
        User user = new User();
        user.setEmail(DEFAULT_EMAIL);
        user.setFirstName(DEFAULT_FIRSTNAME);
        user.setLastName(DEFAULT_LASTNAME);
        user.setPassword(DEFAULT_PASSWORD);
        user.setStatus(DEFAULT_STATUS);
        user.setPhone(DEFAULT_PHONE);
        return user;
    }

    public static User createUserWithId() {
        User user = createUserWithOutId();
        user.setId(DEFAULT_ID);
        return user;
    }

    @Test
    public void findOne_UserExists_ShouldGetUser() throws Exception {
        final User user = createUserWithId();
        when(userService.findOneById(1L))
                .thenReturn(Optional.of(user));
        mvc.perform(get("/users/1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void findOne_UserNotExists_ShouldGetNotFoundStatus() throws Exception {
        when(userService.findOneById(2L))
                .thenReturn(Optional.empty());
        mvc.perform(get("/users/2").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    // TODO : need to fix the issue with Pageable parameter
    @Test
    public void findAll_WhenUsersExist_ShouldReturnUsersList() throws Exception {
        final User user = createUserWithId();
        List<User> users = Arrays.asList(user);
        Page<User> page = new PageImpl<>(users, new PageRequest(0, 10), users.size());
        when(userService.findAll(any(PageRequest.class)))
                .thenReturn(page);
        mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void create_ValidUserPosted_ShouldCreateNewUser() throws Exception {
        final User user = createUserWithOutId();
        String json = mapper.writeValueAsString(user);
        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void create_IdNotNull_ShouldGiveBadRequest() throws Exception {
        final User user = createUserWithId();
        String json = mapper.writeValueAsString(user);
        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void update_ValidUserPosted_ShouldUpdateUser() throws Exception {
        final User user = createUserWithId();
        String json = mapper.writeValueAsString(user);
        mvc.perform(put("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void update_IdNull_ShouldGiveBadRequest() throws Exception {
        final User user = createUserWithOutId();
        String json = mapper.writeValueAsString(user);
        mvc.perform(put("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
}