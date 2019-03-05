package nl.rithm.office.commom.utils.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class EmployeeProfile {
	
	private BigDecimal employeeId;
	private String employeeNumber;
	private String initials;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private String jobDescription;	
	private List<EmployeeAddressDetails> addressList;
	private List<EmployeeContactDetails> contactList;	
	
	@Override
	public String toString() {
		return "EmployeeProfile [employeeId=" + employeeId + ", employeeNumber="+employeeNumber + ", initials=" + initials + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", dateOfJoining=" + dateOfJoining
				+ ", jobDescription=" + jobDescription + ", addressList=" + addressList + ", contactList=" + contactList
				+ "]";
	}
	
	public BigDecimal getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(BigDecimal employeeId) {
		this.employeeId = employeeId;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public List<EmployeeAddressDetails> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<EmployeeAddressDetails> addressList) {
		this.addressList = addressList;
	}
	public List<EmployeeContactDetails> getContactList() {
		return contactList;
	}
	public void setContactList(List<EmployeeContactDetails> contactList) {
		this.contactList = contactList;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}	
}
