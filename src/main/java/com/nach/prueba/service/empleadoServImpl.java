package com.nach.prueba.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nach.prueba.components.Constantes;
import com.nach.prueba.components.IutilsComponent;
import com.nach.prueba.dao.empleadoDAO;
import com.nach.prueba.dao.generoDAO;
import com.nach.prueba.dao.hrsTrbjEmplDAO;
import com.nach.prueba.dao.jobDAO;
import com.nach.prueba.dto.GeneroDTO;
import com.nach.prueba.dto.PuestoDTO;
import com.nach.prueba.dto.agregarEmpleadoDTO;
import com.nach.prueba.dto.empleadoDTO;
import com.nach.prueba.dto.empleadosPuestoDTO;
import com.nach.prueba.dto.hrsTrbjDTO;
import com.nach.prueba.dto.pagosDTO;
import com.nach.prueba.entity.empleadoEntity;
import com.nach.prueba.entity.generoEntity;
import com.nach.prueba.entity.horasTrabajadasEmpleadoEntity;
import com.nach.prueba.entity.jobEntity;
import com.nach.prueba.vo.agregaHrsTrbjVO;
import com.nach.prueba.vo.agregarEmpleadoVO;
import com.nach.prueba.vo.hrsTrbjVO;
import com.nach.prueba.vo.puestoVO;

@Service
public class empleadoServImpl implements empleadoServ {
	private static Logger log = LoggerFactory.getLogger(empleadoServImpl.class);
	@Autowired
	private jobDAO job_dao;
	@Autowired
	private empleadoDAO empleado_dao;
	@Autowired
	private generoDAO genero_dao;
	@Autowired
	private hrsTrbjEmplDAO hrswork_dao;
	@Autowired
	private IutilsComponent utils;
	@Autowired
	private Constantes constantes;
	
