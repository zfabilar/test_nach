package com.nach.prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nach.prueba.entity.generoEntity;

@Repository
public interface generoDAO extends JpaRepository<generoEntity,Integer>{

}