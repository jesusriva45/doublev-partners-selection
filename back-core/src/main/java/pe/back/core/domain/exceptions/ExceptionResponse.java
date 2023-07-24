package pe.back.core.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse<T> {

    private String message_ex;

    private String message;

    private HttpStatus httpStatus;

    private Object data;


    public String getMessage_ex() {
        return message_ex;
    }

    public void setMessage_ex(String message_ex) {
        this.message_ex = message_ex;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ExceptionResponse(String message, HttpStatus httpStatus, Object data) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
    }

    public ExceptionResponse(String message_ex, String message, HttpStatus httpStatus, Object data) {
        this.message_ex = message_ex;
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
    }
}
