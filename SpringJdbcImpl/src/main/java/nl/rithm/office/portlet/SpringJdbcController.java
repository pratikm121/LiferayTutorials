package nl.rithm.office.portlet;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * @author admin
 */
@Controller
@RequestMapping("VIEW")
public class SpringJdbcController {
	
	@Autowired
	@Qualifier("rithmDataSource")
	private DataSource rithmDataSource;
	
	public void setRithmDataSource(DataSource rithmDataSource) {
		this.rithmDataSource = rithmDataSource;
	}



	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(rithmDataSource);
		List<Map<String,Object>> empRows = jdbcTemplate.queryForList("SELECT emp.employeenumber , emp.firstname , emp.lastname, c.officemobilenumber, c.officeemailaddress, d.country "
				+ "FROM EMPLOYEEPROFILE emp, EMPLOYEECONTACTDETAILS c, EMPLOYEEADDRESSDETAILS d "
				+ "WHERE emp.pkemployeeid = c.fkemployeeid AND emp.pkemployeeid = d.fkemployeeid ");
		
		System.out.println("Size = "+ empRows.size());
		
		return "view";
	}
}