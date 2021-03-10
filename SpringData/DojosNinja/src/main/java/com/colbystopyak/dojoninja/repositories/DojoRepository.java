package com.colbystopyak.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbystopyak.dojoninja.models.Dojo;
import com.colbystopyak.dojoninja.models.Ninja;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();

	void save(Ninja ninja);
	
	
}


