package com.mx.CrudEmployeed.dao;

import org.springframework.data.repository.CrudRepository;
import com.mx.CrudEmployeed.dominio.Employeed;

public interface EmployeedDao extends CrudRepository<Employeed, Integer>{

}
