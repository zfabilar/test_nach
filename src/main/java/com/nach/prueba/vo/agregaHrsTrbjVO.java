package com.nach.prueba.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class agregaHrsTrbjVO implements Serializable{

	private static final long serialVersionUID = -1607620071440662027L;
	@NotNull(message = "Este valor no debe ser nulo")
	private int employee_id;
	@Min(1)
	@Max(20)
	private int worked_hours;
	@NotNull(message = "Este valor no debe ser nulo")
	private Date worked_date;
	
	public agregaHrsTrbjVO() {
		super();
	}
	public agregaHrsTrbjVO(int employee_id, int worked_hours, Date worked_date) {
		super();
		this.employee_id = employee_id;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getWorked_hours() {
		return worked_hours;
	}
	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}
	public Date getWorked_date() {
		return worked_date;
	}
	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}
	
	
}
