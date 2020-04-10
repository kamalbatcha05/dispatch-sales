package com.application.dispatch.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    private static final String NOT_BLANK_MESSAGE = "The value may not be empty!";
//    private static final String EMAIL_MESSAGE = "{email.message}";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @NotBlank(message = NOT_BLANK_MESSAGE)
//    @Email(message = EMAIL_MESSAGE)
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;
    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "active")
    private boolean active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }
    
    public void setRoles(Set<Role> roles) {
    	this.roles = roles;
    }
    
    public Set<Role> getRoles() {
    	return roles;
    }

}