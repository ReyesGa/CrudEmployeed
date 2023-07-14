package com.mx.CrudEmployeed.dao;

import org.springframework.data.repository.CrudRepository;
import com.mx.CrudEmployeed.dominio.Genders;

public interface GenderDao extends CrudRepository<Genders, Integer>{

}
