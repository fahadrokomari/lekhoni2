package bd.com.ronnie.accountservice.web.rest;

import bd.com.ronnie.accountservice.domain.User;
import bd.com.ronnie.accountservice.service.UserService;
import bd.com.ronnie.accountservice.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String ENTITY_NAME = "user";

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /users/:id : get an user with id
     *
     * @param id the id of the user to retrieve
     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
     */
    @GetMapping("{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        log.debug("REST request to get User : {}", id);
        return userService.findOneById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * GET /users : get all the users
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with list of users in the body
     */
    @GetMapping("")
    public ResponseEntity<List<User>> findAll(Pageable pageable) {
        log.debug("REST request to get a page of Users");
        Page<User> page = userService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/v1/users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * POST /users : create an user
     *
     * @param user the entity to create
     * @return the ResponseEntity with status 200 (OK) and with the give user in the body, or (400) (BAD_REQUEST) if given user model's id is not null
     */
    @PostMapping("")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        log.debug("REST request to create an User : {}", user);
        if(user.getId() != null) {
            // TODO : need to implement a message alert utility which will be sent with the ResponseEntity
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User result = userService.save(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /**
     * PUT /users : update an existing user
     *
     * @param user the entity to update
     * @return the ResponseEntity with status 200 (OK) and with the give user in the body, or 400 (BAD_REQUEST)  if given user model's id is null
     */
    @PutMapping("")
    public ResponseEntity<User> update(@Valid @RequestBody User user) {
        log.debug("REST request to update an User : {}", user);
        if(user.getId() == null) {
            // TODO : need to implement a message alert utility which will be sent with the ResponseEntity
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User result = userService.save(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /**
     * DELETE /users/:id : delete an user
     *
     * @param id the id of the user to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("REST request to delete an User with ID : {}", id);
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
