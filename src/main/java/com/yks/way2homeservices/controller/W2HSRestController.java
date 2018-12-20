package com.yks.way2homeservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yks.way2homeservices.model.CustomerBookingDetails;
import com.yks.way2homeservices.model.Status;
import com.yks.way2homeservices.model.Way2HomeExpection;
import com.yks.way2homeservices.services.ServicesImpl;

@RestController
@RequestMapping(value = "/api")
public class W2HSRestController {

	@Autowired
	private ServicesImpl servicesImpl;
	
	@RequestMapping(value = "/customerBookingDetails", method = RequestMethod.POST)
	@ResponseBody 
    public Status customerBookingDetails(@RequestBody CustomerBookingDetails customerBookingDetails) throws Way2HomeExpection{
		System.out.println(customerBookingDetails);
		return servicesImpl.updateCustomerBookingDetails(customerBookingDetails);
	}
} 