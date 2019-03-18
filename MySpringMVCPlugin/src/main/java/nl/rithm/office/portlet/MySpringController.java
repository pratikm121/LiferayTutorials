package nl.rithm.office.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.PortletSession;
import javax.portlet.ValidatorException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import nl.rithm.office.commom.utils.ApplicationConstants;
import nl.rithm.office.commom.utils.db.DatabaseConnectionSetup;
import nl.rithm.office.commom.utils.model.EmployeeProfile;
import nl.rithm.office.commom.utils.sql.EmployeeProfileSQL;

/**
 * @author admin
 */
@Controller
@RequestMapping("VIEW")
public class MySpringController extends MVCPortlet{

private static final Logger logger = Logger.getLogger(MySpringController.class);
	

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		logger.warn("Insides View methods testing");
		request.setAttribute("myName", "Pratik Mehta");
		//request.getAttribute("XXX") is used for data passed onto this rendered view from any actionPhase.
		return "view";
	}
	
	/**
	 * Handles the view when the action is <code>anotherView</code>.
	 *
	 * @param  request the render request
	 * @param  response the render response
	 * @return the view result
	 * **/
	 
	@RenderMapping(params = "action=anotherView")
	public String anotherView(RenderRequest request, RenderResponse response) {
		logger.warn("Inside anotherView methods testing");
		return "anotherView";
	}
	
	
	/**
	 * Handles the action when the action key is <code>myAction</code>.
	 * @param  actionRequest the action request
	 * @param  response the action response
	 * @throws ReadOnlyException 
	 * @throws IOException 
	 * @throws ValidatorException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws NamingException 
	 * @throws Exception if an exception occurred
	 */
	@ActionMapping(params = "action=myAction")
	public void myAction(ActionRequest actionRequest, ActionResponse response) throws ReadOnlyException, ValidatorException, IOException, SQLException, ClassNotFoundException, NamingException {
		logger.warn("Inside myAction methods");
		logger.warn(ParamUtil.getString(actionRequest, "firstName"));		// For retreiving the values from JSP form data
		logger.warn(ParamUtil.getString(actionRequest, "lastName"));
		logger.warn(ParamUtil.getString(actionRequest, "username"));
		logger.warn(ParamUtil.getString(actionRequest, "email"));
		logger.warn(ParamUtil.getString(actionRequest, "hobbies"));
		PortletSession session = actionRequest.getPortletSession();
		
		session.setAttribute("firstName",ParamUtil.getString(actionRequest, "firstName"), PortletSession.APPLICATION_SCOPE);
		session.setAttribute("lastName",ParamUtil.getString(actionRequest, "lastName"), PortletSession.APPLICATION_SCOPE);
		
		Connection con = DatabaseConnectionSetup.getConnection(ApplicationConstants.APPLICATIONDB_JNDI);
		
		EmployeeProfileSQL employeeProfileSQL = new EmployeeProfileSQL();
		List<EmployeeProfile> employeeList = employeeProfileSQL.getAllEmployees(con);
		
		if(!employeeList.isEmpty()) {
			for(EmployeeProfile emp : employeeList) {
				logger.warn("employeenumber = "+ emp.getEmployeeNumber() + ", Office Mobile# ="+ emp.getContactList().get(0).getOfficeMobileNumber()
						+ ", Country ="+ emp.getAddressList().get(0).getCountry());
				session.setAttribute("employee","employeenumber = "+ emp.getEmployeeNumber() + ", Office Mobile# ="+ emp.getContactList().get(0).getOfficeMobileNumber()
						+ ", Country ="+ emp.getAddressList().get(0).getCountry(), PortletSession.APPLICATION_SCOPE);
			}
			
		}
	}

	@Override
	@ResourceMapping(value="resourceURLId")
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,PortletException {
 
        /**
         * Read data sent by AJAX
         */
		System.out.println("Inside");
		
		JSONObject stateObject= JSONFactoryUtil.createJSONObject();
		
		String site = ParamUtil.getString(resourceRequest, "site");
        String author = ParamUtil.getString(resourceRequest, "author");
 
        System.out.println("The value of site parameter sent by AJAX  "+site);
        System.out.println("The value of author parameter sent by AJAX  "+author);
        
        stateObject.put("output", site + "/"+author);
        
        resourceResponse.getWriter().println(stateObject);
    }  
	
	@ResourceMapping(value="resourceURLId2")
    public void serveResource2(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,PortletException {
 
        /**
         * Read data sent by AJAX
         */
		System.out.println("Inside2");
		
		JSONObject stateObject= JSONFactoryUtil.createJSONObject();
		
		String site = ParamUtil.getString(resourceRequest, "site");
        String author = ParamUtil.getString(resourceRequest, "author");
 
        System.out.println("The value of site parameter sent by AJAX  "+site);
        System.out.println("The value of author parameter sent by AJAX  "+author);
        
        stateObject.put("output", site + "-"+author);
        resourceResponse.setProperty("output", site + "-"+author);
        
        resourceResponse.getWriter().println(stateObject); 
        
    }  
	
	
	
	
}