package com.colbystopyak.beltevent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbystopyak.beltevent.models.UserEvents;

@Repository
public interface UserEventsRepository extends CrudRepository<UserEvents, Long>{
		List<UserEvents> findAll();
}
