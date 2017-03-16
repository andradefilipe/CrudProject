package com.fsa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "phone_id")
	private String id;

	@Column(name = "phone_ddd")
	private String ddd;

	@Column(name = "phone_number")
	private String number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, unique = true)
	private User user;

	public Phone() {
	}

	public Phone(String ddd, String number) {

		this.ddd = ddd;
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