	@Override
	public agregarEmpleadoDTO agregaEmpleado(agregarEmpleadoVO empleado) {
		 empleado.setBirthdate(utils.aumentaDia(empleado.getBirthdate()));
		empleadoEntity empl = empleado_dao.findByNombreAndApellido(empleado.getName(), empleado.getLast_name());
		if(empl == null) {
			 if(ZonedDateTime.now().getYear() - (empleado.getBirthdate().getYear()+1900) >= 18) {
				 if(genero_dao.findById(empleado.getGender_id()).isPresent()) {
					 if(job_dao.findById(empleado.getJob_id()).isPresent()) {
						 empleadoEntity employee = empleado_dao.save(new empleadoEntity(empleado.getGender_id(),empleado.getJob_id(),
								 empleado.getName(),empleado.getLast_name(),empleado.getBirthdate()));
						 log.info("Se guardó el empleado");
						// return new agregarEmpleadoDTO(0,true);
						 return new agregarEmpleadoDTO(employee.getId(),true);
					 }else {
						 log.info(constantes.NO_EXISTE_PUESTO);
						 return new agregarEmpleadoDTO(false,constantes.NO_EXISTE_PUESTO);
					 }
				 }else {
					log.info(constantes.NO_EXISTE_GENERO);
					 return new agregarEmpleadoDTO(false,constantes.NO_EXISTE_GENERO);
				 }
			 }else {
				 log.info(constantes.NO_MAYOR_EDAD);
				 return new agregarEmpleadoDTO(false,constantes.NO_MAYOR_EDAD);
			 }
		}else {
			log.info(constantes.YA_EXISTE_EMPLEADO);
			 return new agregarEmpleadoDTO(false,constantes.YA_EXISTE_EMPLEADO);
		}
	}
	@Override
	public agregarEmpleadoDTO agregaHrsTrbj(agregaHrsTrbjVO horas) {
		 horas.setWorked_date(utils.aumentaDia(horas.getWorked_date()));
		if(empleado_dao.findById(horas.getEmployee_id()).isPresent()) {
			if(horas.getWorked_hours() >=1 && horas.getWorked_hours() < 21) {
				 if(utils.validaFecha(horas.getWorked_date()) ) {
					 if(hrswork_dao.findByEmployeeIdAndFechaTrabajada(horas.getEmployee_id(),horas.getWorked_date()) == null) {
					  horasTrabajadasEmpleadoEntity hrs = hrswork_dao.save(new horasTrabajadasEmpleadoEntity(horas.getEmployee_id(),horas.getWorked_hours(),horas.getWorked_date()));
					  log.info("Horas registradas");
					  return new agregarEmpleadoDTO(hrs.getId(),true);
					}else {
						log.info(constantes.YA_EXISTE_REGISTRO_FECHA);
						return new agregarEmpleadoDTO(false,constantes.YA_EXISTE_REGISTRO_FECHA);
					}
				 }else {
					 log.info(constantes.FECHA_INCORRECTA);
					 return new agregarEmpleadoDTO(false,constantes.FECHA_INCORRECTA);
				 }
			}else {
				log.info(constantes.HORAS_INCORRECTAS);
				 return new agregarEmpleadoDTO(false,constantes.HORAS_INCORRECTAS);
			}
		}else {
			log.info(constantes.NO_EXISTE_EMPLEADO);
			 return new agregarEmpleadoDTO(false, constantes.NO_EXISTE_EMPLEADO);
		}
	}
	@Override
	public empleadosPuestoDTO obtieneEmpleadosPuesto(puestoVO puesto) {
		List<empleadoDTO> lista = new ArrayList<empleadoDTO>();
		if(!job_dao.findById(puesto.getJob_id()).isPresent()) {
			return new empleadosPuestoDTO(lista,false);
		}
		List<empleadoEntity> employees = empleado_dao.findByJobId(puesto.getJob_id());
		for(int i = 0;i<employees.size();i++) {
			Optional<jobEntity> trabajo = job_dao.findById(employees.get(i).getJob_id());
			Optional<generoEntity> genero = genero_dao.findById(employees.get(i).getGender_id());
			lista.add(new empleadoDTO(employees.get(i).getId(),employees.get(i).getNombre(),employees.get(i).getApellido(),employees.get(i).getCumpleanios(),
					new PuestoDTO(trabajo.get().getId(),trabajo.get().getNombre(),trabajo.get().getSalario()),new GeneroDTO(genero.get().getId(),genero.get().getNombre())));
		}
		return new empleadosPuestoDTO(lista,true);
	}
	@Override
	public hrsTrbjDTO totalHorsTrbjEmpl(hrsTrbjVO hrs) {
		 hrs.setStart_date(utils.aumentaDia(hrs.getStart_date()));
		 hrs.setEnd_date(utils.aumentaDia(hrs.getEnd_date()));
		if(empleado_dao.findById(hrs.getEmployee_id()).isPresent()) {
			if(utils.comparaFechas(hrs.getStart_date(),hrs.getEnd_date())) {
				return new hrsTrbjDTO(hrswork_dao.totalHoras(hrs.getEmployee_id(), hrs.getStart_date(), hrs.getEnd_date()) ,true);
			}else {
				return new hrsTrbjDTO(false);
			}
		}else {
			return new hrsTrbjDTO(false);
		}
	}
	@Override
	public pagosDTO totalPagoEmpl(hrsTrbjVO hrs) {
		 hrs.setStart_date(utils.aumentaDia(hrs.getStart_date()));
		 hrs.setEnd_date(utils.aumentaDia(hrs.getEnd_date()));
		 Optional<empleadoEntity> empleado = empleado_dao.findById(hrs.getEmployee_id());
		if(empleado.isPresent()) {
			if(utils.comparaFechas(hrs.getStart_date(),hrs.getEnd_date())) {
				List<horasTrabajadasEmpleadoEntity> lis = hrswork_dao.findByFechaTrabajadaBetweenAndEmployeeId(hrs.getStart_date(), hrs.getEnd_date(),hrs.getEmployee_id());
				jobEntity trabajo = job_dao.getById(empleado.get().getJob_id());
				int total = trabajo.getSalario() * lis.size();
				log.info(lis.size()+"");
				return new pagosDTO(Integer.toString(total),true);
			}else {
				return new pagosDTO(false);
			}
		}else {
			return new pagosDTO(false);
		}
	}

}

