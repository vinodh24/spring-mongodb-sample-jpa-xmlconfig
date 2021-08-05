package com.vinodh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employe {
	
	@Id
	private String empoyeeId;
	private String name;
	private String salary;
	private Common common;
	
	public String getEmpoyeeId() {
		return empoyeeId;
	}
	public void setEmpoyeeId(String empoyeeId) {
		this.empoyeeId = empoyeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Common getCommon() {
		return common;
	}
	public void setCommon(Common common) {
		this.common = common;
	}
	@Override
	public String toString() {
		return "Employe [empoyeeId=" + empoyeeId + ", name=" + name + ", salary=" + salary + ", common=" + common + "]";
	}

}
