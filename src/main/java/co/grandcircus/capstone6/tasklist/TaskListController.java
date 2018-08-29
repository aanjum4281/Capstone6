package co.grandcircus.capstone6.tasklist;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import co.grandcircus.capstone6.tasklist.dao.TaskDao;
import co.grandcircus.capstone6.tasklist.dao.UserDao;


@Controller
public class TaskListController {
	
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	

	@RequestMapping ("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		List<Task> task = taskDao.findAll();
		mav.addObject("task", task);

		return mav;
	}

	@RequestMapping("/registration-form")
	public ModelAndView showForm() {
		// The new ModelAndView indicates what JSP to render
		ModelAndView mav = new ModelAndView("registrationform");
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}
	
	
	@PostMapping("/login")
	// get the email and password from the form when it's submitted.
	public ModelAndView submitLoginForm(HttpSession session, @RequestParam("emailAddress") String emailAddress, 
			@RequestParam("password") String password) {
		 
		User user = userDao.findByEmailAddress(emailAddress);
		if (user != null && password.equals(user.getPassword())) {
			List<Task> task = taskDao.findAll();
			//Match
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/add-task");
		} else {
			//not a match
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Incorrect email or password.");
			return mav;
		}
		
		
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		
		session.invalidate();
		redir.addFlashAttribute("message", "Logged out.");
		return new ModelAndView("redirect:/");
	}
	
	
	@PostMapping("/")
	public ModelAndView showRegistered(@RequestParam("emailAddress") String emailAddress,
		@RequestParam("password") String password) {

		// Construct a user from the url params
		User user = new User();
		
		user.setPassword(password);
		user.setEmailAddress(emailAddress);

		userDao.create(user);

		ModelAndView mav = new ModelAndView("redirect:/add-task");
		mav.addObject("user", user);

		return mav;
		}
		
	
	@RequestMapping("/add-task")
	public ModelAndView showAdd() {
		ModelAndView mav = new ModelAndView("addtask");
		return mav;

	}
	
	@PostMapping("/add")
	public ModelAndView showNew(

//			@SessionAttribute(name="user")User user, 
			@RequestParam("description") String description,
			@RequestParam("complete") boolean complete, @RequestParam("date") String date
			) {

		Task task = new Task();

//		task.setUser(user);
		task.setDescription(description);
		task.setComplete(complete);
		task.setDueDate(date);
	
		
		taskDao.create(task);
		ModelAndView mav = new ModelAndView("redirect:/");
		mav.addObject("task", task);

		return mav;

	}
	
	// delete item
		@RequestMapping("/delete")
		public ModelAndView delete(@RequestParam("id") Long id) {
			taskDao.delete(id);
			return new ModelAndView("redirect:/");
		}
	
	
}
