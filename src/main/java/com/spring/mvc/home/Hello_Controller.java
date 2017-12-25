package com.spring.mvc.home;

import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.home.beans.ALLClass;
import com.spring.mvc.home.beans.Student;
import com.spring.mvc.home.mapping.UserDAOImpl;

//@Controller("controller")
@Controller
@RequestMapping(value="/controller")
public class Hello_Controller {

	@RequestMapping(value = "/welcome"/*, method = RequestMethod.GET*/)
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "hello world");
		return model;
	}
	
	@RequestMapping(value = "/hi/{userName}")
	public ModelAndView hieWorld(@PathVariable("userName") String name) {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "helloWorld userName = " + name);
		return model;
	}
	
	
	@RequestMapping(value = "/hiAdmissionForm", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,
											@RequestParam("studentHobby") String hobby) {
		Student student1 = new Student();
		student1.setBody(name);
		student1.setName(hobby);
		
		System.out.println("student name is ======     "+ student1.getName());
		System.out.println("student body is ======     " + student1.getBody());
		
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("headerMessage", "Gontu college of engineering, India");
		model.addObject("student1", student1);
//		model.addObject("student1.studentName", student1.getName());
//		model.addObject("student1.studentHobby", student1.getBody());
		return model;
	}
	
	
	@RequestMapping(value = "/submitAdmissionForm", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1) {
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("headerMessage", "Gontu College of Engineering, India");
		return model;
	}
	
	@RequestMapping(value = "/registerLeadForm", method = RequestMethod.GET)
	public ModelAndView registerLead() {
		ModelAndView model = new ModelAndView("RegisterLead");
		return model;
	}
	
	@RequestMapping(value = "/fetchALLOnBatchId/{batchID}", method = RequestMethod.GET)
	public ModelAndView fetchALLOnBatchId(@RequestParam("batchID") String id) {
		System.out.println("here is batch id = " + id);
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.startConnection();  
		int ids =  Integer.parseInt(id);
		ALLClass allCl = userDAO.readALL(ids);
		System.out.println("batch id is = " + allCl.getBatchID());
		System.out.println("track is = " + allCl.getTrack());
		ModelAndView model = new ModelAndView("ShowAll");
		model.addObject("headerMessage", "ALL details are displayed below");
		model.addObject("allClass", allCl);
		userDAO.closeConnection();
		return model;
	}
	
	
	@RequestMapping(value = "/RegisterUser", method = RequestMethod.POST)
	public ModelAndView regesterUser(@ModelAttribute("allClass") ALLClass allDATA) {
		ModelAndView model = new ModelAndView("RegisteredSuccess");
		/*Set<CampusMind> camp = new HashSet<CampusMind>();
		camp.add(new CampusMind());
		orh.setCampusMind(camp);*/
		UserDAOImpl userDAO = new UserDAOImpl();
		
		/*System.out.println("here is batch id ----------"+ orh.getBatchID());
		System.out.println("here is lead name-----------" + orh.getLead().getLeadName());
		System.out.println("here is campus mind name ------" + orh.getCampusMind().getCampusMindName());*/
		/*for(Lead rho : orh.getLead()) {
//			System.out.println(rho.getBatchID());
			System.out.println(rho.getLeadMID());
			System.out.println(rho.getTrack());
		}*/
		
	
		/*for(CampusMind cmp : orh.getCampusMind()) {
			System.out.println(cmp.getCampusMindMID());
			System.out.println(cmp.getCampusMindName());
			System.out.println(cmp.getTrack());
		}*/
//		System.out.println("here are lead details --------" + orh.getLead());
		System.out.println(allDATA.getBatchID());
		userDAO.startConnection();
		userDAO.add(allDATA);
		userDAO.closeConnection();
		return model;
	}
	
	@RequestMapping(value = "/deleteUserBatchId/{batchID}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@RequestParam("batchID") String id) {
		ModelAndView model = new ModelAndView("UserDeleted");
		model.addObject("id", id);
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.startConnection();
		userDAO.delete(id);		
		userDAO.closeConnection();
		return model;  
	}
	
	
	/*@RequestMapping(value = "/returnALLUser", method = RequestMethod.GET)
	public Response returnAll() {
		UserDAOImpl userD = new UserDAOImpl();
		Gson g = new Gson();
		String l = g.toJson(userD.getAllDetails());
		System.out.println();
		return ((ResponseBuilder) Response.status(200)).entity(1).build();
	}*/
	
	/*@RequestMapping(value = "/deleteRecord/{batchID}", method = RequestMethod.DELETE)
	public Response deleteRecord(@RequestParam int batchID) {
		UserDAOImpl userD = new UserDAOImpl();
		Gson g = new Gson();
		String l = g.toJson(userD.delete(batchID));
		return ((ResponseBuilder) Response.status(200)).entity(l).build();
	}*/
	
 
		 /*@RequestMapping(value = "/jsonResponse", method = RequestMethod.GET)
		 @Produces(MediaType)
//		 @Produces(MediaType.APPLICATION_ATOM_XML)
		 public List<Message> getMessage() 
			 	{
			       // return "Got it!";
			    	return messageService.getAllMessage();
			    } 
*/
	
}



/*
 * without annotation creating hello controller class is displayed below
 *
 * 
 * public class Hello_Controller extends AbstractController {
 * 
 *   
 * @Override protected ModelAndView handleRequestInternal(HttpServletRequest
 * arg0, HttpServletResponse arg1) throws Exception { ModelAndView modelAndView
 * = new ModelAndView("HelloPage"); modelAndView.addObject("welcomeMessage",
 * "Hi user, welcome to the first spring mvc application"); return modelAndView;
 * }
 * 
 * }
 */
