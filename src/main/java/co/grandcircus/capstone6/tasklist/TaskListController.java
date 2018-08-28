package co.grandcircus.capstone6.tasklist;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.capstone6.tasklist.dao.TaskDao;




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
	
	@RequestMapping("/add-task")
	public ModelAndView showAdd() {
		ModelAndView mav = new ModelAndView("addtask");
		return mav;

	}
	
	@PostMapping("/add")
	public ModelAndView showNew(

			 @RequestParam("description") String description,
			@RequestParam("complete") boolean complete, @RequestParam("date") String date
			) {

		Task task = new Task();

		
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
