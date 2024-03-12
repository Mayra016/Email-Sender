package com.email.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.Entity.EmailEntity;

@RestController
public class EmailController {
	
	@Autowired
	private JavaMailSender mail;
	@Value("${username}")
	String username;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailEntity emailJSON) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(emailJSON.receiver()); 
		email.setFrom(emailJSON.from());
		email.setSubject(emailJSON.subject());
		email.setText(emailJSON.body());

		mail.send(email);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
