package com.colbystopyak.beltevent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbystopyak.beltevent.models.Event;
import com.colbystopyak.beltevent.models.Message;

@Repository
public interface MessageRepository extends CrudRepository <Message, Long>{
	List<Message> findAll();
}
