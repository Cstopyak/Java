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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	//Attributes are here:
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	//for Registration
	@Size(min=2, max=50, message="First name must be 2-50")
	private String first_name;
	@Size(min=2, max=50, message="Last name must be 2-50")
	private String last_name;
	@Size(min=2, max=50, message="City name must be 2-50")
	private String city;
	@NotNull
	private String state;
	
	@Email(message="Email must be valid")
    private String email;
	
	@Size(min=5, message="Password must be greater than 5 characters")
    private String password;
	
    @Transient
    private String passwordConfirmation;
    @Transient
    private String duplicate;
    
    
    //Relationships
    @OneToMany(mappedBy="host", fetch = FetchType.LAZY)
    private List<Event> hostedEvents;
    
    //Many to Many
  
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
    		name = "user_events", 
            joinColumns = @JoinColumn(name = "user_id"), 
            inverseJoinColumns = @JoinColumn(name = "event_id")
        )     
    private List<Event> joinevents;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
   //Constructors
    public User() {}
    
    
    
    
    
    public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}





	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}





	public String getDuplicate() {
		return duplicate;
	}





	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
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





	public String getFirst_name() {
		return first_name;
	}





	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}





	public String getLast_name() {
		return last_name;
	}





	public void setLast_name(String last_name) {
		this.last_name = last_name;
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




//One To Many Getters Setters
	public List<Event> getHostedEvents() {
		return hostedEvents;
	}





	public void setHostedEvents(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}





	public List<Event> getJoinevents() {
		return joinevents;
	}





	public void setJoinevents(List<Event> joinevents) {
		this.joinevents = joinevents;
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