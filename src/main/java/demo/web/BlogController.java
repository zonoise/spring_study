//package demo.web;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/blog")
//public class BlogController {
//	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
//
//	@Autowired
//    dPostRepository postRepository;
//
//	@RequestMapping(value = "index" , method=RequestMethod.GET)
//	public String index(Model model){
//		Iterable<dPost> posts = postRepository.findAll();
//	    model.addAttribute("posts", posts);
//		//model.addAttribute("messaae","aaaa");
//		return "blog/index";
//	}
//
//	@RequestMapping(value = "/form" , method=RequestMethod.GET)
//	public String form(Model m){
//		dPost fm = new dPost();
//		m.addAttribute("blog", fm);
//		return "blog/form";
//	}
//
//	@RequestMapping("create")
//	public String create(Model m,dPost b){
//		dPost post = postRepository.save(b);
//
//		dPost p2 = new dPost();
//		p2.setTitle("aaaa");
//		postRepository.save(p2);
//		logger.debug("aaaaa");
//		m.addAttribute("blog",post);
//        return "redirect:/blog/index";
//	}
//
//}
