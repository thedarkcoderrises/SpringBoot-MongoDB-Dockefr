package com.nevado.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "employees")
public class Employee {

	@Id
	private String id;
	private String email;
	private String fullName;
	private String managerEmail;
	private Double sal;
	//One-toOne
	private Contact contact;
	//One-to-Many
	private List<SkillSet> skillSets;

	public List<SkillSet> getSkillSets() {
		return skillSets;
	}

	public void setSkillSets(List<SkillSet> skillSets) {
		this.skillSets = skillSets;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", fullName=" + fullName + ", managerEmail=" + managerEmail
				+ "]";
	}

}
