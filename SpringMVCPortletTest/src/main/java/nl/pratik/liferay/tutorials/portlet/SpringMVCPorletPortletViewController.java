package nl.pratik.liferay.tutorials.portlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author Pratik Mehta
 */
@Controller
@RequestMapping("VIEW")
public class SpringMVCPorletPortletViewController {
	
	private static final Logger logger = Logger.getLogger(SpringMVCPorletPortletViewController.class);
	
	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		logger.warn("Inside View methods testing");
		request.setAttribute("myName", "Pratik Mehta");
		//request.getAttribute("XXX") is used for data passed onto this rendered view from any actionPhase.
		request.setAttribute("myParams", request.getAttribute("myParams"));
		request.setAttribute("myJaan", request.getAttribute("myJaan"));		 
		return "view";
	}
	
	/**
	 * Handles the view when the action is <code>anotherView</code>.
	 *
	 * @param  request the render request
	 * @param  response the render response
	 * @return the view result
	 **/
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
		System.out.println("==============");
		
		DataSourceConnection ds = new DataSourceConnection();		
		String myJaan = ds.getData();
		System.out.println("myJaan = "+myJaan);
		actionRequest.setAttribute(myJaan, myJaan);
		
		
	}

	
}