package com.nach.prueba.service;

import com.nach.prueba.dto.agregarEmpleadoDTO;
import com.nach.prueba.dto.empleadosPuestoDTO;
import com.nach.prueba.dto.hrsTrbjDTO;
import com.nach.prueba.dto.pagosDTO;
import com.nach.prueba.vo.agregaHrsTrbjVO;
import com.nach.prueba.vo.agregarEmpleadoVO;
import com.nach.prueba.vo.hrsTrbjVO;
import com.nach.prueba.vo.puestoVO;

public interface empleadoServ {
	/**
	 * Ingresa un nuevo empleado que no esté dentro de la BD
	 * @param empleado
	 * @return
	 */
	public agregarEmpleadoDTO agregaEmpleado(agregarEmpleadoVO empleado);
	/**
	 * Agrega horas trabajadas a un empleado registrado en la BD
	 * @param horas
	 * @return
	 */
	public agregarEmpleadoDTO agregaHrsTrbj(agregaHrsTrbjVO horas);
	/**
	 * Obtiene una lista de empleados a partir del id de un puesto registrado en BD
	 * @param puesto
	 * @return
	 */
	public empleadosPuestoDTO obtieneEmpleadosPuesto(puestoVO puesto);
	/**
	 * Obtiene el total de horas trabajadas por un empleado entre una fecha de inicio y una fecha de fin
	 * @param hrs
	 * @return
	 */
	public hrsTrbjDTO totalHorsTrbjEmpl(hrsTrbjVO hrs);
	/**
	 * Obtiene el total que se le pagó a un empleado registrado con fechas trabajadas registradas
	 * @param hrs
	 * @return
	 */
	public pagosDTO totalPagoEmpl(hrsTrbjVO hrs);
}