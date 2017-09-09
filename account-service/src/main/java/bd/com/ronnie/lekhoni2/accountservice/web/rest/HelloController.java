package bd.com.ronnie.lekhoni2.accountservice.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class HelloController {

    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return this.message;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

}
