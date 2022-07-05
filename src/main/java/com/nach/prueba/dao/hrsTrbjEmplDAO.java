package com.nach.prueba.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nach.prueba.entity.horasTrabajadasEmpleadoEntity;

@Repository
public interface hrsTrbjEmplDAO extends JpaRepository<horasTrabajadasEmpleadoEntity,Integer>{
	public horasTrabajadasEmpleadoEntity findByEmployeeIdAndFechaTrabajada(int id,Date fechaTrabajada);
	@Query(value = "select  sum(worked_hours) as total_quantity from employee_worked_hours " +
            "where employee_id = ?1 and worked_date >= ?2 and worked_date <= ?3", nativeQuery = true)
	public String totalHoras(int id_emp,Date inicio,Date fin);
	
	public List<horasTrabajadasEmpleadoEntity> findByFechaTrabajadaBetweenAndEmployeeId(Date des,Date has,int id);
	
}