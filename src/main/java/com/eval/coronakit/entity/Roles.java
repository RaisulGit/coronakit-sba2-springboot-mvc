package com.eval.coronakit.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


class AssignedRoleId implements Serializable {

    private String userName;
    private String role;

    public AssignedRoleId() {}

    public AssignedRoleId(String userName, String role) {
        this.userName = userName;
        this.role= role;
    }

    /*@Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Roles)) {
            return false;
        }
        Roles assignedRole = (Roles) o;
        return Objects.equals(userId, assignedRole.getUserName()) &&
               Objects.equals(roleId, assignedRole.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }*/
    
}


@Entity
@Table(name = "authorities",uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
//@Table(name = "authorities") // ,uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
@IdClass(AssignedRoleId.class)
public class Roles implements Serializable{
	

	@Id
	@Column(name = "username")
	private String userName;
	
	@Id
	@Column(name = "authority")
	private String role;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}*/	
}
