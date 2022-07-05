package com.nach.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nach.prueba.dto.agregarEmpleadoDTO;
import com.nach.prueba.dto.empleadosPuestoDTO;
import com.nach.prueba.dto.hrsTrbjDTO;
import com.nach.prueba.dto.pagosDTO;
import com.nach.prueba.service.empleadoServ;
import com.nach.prueba.vo.agregaHrsTrbjVO;
import com.nach.prueba.vo.agregarEmpleadoVO;
import com.nach.prueba.vo.hrsTrbjVO;
import com.nach.prueba.vo.puestoVO;

@Controller
public class EmpleadosController {
	
	@Autowired
	private empleadoServ empleadoserv;
	
	@PostMapping("/empleados")
	public ResponseEntity<agregarEmpleadoDTO> agregaEmpleado(@Validated @RequestBody agregarEmpleadoVO empleado) {
		return new ResponseEntity<agregarEmpleadoDTO>(empleadoserv.agregaEmpleado(empleado),HttpStatus.OK);
	}
	@PostMapping("/empleados/horas-trabajadas")
	public ResponseEntity<agregarEmpleadoDTO> agregaHrsTrbj(@Validated @RequestBody agregaHrsTrbjVO horas) {
		return new ResponseEntity<agregarEmpleadoDTO>(empleadoserv.agregaHrsTrbj(horas),HttpStatus.OK);
	}
	@GetMapping("/empleados")
	public ResponseEntity<empleadosPuestoDTO> obtieneEmpleadosPuesto(@Validated @RequestBody puestoVO puesto){
		return new ResponseEntity<empleadosPuestoDTO>(empleadoserv.obtieneEmpleadosPuesto(puesto),HttpStatus.OK);
	}
	@GetMapping("/empleados/horas-trabajadas")
	public ResponseEntity<hrsTrbjDTO> totalHorsTrbjEmpl(@Validated @RequestBody hrsTrbjVO hrs){
		return new ResponseEntity<hrsTrbjDTO>(empleadoserv.totalHorsTrbjEmpl(hrs),HttpStatus.OK);
	}
	@GetMapping("/empleados/pagos")
	public ResponseEntity<pagosDTO> totalPagoEmpl(@Validated @RequestBody hrsTrbjVO hrs){
		return new ResponseEntity<pagosDTO>(empleadoserv.totalPagoEmpl(hrs),HttpStatus.OK);
	}
}
