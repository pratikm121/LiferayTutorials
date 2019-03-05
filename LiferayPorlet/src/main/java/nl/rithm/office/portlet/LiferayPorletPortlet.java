package nl.rithm.office.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import nl.rithm.office.common.LiferayPorletPortletKeys;

/**
 * @author admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LiferayPorletPortletKeys.LiferayPorlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LiferayPorletPortlet extends MVCPortlet {
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		
	/*	
		resourceResponse.setContentType("application/json");
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		
		System.out.println("Reource ID = "+resourceRequest.getResourceID());
		if("testAjaxResourceUrlId".equalsIgnoreCase(resourceRequest.getResourceID())) {
			System.out.println("sampleParam=" + ParamUtil.getString(resourceRequest, "sampleParam"));
			jsonObject.put("jsonResponse", "SampleValue="+ ParamUtil.getString(resourceRequest, "sampleParam") );
		}else if("formSubmitUrlId".equalsIgnoreCase(resourceRequest.getResourceID())) {
			System.out.println("name="+ParamUtil.getString(resourceRequest, "name"));
			System.out.println("email="+ParamUtil.getString(resourceRequest, "email"));
			jsonObject.put("output", "Your name="+ ParamUtil.getString(resourceRequest, "name") + ", Email="+ ParamUtil.getString(resourceRequest, "email"));
		}
		
		
		
		
		PrintWriter out = resourceResponse.getWriter();
		out.println(jsonObject.toJSONString());
		out.flush();
		super.serveResource(resourceRequest, resourceResponse);
		
		*/
	}
}

/*
 *<portlet:defineObjects />
 * <portlet:resourceURL var="testAjaxResourceUrl" id = "testAjaxResourceUrlId"></portlet:resourceURL>
<portlet:resourceURL var="formSubmitUrl" id = "formSubmitUrlId"></portlet:resourceURL>
 * <div id="targetId">
  <button type="submit" >Target Button <span ></span></button>
</div>

 <!-- OUR FORM class="form-group" class="form-control" class="btn btn-success" class="fa fa-arrow-right"-->
    <form action="" method="POST">

        <!-- NAME -->
        <div id="name-group" >
            <label for="name">Name</label>
            <input type="text"  name="name" placeholder="Henry Pym">
            <!-- errors will go here -->
        </div>

        <!-- EMAIL -->
        <div id="email-group" >
            <label for="email">Email</label>
            <input type="text" name="email" placeholder="rudd@avengers.com">
            <!-- errors will go here -->
        </div>

        <!-- SUPERHERO ALIAS -->
        <div id="superhero-group">
            <label for="superheroAlias">Superhero Alias</label>
            <input type="text" name="superheroAlias" placeholder="Ant Man">
            <!-- errors will go here -->
        </div>

        <button type="submit" >Submit <span ></span></button>

    </form>
 * <!-- 
$(document).ready(function() {
	
	 alert( "loadedd" );
	 
	// process the form
	    $('form').submit(function(event) {

	        // get the form data
	        // there are many ways to get this data using jQuery (you can use the class or id also)
	        

	        // process the form
	        $.ajax({
	            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	            url			: '${formSubmitUrl}', // the url where we want to POST
	            data: {
	            	   <portlet:namespace />name: $('input[name=name]').val(),
	            	   <portlet:namespace />email: $('input[name=email]').val(),
	               },
	               success: function(responseData) {
	                   alert(responseData.output);
	                   
	               }
	        })
	            // using the done promise callback
	            .done(function(data) {

	                // log data to the console so we can see
	                console.log(data); 

	                // here we will handle errors and validation messages
	            });

	        // stop the form from submitting the normal way and refreshing the page
	        event.preventDefault();
	    });
	 
	 
	 
	
	$( "#targetId" ).click(function() {
		console.log( "Handler for .click() called." );
		  $.ajax({
			  type: "POST",
			  url: '${testAjaxResourceUrl}',
			  data: {
           	   <portlet:namespace />sampleParam: 'value2',
              },
              success: function(responseData) {
                  alert(responseData.jsonResponse);
                  
              }
			});
		  
	});

});

-->*/
