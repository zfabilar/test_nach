package com.nach.prueba.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class puestoVO implements Serializable{
	
	private static final long serialVersionUID = 4844611300573397982L;
	@NotNull(message = "Este valor no debe ser nulo")
	private int job_id;
	
	
	public puestoVO() {
		super();
	}

	public puestoVO(int job_id) {
		super();
		this.job_id = job_id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
}
