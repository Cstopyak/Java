package com.colbystopyak.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbystopyak.dojoninja.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long>{
	List<Ninja> findAll();
	
	
}
