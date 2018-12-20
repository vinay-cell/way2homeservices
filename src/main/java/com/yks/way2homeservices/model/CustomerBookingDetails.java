package com.yks.way2homeservices.model;

public class CustomerBookingDetails extends AbstractDocument{
	
	private String customerArea;
	private String customerPincode;
	private String customerFullName;
	private String customerMobileNo;
	private String emailId;
	private String customerAddress;
	private String customerPrefferdDate;
	private String customerPrefferedTime;
	private String serviceName;
	private String requestType;
	private String lastName;
	private String textMsg;
	
	public String getCustomerArea() {
		return customerArea;
	}
	public void setCustomerArea(String customerArea) {
		this.customerArea = customerArea;
	}
	public String getCustomerPincode() {
		return customerPincode;
	}
	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}
	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPrefferdDate() {
		return customerPrefferdDate;
	}
	public void setCustomerPrefferdDate(String customerPrefferdDate) {
		this.customerPrefferdDate = customerPrefferdDate;
	}
	public String getCustomerPrefferedTime() {
		return customerPrefferedTime;
	}
	public void setCustomerPrefferedTime(String customerPrefferedTime) {
		this.customerPrefferedTime = customerPrefferedTime;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTextMsg() {
		return textMsg;
	}
	public void setTextMsg(String textMsg) {
		this.textMsg = textMsg;
	}
	@Override
	public String toString() {
		return "CustomerBookingDetails [customerArea=" + customerArea + ", customerPincode=" + customerPincode
				+ ", customerFullName=" + customerFullName + ", customerMobileNo=" + customerMobileNo + ", emailId="
				+ emailId + ", customerAddress=" + customerAddress + ", customerPrefferdDate=" + customerPrefferdDate
				+ ", customerPrefferedTime=" + customerPrefferedTime + ", serviceName=" + serviceName + ", requestType="
				+ requestType + ", lastName=" + lastName + ", textMsg=" + textMsg + "]";
	}	
}