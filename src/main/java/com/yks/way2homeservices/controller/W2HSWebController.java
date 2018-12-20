package com.yks.way2homeservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class W2HSWebController {

	@RequestMapping(value = { "/index","/" }, method = RequestMethod.GET)
	public String index(){
		return "index";
	}

	@RequestMapping(value = { "/booking-page" }, method = RequestMethod.GET)
	public String bookingpage(){
		return "booking-page";
	}
	@RequestMapping(value = { "/carpenter-services" }, method = RequestMethod.GET)
	public String carpenterservices(){
		return "carpenter-services";
	}
	@RequestMapping(value = { "/electrical-services" }, method = RequestMethod.GET)
	public String electricalservices(){
		return "electrical-services";
	}
	@RequestMapping(value = { "/interior-services" }, method = RequestMethod.GET)
	public String interiorservices(){
		return "interior-services";
	}
	@RequestMapping(value = { "/painting-services" }, method = RequestMethod.GET)
	public String paintingservices(){
		return "painting-services";
	}
	@RequestMapping(value = { "/plumber-services" }, method = RequestMethod.GET)
	public String plumberservices(){
		return "plumber-services";
	}
	@RequestMapping(value = { "/terms-and-conditions" }, method = RequestMethod.GET)
	public String termsandconditions(){
		return "terms-and-conditions";
	}
}