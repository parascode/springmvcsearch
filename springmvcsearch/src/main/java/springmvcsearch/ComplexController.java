package springmvcsearch;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComplexController {

	@RequestMapping("/complex")
	public String showForm() {
		System.out.println("Showing complex form");
		return "complex_form";
	}
	@RequestMapping(path = "handle", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("hasError", "yes");
			return "complex_form";
		}
		System.out.println("Form submitted.");
		System.out.println(student);
		return "success";
	}
}
