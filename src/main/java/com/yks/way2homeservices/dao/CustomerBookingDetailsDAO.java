package com.yks.way2homeservices.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.yks.way2homeservices.model.CustomerBookingDetails;

@Repository
public interface CustomerBookingDetailsDAO extends PagingAndSortingRepository<CustomerBookingDetails, Serializable>{
	
	
}
