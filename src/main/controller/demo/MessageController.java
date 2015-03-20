package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@RequestMapping("/message")
	public Message getMessage(){
		return new Message(1,"content");
	}

	@RequestMapping("/message/list")
	public Message[] getMessages(){
		Message m[] = {new Message(1,"content1"),
				new Message(2,"content2"),
				new Message(3,"content3"),
				new Message(4,"content4")};
		return m;
	}

}
