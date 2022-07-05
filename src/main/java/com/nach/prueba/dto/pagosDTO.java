package com.nach.prueba.dto;

import java.io.Serializable;

public class pagosDTO implements Serializable{

	private static final long serialVersionUID = 723361308239082572L;
	private String payment;
	private boolean success;
	public pagosDTO() {
		super();
	}
	public pagosDTO(String payment, boolean success) {
		super();
		this.payment = payment;
		this.success = success;
	}
	public pagosDTO( boolean success) {
		super();
		this.success = success;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
