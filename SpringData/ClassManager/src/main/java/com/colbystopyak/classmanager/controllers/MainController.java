package com.colbystopyak.classmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.colbystopyak.classmanager.models.Course;
import com.colbystopyak.classmanager.models.User;
import com.colbystopyak.classmanager.models.UserCourses;
import com.colbystopyak.classmanager.services.MainService;



@Controller
public class MainController {
	@Autowired MainService mainServ;
	
	@RequestMapping("/")
	public String home() {
		return "Index.jsp";
		}

	@GetMapping("courses")
	public String index(HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		List<Course> allCourses = mainServ.getAllCourses();
		User user = mainServ.findUser(user_id);
		model.addAttribute("user_id", user_id);
		model.addAttribute("courses", allCourses);
		model.addAttribute("user", user);
		return "courses.jsp";
		
	}
	
	@GetMapping("/courses/new")
	public String index(@ModelAttribute("course") Course emptyCourse, HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		User user = mainServ.findUser(user_id);
		model.addAttribute("user_id", user_id);
		
	return "newcoursepage.jsp";
	}
	
	@PostMapping("/courses/new")
	public String createCourse(@Valid @ModelAttribute("course") Course filledCourse, BindingResult results, HttpSession session, Model model)  {
		if (results.hasErrors()) {
			return "newcoursepage.jsp";
		}
		// creating an Course
			mainServ.createCourse(filledCourse);
		return "newcoursepage.jsp";
	}
	//Showing an course page
		@GetMapping("/courses/{id}")
		public String showCoursePage(@PathVariable("id") Long id, Model model) {
//		System.out.println(id);
			Course course = mainServ.findCourse(id);
			model.addAttribute("course", course);
			
		return "showcourse.jsp";
		}
		
		//displaying edit page
		@GetMapping("/courses/{id}/edit")
		public String editCourse(@PathVariable("id") Long id, Model model) {
			System.out.println(id);
			Course editCourse = mainServ.findCourse(id);
			model.addAttribute("course", editCourse);
			model.addAttribute("host", editCourse.getHost());
			return "edit.jsp";
		}
//			process editing course
		@PutMapping("/courses/{id}/edit")
		public String processEditCourse(@Valid @ModelAttribute("course") Course filledCourse, BindingResult results) {
			if(results.hasErrors()) {
					return "edit.jsp";
					}
				//how you would update course
			mainServ.createCourse(filledCourse);
				return "redirect:/courses";
				}	
		// Joining the even with a middle model
		@GetMapping("/courses/{id}/join")
		public String joinCourse(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("usercourse") UserCourses emptyUserCourse) {
			Long user_id = (Long) session.getAttribute("user_id");
			Course course = mainServ.findCourse(id);
			User user = mainServ.findUser(user_id);
			UserCourses newUserCourses = new UserCourses(user, course);
			mainServ.createUserCourses(newUserCourses);
			
			
			String string = Long.toString(id);
			return "redirect:/courses/" + string;
		}
		
		@GetMapping("/courses/{id}/cancel")
		public String cancelCourse(@PathVariable("id") Long id, HttpSession session, Model model) {
			Long user_id = (Long) session.getAttribute("user_id");
			Course course = mainServ.findCourse(id);
			User user = mainServ.findUser(user_id);
			List<User> userlist = course.getJoinusers();
			userlist.remove(user);
			course.setJoinusers(userlist);
			mainServ.updateCourse(course);
			return "redirect:/courses";
		}
		//delete function
		@GetMapping("/courses/{id}/delete")
		public String deleteCourse(@PathVariable("id") Long id) {
			mainServ.deleteCourse(id);
			return "redirect:/courses";
		}
					
} //end Main Controller
