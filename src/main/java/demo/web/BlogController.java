package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@RequestMapping(value = "index" , method=RequestMethod.GET)
	public String index(Model model){
		//model.addAttribute("messaae","aaaa");
		return "blog/index";
	}
	
	@RequestMapping(value = "/form" , method=RequestMethod.GET)
	public String form(Model m){
		Blog fm = new Blog();
		m.addAttribute("blog", fm);
		return "blog/form";
	}
	
	@RequestMapping("create")
	public String create(Model m,Blog b){
		
		m.addAttribute("brog",b);
		return "blog/create";
	}
}
