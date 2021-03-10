package com.colbystopyak.beltevent.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbystopyak.beltevent.models.Event;
import com.colbystopyak.beltevent.models.User;
import com.colbystopyak.beltevent.models.UserEvents;
import com.colbystopyak.beltevent.repositories.EventRepository;
import com.colbystopyak.beltevent.repositories.MessageRepository;
import com.colbystopyak.beltevent.repositories.UserEventsRepository;
import com.colbystopyak.beltevent.repositories.UserRepository;

@Service
	public class MainService {
	@Autowired
	private EventRepository eRepo;
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private MessageRepository mRepo;

	@Autowired
	private UserEventsRepository ueRepo; 
	
	public void createEvent(@Valid Event filledEvent) {
		eRepo.save(filledEvent);
		
	}
	
	public void createUserEvents(@Valid UserEvents emptyEvent) {
		ueRepo.save(emptyEvent);
		
	}

	public List<Event> getAllEvents() {
		
		return eRepo.findAll();
	}

	public Event findEvent(Long id) {
		
		return eRepo.findById(id).orElse(null);
	}

	public void deleteEvent(Long id) {
		
		eRepo.deleteById(id);
		
	}

	public List<User> getAllUsers() {
		
		return uRepo.findAll();
	}

	public User findUser(Long user_id) {
		
		return uRepo.findById(user_id).orElse(null);
	}

	

	public void updateEvent(Event event) {
		 eRepo.save(event);
		
	}

	public List<Event> getmyEvents() {
		
		return null;
	}

	public List<Event> findByState(String state) {
		// TODO Auto-generated method stub
		return eRepo.findByState(state);
	}

	public List<Event> findByStateIsNot(String state) {
		// TODO Auto-generated method stub
		return eRepo.findByStateIsNot(state);
	}

}
	
	 
	

	
	

	

	

	

