package nl.rithm.office.commom.utils.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import nl.rithm.office.commom.utils.model.EmployeeAddressDetails;
import nl.rithm.office.commom.utils.model.EmployeeContactDetails;
import nl.rithm.office.commom.utils.model.EmployeeProfile;

public class EmployeeProfileSQL {
	
	public List<EmployeeProfile> getAllEmployees(Connection con) throws SQLException, NamingException{
		List<EmployeeProfile> employeeProfileList = new ArrayList<EmployeeProfile>();
		//con = DatabaseConnectionSetup.getConnection(ApplicationConstants.APPLICATION_DB);
		PreparedStatement ps = con.prepareStatement("SELECT emp.employeenumber , emp.firstname , emp.lastname, c.officemobilenumber, c.officeemailaddress, d.country "
													+ "FROM EMPLOYEEPROFILE emp, EMPLOYEECONTACTDETAILS c, EMPLOYEEADDRESSDETAILS d "
													+ "WHERE emp.pkemployeeid = c.fkemployeeid AND emp.pkemployeeid = d.fkemployeeid ");
		
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			EmployeeProfile emp = new EmployeeProfile();
			EmployeeContactDetails contact = new EmployeeContactDetails();
			EmployeeAddressDetails address = new EmployeeAddressDetails();
			List<EmployeeContactDetails> employeeContactList = new ArrayList<EmployeeContactDetails>();
			List<EmployeeAddressDetails> employeeAddressList = new ArrayList<EmployeeAddressDetails>();
			
			emp.setEmployeeNumber(rs.getString("employeenumber"));
			emp.setFirstName(rs.getString("firstname"));
			emp.setLastName(rs.getString("lastname"));
			contact.setOfficeMobileNumber(rs.getString("officemobilenumber"));
			contact.setOfficeEmailAddress(rs.getString("officeemailaddress"));
			address.setCountry(rs.getString("country"));
			
			
			employeeContactList.add(contact);
			employeeAddressList.add(address);
			emp.setAddressList(employeeAddressList);
			emp.setContactList(employeeContactList);
			employeeProfileList.add(emp);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return employeeProfileList;
		
	}
	
	public EmployeeProfile getEmployeeByName(Connection con,String employeeFirstName, String employeeLastName) throws SQLException, NamingException{
		EmployeeProfile emp = null;
		//Connection con = DatabaseConnectionSetup.getConnection(ApplicationConstants.APPLICATION_DB);
		PreparedStatement ps = con.prepareStatement("SELECT emp.employeenumber , emp.firstname , emp.lastname, c.officemobilenumber, c.officeemailaddress, d.country "
													+ "FROM EMPLOYEEPROFILE emp, EMPLOYEECONTACTDETAILS c, EMPLOYEEADDRESSDETAILS d "
													+ "WHERE emp.pkemployeeid = c.fkemployeeid AND emp.pkemployeeid = d.fkemployeeid AND emp.firstname = ? "
													+ "AND emp.lastname = ?");
		
		ps.setString(1, employeeFirstName);
		ps.setString(2, employeeLastName);
		
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			emp = new EmployeeProfile();
			EmployeeContactDetails contact = new EmployeeContactDetails();
			EmployeeAddressDetails address = new EmployeeAddressDetails();
			List<EmployeeContactDetails> employeeContactList = new ArrayList<EmployeeContactDetails>();
			List<EmployeeAddressDetails> employeeAddressList = new ArrayList<EmployeeAddressDetails>();
			
			emp.setEmployeeNumber(rs.getString("employeenumber"));
			emp.setFirstName(rs.getString("firstname"));
			emp.setLastName(rs.getString("lastname"));
			contact.setOfficeMobileNumber(rs.getString("officemobilenumber"));
			contact.setOfficeEmailAddress(rs.getString("officeemailaddress"));
			address.setCountry(rs.getString("country"));
			
			
			employeeContactList.add(contact);
			employeeAddressList.add(address);
			emp.setAddressList(employeeAddressList);
			emp.setContactList(employeeContactList);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return emp;
		
	}

}
