package com.edsd.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role", catalog = "edsd", uniqueConstraints = 
		@UniqueConstraint(columnNames = { "role_id", "role"}))
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;
    

	@Column(name = "role", unique = true, nullable = false)
    private String role;
	
	
	public Role(String role) {
		super();
		this.role = role;
	}

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    @Override
    public boolean equals(Object obj) {
    	Role role = (Role)obj;
    	return this.role.equalsIgnoreCase(role.getRole());
    }

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + "]";
	}
}
