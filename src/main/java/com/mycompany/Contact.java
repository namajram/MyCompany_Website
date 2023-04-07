package com.mycompany;

import java.util.Date;

public class Contact{
	public Contact(String username, String emailAddress, String phoneNumber, Date timetocontact, String message) {
		super();
		this.username = username;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.timetocontact = timetocontact;
		this.message = message;
	}

	private String username;
	private String emailAddress;
	private String phoneNumber;
	private Date timetocontact;
	private String message;
	
	public Contact() {
		//TODO
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getTimetocontact() {
		return timetocontact;
	}

	public void setTimetocontact(Date timetocontact) {
		this.timetocontact = timetocontact;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [username=" + username + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
				+ ", timetocontact=" + timetocontact + ", message=" + message + "]";
	}
	
	
	
}