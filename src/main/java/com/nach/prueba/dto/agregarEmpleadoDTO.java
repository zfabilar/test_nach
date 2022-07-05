package com.nach.prueba.dto;

import java.io.Serializable;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
@Component
public class agregarEmpleadoDTO implements Serializable{
	
	private static final long serialVersionUID = 4201459604758758216L;
	private int id;
	private boolean success;
	private String mensaje;
	
	public agregarEmpleadoDTO() {
		super();
	}
	public agregarEmpleadoDTO( boolean success,String mensaje) {
		this.success = success;
		this.mensaje = mensaje;
	}
	public agregarEmpleadoDTO(@Nullable int id, boolean success) {
		super();
		this.id = id;
		this.success = success;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}