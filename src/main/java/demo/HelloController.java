package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/" , method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("name","aadddaa");
		return "index";
	}
	
	@RequestMapping(value = "/error" , method=RequestMethod.GET)
	public String error(Model m){
		return "error";
	}
}
