package com.nach.prueba.dto;

import java.io.Serializable;

public class PuestoDTO implements Serializable{

	private static final long serialVersionUID = -7815887004461033071L;
	private int id;
	private String name;
	private int salary;
	public PuestoDTO() {
		super();
	}
	public PuestoDTO(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
