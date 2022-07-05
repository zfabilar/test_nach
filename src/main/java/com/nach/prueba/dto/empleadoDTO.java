package com.nach.prueba.dto;

import java.io.Serializable;
import java.sql.Date;


public class empleadoDTO implements Serializable{
	
	private static final long serialVersionUID = 6186865421926734707L;
	private int id;
	private String name;
	private String last_name;
	private Date birthdate;
	private PuestoDTO job;
	private GeneroDTO gender;
	public empleadoDTO() {
		super();
	}
	public empleadoDTO(int id, String name, String last_name, Date birthdate, PuestoDTO job, GeneroDTO gender) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
		this.job = job;
		this.gender = gender;
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
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public PuestoDTO getJob() {
		return job;
	}
	public void setJob(PuestoDTO job) {
		this.job = job;
	}
	public GeneroDTO getGender() {
		return gender;
	}
	public void setGender(GeneroDTO gender) {
		this.gender = gender;
	}
	
}
