package nl.rithm.office.controller;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import nl.rithm.office.dto.FormData;

/**
 * @author admin
 */
@Controller
@RequestMapping("VIEW")
public class ContactFormController {

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		System.out.println("Form loaded");
		return "view";
	}
	
	@RenderMapping(params = "action=showForm")
	public String viewByParameter(Map<String, Object> map) {
	    System.out.println("##############Calling viewByParameter###########");
	 
	    FormData formData = new FormData();
	 
	    /**
	     * Keep the object customer in the map this object will be used in the
	     * JSP as modelAttribute
	     */
	    map.put("formData", formData);
	 
	    /**
	     * Returning a String "form"
	     *  This means that form.jsp is the view
	     */
	    return "form";
	 
	}
	
	@ActionMapping(value = "handleCustomer")
    public void getCustomerData(@ModelAttribute("formData") FormData formData, ActionRequest actionRequest, 
    		ActionResponse actionResponse, Model model) {
 
		System.out.println("#############Calling getCustomerData##########");
 
        actionResponse.setRenderParameter("action", "success");
 
        model.addAttribute("formData", formData);
    }
	
	@RenderMapping(params = "action=success")
	public String viewSuccess() {
	 
		System.out.println("#############Calling viewSuccess###########");
	    /**
	     * Display success.jsp
	     */
	    return "success";
	 
	}
}