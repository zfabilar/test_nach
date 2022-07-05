package com.nach.prueba.dto;

import java.io.Serializable;
import java.util.List;

public class empleadosPuestoDTO implements Serializable{

	private static final long serialVersionUID = 1097681647388734698L;
	private List<empleadoDTO> employees;
	private boolean success;
	public empleadosPuestoDTO() {
	}
	public empleadosPuestoDTO(List<empleadoDTO> employees, boolean success) {
		super();
		this.employees = employees;
		this.success = success;
	}
	public List<empleadoDTO> getEmployees() {
		return employees;
	}
	public void setEmployees(List<empleadoDTO> employees) {
		this.employees = employees;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
