package com.colbystopyak.classmanager.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="user_courses")
public class UserCourses {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User user;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="course_id")
	 private Course course;
	
	 
	 public UserCourses() {}


	public UserCourses(User user2, Course course2) {
		this.user= user2;
		this.course= course2;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	 
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
			}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
		}
	 
}
