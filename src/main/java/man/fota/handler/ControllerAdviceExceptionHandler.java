package man.fota.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import man.fota.exception.BusinessException;

@RestControllerAdvice
public class ControllerAdviceExceptionHandler {
	
    @ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleAuthorityNotExistsException(BusinessException e, HttpServletResponse response){
		return ResponseEntity.badRequest().body(ResponseError.createResponseError(e));
	}

}