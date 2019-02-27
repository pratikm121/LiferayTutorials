package nl.pratik.liferay.tutorials.controller1;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class MyController {
private static final Logger logger = Logger.getLogger(MyController.class);
	
	@RenderMapping
	public String defaultPortlet1Render(RenderRequest renderRequest, RenderResponse renderResource , Model model) {
		
		renderRequest.setAttribute("name", "This is Portlet 2 JSP");		
		return "view";
	}
}
