package com.ekiras.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {


	@Column(length = 20, unique = true)
	private String userName;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Email", nullable = true)
	private String email;

	@Column(name = "Phone", nullable = true)
	private String phoneNo;

	@Column(name = "EmployeeId", nullable = false ,unique=true)
	private String employeeId;

	@Column(name = "Designation", nullable = true)
	private String designation;

	@Column(length = 60)
	private String password;

	@Transient
	private String passwordConfirm;


	private boolean enabled;
	@Column(name = "tempPassword", nullable = true)
	private boolean tempPassword;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	/*
	 * @OneToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable private Set<Role> roles = new HashSet<>();
	 */
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/*
	 * public List<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(List<Role> roles) { this.roles = roles; }
	 */

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*	public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public boolean isTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(boolean tempPassword) {
		this.tempPassword = tempPassword;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
