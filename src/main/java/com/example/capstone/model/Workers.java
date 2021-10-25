package com.example.capstone.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//will be using these annotations to be creating a employee tables 
@Entity
@Table(name = "employees")
public class Workers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //will be using this auto
	private long id_number;
	
	
	@Column(name = "first_name")
	private String fName;
	
	@Column(name = "last_name")
	private String lName;
	
	@Column(name = "email_address")
	private String emailAddr;
	
	public Workers() {
		
		
	}
	
	public Workers(String fName,String lName, String emailAddr) {
		
		super();
		this.fName = fName;
		this.lName = lName;
		this.emailAddr = emailAddr;
		
	
	}
	
	public long getId(){
		return id_number;
		}
	
	public void setId(long id_number) {
		this.id_number = id_number;
	}
	

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	
}