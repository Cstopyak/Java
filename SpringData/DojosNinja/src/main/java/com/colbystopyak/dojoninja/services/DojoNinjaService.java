package com.colbystopyak.dojoninja.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbystopyak.dojoninja.models.Dojo;
import com.colbystopyak.dojoninja.models.Ninja;
import com.colbystopyak.dojoninja.repositories.DojoRepository;
import com.colbystopyak.dojoninja.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	@Autowired
	private DojoRepository dRepo;
	@Autowired
	private NinjaRepository nRepo;
	public Dojo createDojo(@Valid Dojo filledDojo) {
		return dRepo.save(filledDojo);
		
	}
	public Dojo findDojoById(Long id) {
		return dRepo.findById(id).orElse(null);
		
	}
	public Ninja createNinja(@Valid Ninja filledNinja) {
		return nRepo.save(filledNinja);
		
	}
	public Ninja findNinjaById(Long id) {
		return nRepo.findById(id).orElse(null);
	}

	public DojoRepository getdRepo() {
		return dRepo;
	}
	public void setdRepo(DojoRepository dRepo) {
		this.dRepo = dRepo;
	}
	public NinjaRepository getnRepo() {
		return nRepo;
	}
	public void setnRepo(NinjaRepository nRepo) {
		this.nRepo = nRepo;
	}
	public List<Dojo> getAllDojosById() {
		
		return dRepo.findAll();
	}
	public void createNinja1(Ninja ninja) {
		dRepo.save(ninja);
		
	}
	



}
