package com.colbystopyak.classmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbystopyak.classmanager.models.UserCourses;

@Repository
public interface UserCoursesRepository extends CrudRepository<UserCourses, Long> {
	List<UserCourses> findAll();
}
