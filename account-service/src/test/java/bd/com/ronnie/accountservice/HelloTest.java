package bd.com.ronnie.accountservice;

import bd.com.ronnie.accountservice.web.rest.HelloController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    @Test
    public void helloTest() {
        HelloController hc = new HelloController();
        String result = hc.hello();
        assertEquals(result, "Hello World!");
    }

}
