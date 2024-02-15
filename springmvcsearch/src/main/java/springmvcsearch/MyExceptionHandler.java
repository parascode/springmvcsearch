package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public String exceptionHandlerNullPointer(Model m) {
		m.addAttribute("msg", "Null Pointer Exception occured!! (From ControllerAdvice)");
		return "error_page";
	}
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandlerNumberFormat(Model m) {
		m.addAttribute("msg", "Number Format Exception occured!! (From ControllerAdvice)");
		return "error_page";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Model m) {
		m.addAttribute("msg", "Exception found (From ControllerAdvice)");
		return "error_page";
	}


}
