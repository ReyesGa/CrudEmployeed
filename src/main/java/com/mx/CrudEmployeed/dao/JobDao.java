package com.mx.CrudEmployeed.dao;

import org.springframework.data.repository.CrudRepository;
import com.mx.CrudEmployeed.dominio.Jobs;

public interface JobDao extends CrudRepository<Jobs, Integer>{


}
