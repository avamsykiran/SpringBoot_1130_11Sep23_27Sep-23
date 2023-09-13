package com.cts.sbdd.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customerPNR;
    private String fullName;
    private String mobileNumber;
    private String mailId;
    private LocalDate registrationDate;

    public Customer() {
    	
    }

	public Long getCustomerPNR() {
		return customerPNR;
	}

	public void setCustomerPNR(Long customerPNR) {
		this.customerPNR = customerPNR;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "Customer [customerPNR=" + customerPNR + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
				+ ", mailId=" + mailId + ", registrationDate=" + registrationDate + "]";
	}
    
    
}