package az.developia.az.developia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionError {
	@ExceptionHandler(MyException.class)
	public ResponseEntity<String> handleMyException(MyException ex) {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
	    StringBuilder erBuilder = new StringBuilder("Ошибка валидации: ");
	    ex.getBindingResult().getAllErrors().forEach(error -> {
	        erBuilder.append(error.getDefaultMessage()).append("; ");
	    });
	    return ResponseEntity.badRequest().body(erBuilder.toString());
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}

	
}
