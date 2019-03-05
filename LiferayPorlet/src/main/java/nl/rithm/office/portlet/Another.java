package nl.rithm.office.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import nl.rithm.office.commom.utils.model.EmployeeProfile;
import nl.rithm.office.commom.utils.sql.EmployeeProfileSQL;
import nl.rithm.office.common.LiferayPorletPortletKeys;


 
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.social",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/myProfile.jsp",
		"javax.portlet.name=AnotherPorlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)


public class Another extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		
		System.out.println("Reached again in Another Portlet");
		resourceResponse.setContentType("application/json");
		//JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		
		/*resourceRequest.getResourceID() is required if you have multiple AJAX calls for same portlet.
		 * So for each reourceId you can configure actions
		 */
		
		
		if("profileUrlId".equalsIgnoreCase(resourceRequest.getResourceID())) {
			
			// This is used to get paramvalues passed from the jsp. For example retrieving values submitted in a form
			System.out.println("sampleParam=" + ParamUtil.getString(resourceRequest, "sampleParam"));
			
			EmployeeProfileSQL employeeProfileSQL = new EmployeeProfileSQL();
			List<EmployeeProfile> employeeList = null;
			
			try {
				
				employeeList = employeeProfileSQL.getAllEmployees();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
			if(!employeeList.isEmpty()) {
				for(EmployeeProfile emp : employeeList) {
					System.out.println("employeenumber = "+ emp.getEmployeeNumber() +"Initials = "+ emp.getInitials() 
									   + ", Office Mobile# ="+ emp.getContactList().get(0).getOfficeMobileNumber()
									   + ", Country ="+ emp.getAddressList().get(0).getCountry());
					// Add all the objects in the list to JSON Array
					jsonArray.put(emp);
				}
			}
		}
		
		
		
		//Passing the output back to the AJAX call to show as response.
		PrintWriter out = resourceResponse.getWriter();
		out.println(jsonArray);
		out.flush();
		super.serveResource(resourceRequest, resourceResponse);
		
	}

}

/*
 *  
<portlet:defineObjects />

<portlet:resourceURL var="myProfileResourceUrl" id = "myProfileResourceUrlId"></portlet:resourceURL>
<script type="text/javascript">


</script>
 * <div id="targetId2">
  <button type="submit" >Target Button <span ></span></button>
</div>
 * <!--
$(document).ready(function() {
	
	
	 
	 $( "#targetId2" ).click(function() {
		    alert( "loadedd" );
			console.log( "Handler for .click() called." );
			  $.ajax({
				  type: "POST",
				  url: '${myProfileResourceUrl}',
				  data: {
	           	   <portlet:namespace />sampleParam: 'Got the value',
	              },
	              success: function(responseData) {
	                  console.log('got the data ='+responseData);
	              }
				});
			  
		});
	 
	

});

-->*/
