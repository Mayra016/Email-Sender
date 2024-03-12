package com.email;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.email.Controllers.EmailController;
import com.email.Entity.EmailEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmailControllerTest {
	
	@Mock
    private JavaMailSender mailSender;
	
	@InjectMocks
	EmailController controller;
	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void sendEmailTest() {
        EmailEntity emailEntity = new EmailEntity("mailtrap@demomailtrap.com", "example@gmail.com", "Test Subject", "Test Body");

        Mockito.doNothing().when(mailSender).send(Mockito.any(SimpleMailMessage.class));

        ResponseEntity<?> responseEntity = controller.sendEmail(emailEntity);

        Mockito.verify(mailSender).send(Mockito.any(SimpleMailMessage.class));

        // Verify that the controller returned a ResponseEntity with status OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
	}
	
	@Test
	public void sendEmailMailTrap() {
		EmailEntity emailEntity = new EmailEntity("mailtrap@demomailtrap.com", "example@gmail.com", "Test Subject", "Test Body");
		controller.sendEmail(emailEntity);
	}

}
