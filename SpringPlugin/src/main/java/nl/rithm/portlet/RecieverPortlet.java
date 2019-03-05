package nl.rithm.portlet;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import nl.rithm.office.commom.utils.model.EmployeeProfile;
import nl.rithm.office.commom.utils.sql.EmployeeProfileSQL;

/**
 * @author admin
 */
@Controller
@RequestMapping("VIEW")
public class RecieverPortlet extends MVCPortlet{
	
	private static final Logger logger = Logger.getLogger(RecieverPortlet.class);

	@RenderMapping
	public String view(RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException, SQLException, NamingException {
		logger.warn("Insides View methods of Recevier");
		User currentUser = PortalUtil.getUser(renderRequest);
		PortletSession session = renderRequest.getPortletSession();
		EmployeeProfileSQL employeeProfileSQL = new EmployeeProfileSQL();
		
		if(currentUser !=null) {
			logger.warn("currentUser="+ currentUser.getFirstName() + " " + currentUser.getLastName());
			logger.warn("CompanyId="+ currentUser.getCompanyId() + " ContactId=" + currentUser.getContactId());
			logger.warn("DisplayEmailAddress="+ currentUser.getDisplayEmailAddress() + " EmailAddress=" + currentUser.getEmailAddress());
			logger.warn("Initials="+ currentUser.getInitials() + " JobTitle=" + currentUser.getJobTitle());
			logger.warn("Password="+ currentUser.getPassword() + " ScreenName=" + currentUser.getScreenName());
			
			EmployeeProfile emp = employeeProfileSQL.getEmployeeByName(currentUser.getFirstName(), currentUser.getLastName());
			
			if(emp !=null) {
				renderRequest.setAttribute("emp", emp);
			}
		}
		
		String employee =  (String) session.getAttribute("employee", PortletSession.APPLICATION_SCOPE);
		String employeeName =  (String) session.getAttribute("firstName", PortletSession.APPLICATION_SCOPE)
				+  (String) session.getAttribute("lastName", PortletSession.APPLICATION_SCOPE);
		
		logger.warn("employee="+employee);
		
		if(employee!=null){
	           renderRequest.setAttribute("employee", employee);
	           renderRequest.setAttribute("employeeName", employeeName);
		}
		
		
		
		return "view";
	}
}