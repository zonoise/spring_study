package demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping(value = "index" , method=RequestMethod.GET)
	public String index(Model model){
		Iterable<Post> posts = postRepository.findAll();
	    model.addAttribute("posts", posts);
		//model.addAttribute("messaae","aaaa");
		return "blog/index";
	}
	
	@RequestMapping(value = "/form" , method=RequestMethod.GET)
	public String form(Model m){
		Post fm = new Post();
		m.addAttribute("blog", fm);
		return "blog/form";
	}
	
	@RequestMapping("create")
	public String create(Model m,Post b){
		Post post = postRepository.save(b);
		m.addAttribute("blog",post);
		return "blog/create";
	}
	
}
