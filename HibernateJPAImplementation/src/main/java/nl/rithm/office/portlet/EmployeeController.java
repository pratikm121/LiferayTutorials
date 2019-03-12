package nl.rithm.office.portlet;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import nl.rithm.office.commom.utils.model.EmployeeProfile;

/**
 * @author admin
 */
@Controller
@RequestMapping("VIEW")
public class EmployeeController {
	
	private EntityManagerFactory entityManagerFactory;

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response, Model model) {
		System.out.println("Inside view");
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		System.out.println("entityManagerFactory = " + entityManagerFactory);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("entityManager transaction created= " + entityManager);
		
		@SuppressWarnings("unchecked")
		List<EmployeeProfile> listEmployee = entityManager.createQuery("Select e FROM EmployeeProfile e").getResultList();

		if (listEmployee == null) {
			System.out.println("No employee found . ");
		} else {
			for (EmployeeProfile empl : listEmployee) {
				System.out.println("Employee name= " + empl.getFirstName() + ", Employee id " + empl.getEmployeeId());
			}
		}
		
		EmployeeProfile emp = entityManager.find(EmployeeProfile.class, new BigDecimal("3"));
		System.out.println("Another Employee name = " + emp.getFirstName() + " " + emp.getLastName());
		model.addAttribute("emp", emp.getFirstName() + " " + emp.getLastName());
		return "view";
	}
}