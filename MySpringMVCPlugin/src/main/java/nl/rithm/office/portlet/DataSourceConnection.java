package nl.rithm.office.portlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DataSourceConnection {
	
	public String getData() throws SQLException, NamingException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String JNDI = "jdbc/rithmoffice";
		Context context = new InitialContext();
		Context envContext  = (Context)context.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup(JNDI);		
		conn = ds.getConnection();
		
	    if(conn !=null) {
	    	System.out.println("Got the connection");
	    }
	    String sql = "Select emp.employeenumber , emp.firstname , emp.lastname from EMPLOYEEPROFILE emp";
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    String output = null;
	    while(rs.next()){
	    	output = rs.getString("employeenumber") + " " + rs.getString("firstname") + " " +rs.getString("lastname");
	    	System.out.println("output= "+output);
	    }
	    rs.close();
	    
	    return output;
	}

}
