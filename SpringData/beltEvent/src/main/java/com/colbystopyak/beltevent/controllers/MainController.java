package com.colbystopyak.beltevent.controllers;

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

import com.colbystopyak.beltevent.models.Event;
import com.colbystopyak.beltevent.models.UserEvents;
import com.colbystopyak.beltevent.models.User;
import com.colbystopyak.beltevent.services.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService mainServ;

	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
		}
	
	@GetMapping("events")
	public String index(@ModelAttribute("event") Event emptyEvent, HttpSession session, Model model) {
		
		Long user_id = (Long) session.getAttribute("user_id");
		User user = mainServ.findUser(user_id);
		
		List<Event> EventsByState = mainServ.findByState(user.getState());
		List<Event> NotInState = mainServ.findByStateIsNot(user.getState());
		List<Event> allEvents = mainServ.getAllEvents();
		
		model.addAttribute("user_id", user_id);
		model.addAttribute("events", allEvents);
		model.addAttribute("user", user);
		model.addAttribute("myevents", EventsByState);
		model.addAttribute("notmyevents", NotInState);
		return "events.jsp";
	}

	@PostMapping("events/new")
	public String createEvent(@Valid @ModelAttribute("event") Event filledEvent, BindingResult results,
			HttpSession session, Model model) {
		if (results.hasErrors()) {
			Long user_id = (Long) session.getAttribute("user_id");
			List<Event> allEvents = mainServ.getAllEvents();
			User user = mainServ.findUser(user_id);
			model.addAttribute("user_id", user_id);
			model.addAttribute("events", allEvents);
			model.addAttribute("user", user);
			return "events.jsp";
		}

		// creating an event
		mainServ.createEvent(filledEvent);
		return "redirect:/events";
	}
	
	
	//Showing an Event page
	@GetMapping("/events/{id}")
	public String showEventPage(@PathVariable("id") Long id, Model model) {
//	System.out.println(id);
		Event event = mainServ.findEvent(id);
		model.addAttribute("event", event);
		
	return "show.jsp";
	}
	// editing an event display portion

	@GetMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long id, Model model) {
//		System.out.println(id);
		Event editEvent = mainServ.findEvent(id);
		model.addAttribute("event", editEvent);
		return "edit.jsp";

	}

//	process editing event
	@PutMapping("/events/{id}/edit")
	public String processEditEvent(@Valid @ModelAttribute("event") Event filledEvent, BindingResult results) {
		if(results.hasErrors()) {
				return "edit.jsp";
			}
		//how you would update event
		mainServ.createEvent(filledEvent);
			return "redirect:/events";
		}
	
//delete
	@GetMapping("/events/{id}/delete")
	public String deleteEvent(@PathVariable("id") Long id) {
		mainServ.deleteEvent(id);
		return "redirect:/events";
	}

//Joining the event w/o middle model
//	@GetMapping("/events/{id}/join")
//	public String joinEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
//		Long user_id = (Long) session.getAttribute("user_id");
//		Event event = mainServ.findEvent(id);
//		User user = mainServ.findUser(user_id);
//		List<User> userlist = event.getJoinusers();
//		userlist.add(user);
//		event.setJoinusers(userlist);
//		mainServ.updateEvent(event);
//		String string = Long.toString(id);
//		return "redirect:/events/" + string;
		
		
		
//	}
	
	// Joining the even with a middle model
	@GetMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session, Model model, @ModelAttribute("userevent") UserEvents emptyUserEvent) {
		Long user_id = (Long) session.getAttribute("user_id");
		Event event = mainServ.findEvent(id);
		User user = mainServ.findUser(user_id);
		UserEvents newUserEvents = new UserEvents(user, event);
		mainServ.createUserEvents(newUserEvents);
		
		
		String string = Long.toString(id);
		return "redirect:/events/" + string;
	}
	
	@GetMapping("/events/{id}/cancel")
	public String cancelEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		Event event = mainServ.findEvent(id);
		User user = mainServ.findUser(user_id);
		List<User> userlist = event.getJoinusers();
		userlist.remove(user);
		event.setJoinusers(userlist);
		mainServ.updateEvent(event);
		return "redirect:/events";
	}
//	
}  //end main controller
