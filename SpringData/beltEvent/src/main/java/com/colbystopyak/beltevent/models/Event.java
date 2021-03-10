package com.colbystopyak.beltevent.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	//Attributes are here:
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message =" please select a date")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date event_date;
	
	@Size(min=2, max=50, message="event must be 2-20")
	private String name;
	
	@Size(min=2, max=50, message="City name must be 2-50")
	private String city;
	@NotNull
	private String state;
	
	
	//Relationships
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id") // your foreign key
	private User host;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_events", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> joinusers;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
    public Event() {
    	
    }
    
    
    
    
    
    
    
    public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public Date getEvent_date() {
		return event_date;
	}







	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public String getCity() {
		return city;
	}







	public void setCity(String city) {
		this.city = city;
	}







	public String getState() {
		return state;
	}







	public void setState(String state) {
		this.state = state;
	}







	public User getHost() {
		return host;
	}







	public void setHost(User host) {
		this.host = host;
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








	public List<User> getJoinusers() {
		return joinusers;
	}







	public void setJoinusers(List<User> joinusers) {
		this.joinusers = joinusers;
	}







	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }







//	public void showAllUsers(List<User> allUsers) {
//		// TODO Auto-generated method stub
//		
//	}







	







	 
}