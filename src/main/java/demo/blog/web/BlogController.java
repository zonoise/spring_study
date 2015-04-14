package demo.blog.web;

import demo.blog.domain.Comment;
import demo.blog.domain.CommentRepository;
import demo.blog.domain.Post;
import demo.blog.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private static final Logger logger = LogManager.getLogger(BlogController.class);

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value = "index" , method=RequestMethod.GET)
    public String index(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog/index";
    }


    @RequestMapping(value = "detail" , method=RequestMethod.GET)
    public String detail(@RequestParam(required = false) Long id,Model model){

        if(id == null){
            logger.debug("id is null");
            return "redirect:/blog/index";
        }

        Post p = postRepository.findOne(id);
        logger.info("comments" + p.comments.toString());
        Comment c= new Comment();

        model.addAttribute("comment",c);
        model.addAttribute("post", p);
        return "blog/detail";
    }

    @RequestMapping(value = "/form" , method=RequestMethod.GET)
    public String form(Model m){
        Post fm = new Post();
        m.addAttribute("blog", fm);
        return "blog/form";
    }

    @RequestMapping("/create")
    public String create(Model m,Post b){
        Post post = postRepository.save(b);
        m.addAttribute("blog",post);
        return "redirect:/blog/index";
    }

    @RequestMapping(value = "/comment/create",method=RequestMethod.POST)
    public String create(Model m,RedirectAttributes r,@RequestParam(required = false) Long postId,Comment c){
        Post post =postRepository.findOne(postId);
        boolean status = false;
        post.comments.add(c);
        postRepository.save(post);
        r.addAttribute("id",post.getId());
        return "redirect:/blog/detail";
    }
}
