package bd.com.ronnie.accountservice.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/api/v1")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

}
