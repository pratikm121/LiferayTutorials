package nl.rithm.office.dto;

import java.io.Serializable;
import java.sql.Date;

public class FormData implements Serializable{
 
    private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String initials;
	private String personalEmailId;
	private String officeEmailId;
	private String jobDescription;
	private String gender;
	private String personalMobileNumber;
	private String dob;
	private String doj ;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getPersonalEmailId() {
		return personalEmailId;
	}
	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}
	public String getOfficeEmailId() {
		return officeEmailId;
	}
	public void setOfficeEmailId(String officeEmailId) {
		this.officeEmailId = officeEmailId;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPersonalMobileNumber() {
		return personalMobileNumber;
	}
	public void setPersonalMobileNumber(String personalMobileNumber) {
		this.personalMobileNumber = personalMobileNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	
	

}
