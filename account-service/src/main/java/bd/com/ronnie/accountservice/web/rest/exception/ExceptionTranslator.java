/*
package bd.com.ronnie.accountservice.web.rest.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

*/
/**
 * Controller advice to translate the server side exceptions to client-friendly json response
 *//*

@ControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

    */
/*@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<Object> handleTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String bodyOfResponse = "handle type mismatch exception";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }*//*


    */
/*@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        return new ErrorResponse("type mismatch exception", ex.getMessage());
    }*//*

}
*/
