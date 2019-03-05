package nl.rithm.office.commom.utils.model;

public class EmployeeContactDetails {
	
	private String officeMobileNumber;
	private String officeLandlineNumber;
	private String officeEmailAddress;
	private String personalEmailAddress;
	private String personalMobileNumber;
	
	
	@Override
	public String toString() {
		return "EmployeeContactDetails [officeMobileNumber=" + officeMobileNumber + ", officeLandlineNumber="
				+ officeLandlineNumber + ", officeEmailAddress=" + officeEmailAddress + ", personalEmailAddress="
				+ personalEmailAddress + ", personalMobileNumber=" + personalMobileNumber + "]";
	}
	public String getOfficeMobileNumber() {
		return officeMobileNumber;
	}
	public void setOfficeMobileNumber(String officeMobileNumber) {
		this.officeMobileNumber = officeMobileNumber;
	}
	public String getOfficeLandlineNumber() {
		return officeLandlineNumber;
	}
	public void setOfficeLandlineNumber(String officeLandlineNumber) {
		this.officeLandlineNumber = officeLandlineNumber;
	}
	public String getOfficeEmailAddress() {
		return officeEmailAddress;
	}
	public void setOfficeEmailAddress(String officeEmailAddress) {
		this.officeEmailAddress = officeEmailAddress;
	}
	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}
	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}
	public String getPersonalMobileNumber() {
		return personalMobileNumber;
	}
	public void setPersonalMobileNumber(String personalMobileNumber) {
		this.personalMobileNumber = personalMobileNumber;
	}
	
}
