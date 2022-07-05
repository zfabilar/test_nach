package com.nach.prueba.dto;

import java.io.Serializable;

public class GeneroDTO implements Serializable{

	private static final long serialVersionUID = 3585973468918587126L;
	private int id;
	private String name;
	public GeneroDTO() {
		super();
	}
	public GeneroDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
