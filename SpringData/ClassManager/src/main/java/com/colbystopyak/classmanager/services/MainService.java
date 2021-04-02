package com.colbystopyak.classmanager.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbystopyak.classmanager.models.Course;
import com.colbystopyak.classmanager.models.User;
import com.colbystopyak.classmanager.models.UserCourses;
import com.colbystopyak.classmanager.repositories.CourseRepository;
import com.colbystopyak.classmanager.repositories.UserCoursesRepository;
import com.colbystopyak.classmanager.repositories.UserRepository;


@Service
public class MainService {
	@Autowired
	private CourseRepository cRepo;
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private UserCoursesRepository ucRepo;
	
	public void createCourse(@Valid Course filledCourse) {
		cRepo.save(filledCourse);
		
	}



	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}



	public User findUser(Long user_id) {
		return uRepo.findById(user_id).orElse(null);
	}



	public Course findCourse(Long id) {
		return cRepo.findById(id).orElse(null);
	}



	public void createUserCourses(@Valid UserCourses emptyCourse) {
		ucRepo.save(emptyCourse);
		
	}



	public void updateCourse(Course course) {
		cRepo.save(course);
		
	}



	public void deleteCourse(Long id) {
		cRepo.deleteById(id);
		
	}



	


	
	
	
	
}
