package com.edsd.model;

import javax.persistence.*;

@Entity
@Table(name = "role", catalog = "edsd", uniqueConstraints = 
		@UniqueConstraint(columnNames = { "role_id", "role"}))
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    public Role(String role) {
		super();
		this.role = role;
	}

	@Column(name = "role", unique = true, nullable = false)
    private String role;

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
}
