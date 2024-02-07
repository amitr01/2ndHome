package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Step 1;
@Entity
@Table(name="user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	private String gender;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private Role role;


	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender + ", role="
				+ role + "]";
	}





	public User(String name, String email, String password, String gender, Role role) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
	}


}
