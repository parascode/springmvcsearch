package springmvcsearch;

import javax.websocket.Session;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping("/home")
	public String home(Model m) {
		System.out.println("Showing home page");
		
		
//		m.addAttribute("Msg", "hello");
//		String s = null;
//		System.out.println(s.length());
		return "home";
	}
	@RequestMapping("/home/{userId}/{userName}")
	public String getUserDetails(@PathVariable("userId") int userId, @PathVariable("userName") String userName) {
		System.out.println("UserId: " + userId);
		System.out.println("UserName: "+ userName);
		Integer.parseInt(userName);
		return "home";
	}
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("searchQuery") String query, Model model) {
		
		
		RedirectView redirectView = new RedirectView();
		String msg = "Please enter keyword";
		if(query.isBlank()) {
			System.out.println(msg);
//			redirectView.addStaticAttribute("Msg", msg);
//			attributes.addAttribute("Msg", msg);
			model.addAttribute("Msg", msg);
			redirectView.setUrl("home");
			return redirectView;
		}
		
		String url = "https://www.google.com/search?q=" + query;
		redirectView.setUrl(url);
		
		return redirectView;
	}
	/*
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public String exceptionHandlerNullPointer(Model m) {
		m.addAttribute("msg", "Null Pointer Exception occured!!");
		return "error_page";
	}
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandlerNumberFormat(Model m) {
		m.addAttribute("msg", "Number Format Exception occured!!");
		return "error_page";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Model m) {
		m.addAttribute("msg", "Exception occured!!");
		return "error_page";
	}
	*/
}
