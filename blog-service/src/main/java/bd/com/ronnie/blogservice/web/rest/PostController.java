package bd.com.ronnie.blogservice.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "posts")
public class PostController {

    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }

}
