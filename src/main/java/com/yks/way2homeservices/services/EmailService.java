package com.yks.way2homeservices.services;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	
	
	public JavaMailSenderImpl getJavaMailSenderImpl(){
		//These details are not working thats why using the folliwing details for few days
				JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
				javaMailSenderImpl.setHost("smtp.gmail.com");
				javaMailSenderImpl.setPort(587);
				javaMailSenderImpl.setUsername("waytohomeservices@gmail.com");
				javaMailSenderImpl.setPassword("w2hs123456");
				Properties javaMailProperties = new Properties();
				javaMailProperties.put("mail.smtp.auth", true);
				javaMailProperties.put("mail.smtp.starttls.enable",true);
				javaMailProperties.put("mail.smtp.quitwait", false);
				javaMailProperties.put("mail.smtp.user", "waytohomeservices@gmail.com");
				javaMailSenderImpl.setJavaMailProperties(javaMailProperties);
				//return javaMailSenderImpl;
				
				/*JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
				javaMailSenderImpl.setHost("smtp.emailsrvr.com");
				javaMailSenderImpl.setPort(587);
				javaMailSenderImpl.setUsername("ticket@etravelsmart.in");
				javaMailSenderImpl.setPassword("yks@2013");
				Properties javaMailProperties = new Properties();
				javaMailProperties.put("mail.smtp.auth", true);
		        javaMailProperties.put("mail.smtp.starttls.enable", false);
		        javaMailProperties.put("mail.smtp.quitwait", false);
		        javaMailProperties.put("mail.smtp.ssl.trust", "smtp.etravelsmart.com");
				javaMailSenderImpl.setJavaMailProperties(javaMailProperties);*/
				
				return javaMailSenderImpl;
	}

}
