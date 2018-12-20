package com.yks.way2homeservices.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.yks.way2homeservices.model.CustomerBookingDetails;
import com.yks.way2homeservices.model.WAY2HOMEConstant;



@Service
public class CommunicationService {

	@Autowired
	private EmailService mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	public void sendEmail(final CustomerBookingDetails CustomerBookingDetails, final String subject){
		//mailSender.getJavaMailSenderImpl(wayToHomeMailSender).send(simpleMailMessage);

		MimeMessagePreparator preparator = new MimeMessagePreparator(){
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				//String[] To={userProductDetails.getEmailId(), WAY2HOMEConstant.wayToHomeService };
				message.setFrom(WAY2HOMEConstant.wayToHomeEmailId); // could be parameterized...
				message.setTo(CustomerBookingDetails.getEmailId());
				message.setCc(WAY2HOMEConstant.wayToHomeEmailId);
				message.setSubject(subject);
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("customerName", CustomerBookingDetails.getCustomerFullName());
				model.put("customerEmailID", CustomerBookingDetails.getEmailId());
				model.put("custmerArea", CustomerBookingDetails.getCustomerArea());
				/*model.put("customerAddress", CustomerBookingDetails.getCustomerAddress());*/
				model.put("customerMobileNumber", CustomerBookingDetails.getCustomerMobileNo());
				/*model.put("customerPinCode", CustomerBookingDetails.getCustomerPincode());*/
				/*model.put("customerPreferredDate", CustomerBookingDetails.getCustomerPrefferdDate());
				model.put("customerPreferredTime", CustomerBookingDetails.getCustomerPrefferedTime());*/
				model.put("serviceName", CustomerBookingDetails.getServiceName());
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/CustomerBookingMailTemplate.html", "UTF-8", model);
				message.setText(text, true); 

			}
		};
		this.mailSender.getJavaMailSenderImpl().send(preparator);

	}
public void sendEmailForContactUs(final CustomerBookingDetails customerBookingDetails, final String sUBJECT) {
		
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	            	
	                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               
	                message.setFrom(WAY2HOMEConstant.wayToHomeEmailId); // could be parameterized...
	                message.setTo(customerBookingDetails.getEmailId());
	                message.setCc(WAY2HOMEConstant.wayToHomeEmailId);
	                message.setSubject(sUBJECT);
	                Map<String, Object> model = new HashMap<String, Object>();
	                model.put("FirstName", customerBookingDetails.getCustomerFullName());
	                model.put("EmailId", customerBookingDetails.getEmailId());
	                model.put("LastName", customerBookingDetails.getLastName());
	                model.put("MobileNumber",customerBookingDetails.getCustomerMobileNo());
	                model.put("Text",customerBookingDetails.getTextMsg());
	               
	                 String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/ContactUsMailTemplate.html", "UTF-8", model);
	                message.setText(text, true);
	                
	            }
	        };
	        this.mailSender.getJavaMailSenderImpl().send(preparator);
	        
	    }

	public void sendSMS(String to,String body) {

		
		String authkey = "117047AsQ7JIBLlu57695ec2";
		//Multiple mobiles numbers separated by comma

		String mobiles = to;//userProductDetails.getCusomerMobileNo();
		//String mobiles1 =	WAY2HOMEConstant.wayToHomeServiceNo;

		String senderId = "WTHMSS";

		String message = URLEncoder.encode(body);//URLEncoder.encode("Thank you for contacting way2homeservices.Our team of managing experts will help you out to meet your needs.. as you would like to be treated.");

		String route="4";

		URLConnection myURLConnection=null;
		URL myURL=null;
		BufferedReader reader=null;


		String encoded_message=URLEncoder.encode(message);


		String mainUrl="https://control.msg91.com/api/sendhttp.php?";

		StringBuilder sbPostData= new StringBuilder(mainUrl);
		sbPostData.append("authkey="+authkey); 
		sbPostData.append("&mobiles="+mobiles);
		sbPostData.append("&message="+encoded_message);
		sbPostData.append("&route="+route);
		sbPostData.append("&sender="+senderId);

		mainUrl = sbPostData.toString();
		try
		{

			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

			String response;
			while ((response = reader.readLine()) != null) 

				System.out.println(response);


			reader.close();
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace();
		} 

	}
}
