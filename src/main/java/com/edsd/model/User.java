package com.edsd.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user", catalog = "edsd", uniqueConstraints = 
@UniqueConstraint(columnNames = {"user_id", "username", "email"}))
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @NotNull(message="User ID is required")
    private int userId;
    
    @NotBlank
    @Column(name = "last_name", nullable = false)
    @Size(min=1, max=100)
    private String lastName;
    
    @NotBlank
    @Column(name = "first_name", nullable = false)
    @Size(min=1, max=100)
    private String firstName;
    
    @Column(name = "mid_name", nullable = true)
    @Size(max=100)
    private String midName;
    
    @NotBlank
	@Column(name = "username", nullable = false, unique = true)
    @Size(min=1, max=100)
    private String username;
	
    @NotBlank
    @Column(name = "password", nullable = false)
    @Size(min=1, max=60)
    private String password;
    
    @NotBlank
    @Column(name = "email", nullable = false, unique = true)
    @Size(min=1, max=100)
    private String email;
    
    @NotBlank
    @Column(name = "active", columnDefinition= "BOOLEAN DEFAULT true") 
    @NotNull(message="User must be Enabled or Disabled")
    private boolean active;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="createdBy", orphanRemoval=true)
	@JsonManagedReference
    private Set<PrimesEdsd> primesEdsd;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="createdBy", orphanRemoval=true)
	@JsonManagedReference
    private Set<NonLogementEdsd> nonLogementEdsd;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="createdBy", orphanRemoval=true)
	@JsonManagedReference
    private Set<RappelsSalairesEdsd> rappelsSalairesEdsd;
    

	public User() {
    }

    public User(User user) {
    	this.userId = user.getUserId();
    	this.lastName =user.getLastName();
    	this.firstName =user.getFirstName();
    	this.midName =user.getMidName();
    	this.username =user.getUsername();
    	this.password = user.getPassword();
    	this.email = user.getEmail();
        this.active = user.getActive();        
        this.roles = user.getRoles();
//        this.primesEdsd = user.getPrimesEdsd();
    }
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<PrimesEdsd> getPrimesEdsd() {
		return primesEdsd;
	}

	public void setPrimesEdsd(Set<PrimesEdsd> primesEdsd) {
		this.primesEdsd = primesEdsd;
	}
	
	public Set<NonLogementEdsd> getNonLogementEdsd() {
		return nonLogementEdsd;
	}

	public void setNonLogementEdsd(Set<NonLogementEdsd> nonLogementEdsd) {
		this.nonLogementEdsd = nonLogementEdsd;
	}

	public Set<RappelsSalairesEdsd> getRappelsSalairesEdsd() {
		return rappelsSalairesEdsd;
	}

	public void setRappelsSalaires(Set<RappelsSalairesEdsd> rappelsSalairesEdsd) {
		this.rappelsSalairesEdsd = rappelsSalairesEdsd;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", midName=" + midName
				+ ", username=" + username + ", email=" + email + ", active=" + active + ", roles=" + roles + "]";
	}
}
