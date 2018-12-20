package com.yks.way2homeservices.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yks.way2homeservices.dao.CustomerBookingDetailsDAO;
import com.yks.way2homeservices.model.CustomerBookingDetails;
import com.yks.way2homeservices.model.Status;
import com.yks.way2homeservices.model.WAY2HOMEConstant;
import com.yks.way2homeservices.model.Way2HomeExpection;

@Service
public class ServicesImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(ServicesImpl.class);
	
	@Autowired
	private CustomerBookingDetailsDAO CustomerBookingDetailsDAO;
	
	@Autowired
	private CommunicationService communicationService;
	
	

	public  Status updateCustomerBookingDetails(CustomerBookingDetails customerBookingDetails) throws Way2HomeExpection{
		logger.info(customerBookingDetails.toString());
		Status status = new Status();
		status.setCode(-1);
		status.setMessage("Dear Customer you request has been denied for some technical reason !! Please try again !!");
		status.setStatus(WAY2HOMEConstant.status.FAIL.name());
		boolean updatedCount = CustomerBookingDetailsDAO.save(customerBookingDetails).getId()!=null;
		if(updatedCount){
			if(customerBookingDetails.getRequestType().equalsIgnoreCase(WAY2HOMEConstant.REQUEST_TYPE.BOOKING.name())){

				communicationService.sendEmail(customerBookingDetails,WAY2HOMEConstant.BookingSubject+customerBookingDetails.getServiceName()+" service.");
				communicationService.sendSMS(customerBookingDetails.getCustomerMobileNo(),WAY2HOMEConstant.ContactUsSMSThankYouMessage);
				String smsMessage=WAY2HOMEConstant.W2HSBookingSMS.replace("SERVICE",customerBookingDetails.getServiceName()).replace("NAME", customerBookingDetails.getCustomerFullName()).replace("MOBILE", customerBookingDetails.getCustomerMobileNo()).replace("EMAIL",customerBookingDetails.getEmailId());
				communicationService.sendSMS(WAY2HOMEConstant.wayToHomeServiceNo,smsMessage);
				
			}else {
				
				communicationService.sendEmailForContactUs(customerBookingDetails, WAY2HOMEConstant.ContactUsSubject);
				communicationService.sendSMS(customerBookingDetails.getCustomerMobileNo(),WAY2HOMEConstant.ContactUsSMSThankYouMessage);
				String smsMessage=WAY2HOMEConstant.W2HSContactUsSMS.replace("NAME", customerBookingDetails.getCustomerFullName()).replace("MOBILE", customerBookingDetails.getCustomerMobileNo()).replace("EMAIL",customerBookingDetails.getEmailId());
				communicationService.sendSMS(WAY2HOMEConstant.wayToHomeServiceNo,smsMessage);
			}
			status.setCode(100);
			status.setMessage("Dear Customer, Thank You for contacting Way2HomeServices.Our expert team will contact you immediately.");
			status.setStatus(WAY2HOMEConstant.status.SUCCESS.name());
		}
		return status;
	}

}
