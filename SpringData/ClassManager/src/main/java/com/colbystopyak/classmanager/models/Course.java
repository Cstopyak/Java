package com.colbystopyak.classmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;





@Entity
@Table(name="courses")
public class Course {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Size(min=2, max=50, message="name must be 2-20")
	private String name;
	
	@Size(min=2, max=50, message="Instructor must be 2-50")
	private String instructor;

	@Range(min=0, max=30, message="capacity must be 0-30")
	private String capacity;
	
	//Relationships
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id") // your foreign key
		private User host;
	
		@ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "user_courses", 
	        joinColumns = @JoinColumn(name = "course_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	private List<User> joinusers;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

public Course() {}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getInstructor() {
	return instructor;
}

public void setInstructor(String instructor) {
	this.instructor = instructor;
}

public String getCapacity() {
	return capacity;
}

public void setCapacity(String capacity) {
	this.capacity = capacity;
}


@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}

public User getHost() {
	return host;
}

public void setHost(User host) {
	this.host = host;
}

public List<User> getJoinusers() {
	return joinusers;
}

public void setJoinusers(List<User> joinusers) {
	this.joinusers = joinusers;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}



}//end