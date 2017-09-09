package bd.com.ronnie.lekhoni2.blogservice.web.rest;

import bd.com.ronnie.lekhoni2.blogservice.domain.Post;
import bd.com.ronnie.lekhoni2.blogservice.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(value = "posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String ENTITY_NAME = "post";

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * GET /posts/:id : get an post with id
     *
     * @param id the id of the post to retrieve
     * @return the ResponseEntity with 200 HttpStatus if user found, otherwise 404 HttpStatus
     */
    @GetMapping("{id}")
    public ResponseEntity<Post> findOne(@PathVariable Long id) {
        log.debug("REST request to get Post : {}", id);
        Post post = postService.findOne(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    /**
     * GET /posts : Get a page of Post for optionally given tag
     *
     * @param pageable Pageable information
     * @param tag Tag of Post. This is an optional parameter. If not given, no tag name will be checked
     * @return ResponseEntity containing list of Posts with OK(200) HttpStatus
     */
    @GetMapping(value = "")
    public ResponseEntity<List<Post>> findAll(Pageable pageable, @RequestParam(required = false) String tag) {
        log.debug("REST request to get a page of Posts");
        Page<Post> posts = postService.findByTagsName(tag, pageable);
        // TODO use pagination util as like as UserController.findAll()
        //HttpHeaders headers = Pagination
        return new ResponseEntity<>(posts.getContent(), HttpStatus.OK);
    }

    /**
     * POST /posts : Create a new Post
     *
     * @param post The Post object to create
     * @return ResponseEntity containing newly created Post with OK(200) HttpStatus for success case
     * and BadRequest(400) HttpStatus for failure case
     */
    @PostMapping(value = "")
    public ResponseEntity<Post> create(@Valid @RequestBody Post post) {
        log.debug("REST request to create an post : {}", post);
        if(post.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Post result = postService.save(post);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /**
     * PUT /posts : Update an existing Post
     *
     * @param post Updated Post object
     * @return ResponseEntity containing updated Post with OK(200) HttpStatus for success case
     * and BadRequest(400) HttpStatus for failure case
     */
    @PutMapping(value = "")
    public ResponseEntity<Post> update(@Valid @RequestBody Post post) {
        log.debug("REST request to update an post : {}", post);
        if(post.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Post result = postService.save(post);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /**
     * DELETE /posts/:id : Delete a post
     *
     * @param id id of the post to delete
     * @return ResponseEntity with status 200(OK)
     */
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("REST request to delete an Post with ID : {}", id);
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
