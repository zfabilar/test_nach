package com.nach.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nach.prueba.entity.jobEntity;

@Repository
public interface jobDAO extends JpaRepository<jobEntity,Integer> {
	
}