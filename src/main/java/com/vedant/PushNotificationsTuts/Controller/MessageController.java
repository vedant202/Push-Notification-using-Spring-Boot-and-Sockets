package com.vedant.PushNotificationsTuts.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
	
	@Autowired
	SimpMessagingTemplate simpMessageTemplate; 
	
	@GetMapping("/")
	public String index() {
		System.out.println("Gettting Request");
		return "Index";
	}
	
//	Mapped as /app/application
	/*
	 * @MessageMapping("/application")
	 * 
	 * @SendTo("/all/messages") public Message send(final Message message) throws
	 * Exception {
	 * 
	 * System.out.println("Message :- "+message);
	 * 
	 * return message; }
	 */
	
	@MessageMapping("/application")
	@SendTo("/all/messages")
	public String send(@Payload String message) throws Exception {
		
		System.out.println("Message :- "+message);
		
		return message;
	}
	
	
	@MessageMapping("/private")
	public void sendToSpecificUser(@Payload MessageCust mess) {
		System.out.println(mess);
		simpMessageTemplate.convertAndSendToUser(mess.getTo(), "/specific", mess); 
	}
	
	

}
