package com.nach.prueba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nach.prueba.entity.empleadoEntity;

@Repository
public interface empleadoDAO extends JpaRepository<empleadoEntity,Integer>{
	public empleadoEntity findByNombreAndApellido(String nombre,String apellido);
	public List<empleadoEntity> findByJobId(int jobId);
}
