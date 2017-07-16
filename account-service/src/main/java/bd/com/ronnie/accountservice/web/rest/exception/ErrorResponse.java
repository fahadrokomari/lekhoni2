package bd.com.ronnie.accountservice.web.rest.exception;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Timestamp timestamp = new Timestamp(new Date().getTime());
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;

    public ErrorResponse() {
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
