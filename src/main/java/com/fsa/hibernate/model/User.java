package com.fsa.hibernate.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private String id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_password")
	private String password;

	@OneToMany(mappedBy = "user", targetEntity = Phone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Phone> phones;

	@Column
	private Date creation;

	@Column
	private Date lastTimeModified;

	@Column
	private Date lastLogin;

	public User() {

	}

	public User(String name, String email, String password, List<Phone> phones) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.creation = Calendar.getInstance().getTime();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getLastTimeModified() {
		return lastTimeModified;
	}

	public void setLastTimeModified(Date lastTimeModified) {
		this.lastTimeModified = lastTimeModified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return getId().equals(other.getId());
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}