package nl.pratik.liferay.tutorials.portlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;

import nl.pratik.liferay.tutorials.common.DataSourceConnection;

/**
 * @author Pratik Mehta
 */
@Controller
@RequestMapping("VIEW")
public class SpringMVCController {
	
	private static final Logger logger = Logger.getLogger(SpringMVCController.class);
	
	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		logger.warn("Inside View methods testing");
		return "view";
	}
	
	/**
	 * Handles the view when the action is <code>anotherView</code>.
	 **/
	@RenderMapping(params = "action=anotherView")
	public String anotherView(RenderRequest request, RenderResponse response) {
		logger.warn("Inside anotherView methods testing");
		return "anotherView";
	}
	
	/**
	 * Handles the action when the action key is <code>myAction</code>.
	 */
	@ActionMapping(params = "action=myAction")
	public void myAction(ActionRequest actionRequest, ActionResponse response) throws ReadOnlyException, ValidatorException, IOException, SQLException, ClassNotFoundException, NamingException {
		logger.warn("Inside myAction methods");
		logger.warn(ParamUtil.getString(actionRequest, "firstName"));		// For retreiving the values from JSP form data
		logger.warn(ParamUtil.getString(actionRequest, "lastName"));
		logger.warn(ParamUtil.getString(actionRequest, "username"));
		logger.warn(ParamUtil.getString(actionRequest, "email"));
		logger.warn(ParamUtil.getString(actionRequest, "hobbies"));
		actionRequest.setAttribute("myParam", ParamUtil.getString(actionRequest, "email"));
		System.out.println("==============");
		
		DataSourceConnection ds = new DataSourceConnection();		
		String myJaan = ds.getData();
		System.out.println("myJaan = "+myJaan);
		actionRequest.setAttribute(myJaan, myJaan);		
	}
	
	@ResourceMapping(value="myRestCallId")
    public void findStateForCountry(ResourceRequest request, ResourceResponse response) throws IOException  {
		String countryName = ParamUtil.getString(request, "mycountry");
		System.out.println("Got the rests call= "+countryName);
		
		JSONArray stateArray = JSONFactoryUtil.createJSONArray();
		JSONObject stateObject,stateObject2;
		
		if(countryName.equalsIgnoreCase("india")){
			System.out.println("Inside india");
			stateObject = JSONFactoryUtil.createJSONObject();
			stateObject.put("stateId", "1");
			stateObject.put("name", "West Bengal");
			
			stateObject2 = JSONFactoryUtil.createJSONObject();
			stateObject2.put("stateId", "2");
			stateObject2.put("name", "Maharastra");			
		}else{		
			System.out.println("Inside America");
			stateObject = JSONFactoryUtil.createJSONObject();
			stateObject.put("stateId", "21");
			stateObject.put("name", "LASS");
			
			stateObject2 = JSONFactoryUtil.createJSONObject();
			stateObject2.put("stateId", "22");
			stateObject2.put("name", "California");
		}
		    stateArray.put(stateObject);
		    stateArray.put(stateObject2);
		    response.getWriter().println(stateArray);
	}
	
}