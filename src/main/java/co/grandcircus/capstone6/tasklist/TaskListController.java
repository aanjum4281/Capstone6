package co.grandcircus.capstone6.tasklist;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.capstone6.dao.TaskDao;




@Controller
public class TaskListController {
	
	@Autowired
	private TaskDao taskDao;
	

	@RequestMapping ("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		List<Task> task = taskDao.findAll();
		mav.addObject("task", task);

		return mav;
	}
	
//	@RequestMapping("/add-task")
//	public ModelAndView showAdd() {
//		ModelAndView mav = new ModelAndView("addtask");
//		return mav;
//
//	}
//	
//	@RequestMapping("/add")
//	public ModelAndView showNew(
//
//			@RequestParam("id") Long id, @RequestParam("description") String description,
//			@RequestParam("complete") Boolean complete, @RequestParam("dueDate") String dueDate, 
//			@RequestParam("user") User user ) {
//
//		Task task = new Task();
//
//		task.setId(id);
//		task.setDescription(description);
//		task.setComplete(complete);
//		task.setDueDate(dueDate);
//		task.setUser(user);
//		
//		taskDao.create(task);
//		ModelAndView mav = new ModelAndView("/");
//		mav.addObject("task", task);
//
//		return mav;
//
//	}
//	
//	// delete item
//		@RequestMapping("/delete")
//		public ModelAndView delete(@RequestParam("id") Long id) {
//			taskDao.delete(id);
//			return new ModelAndView("redirect:/");
//		}
//	
	
}
