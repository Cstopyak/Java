package com.colbystopyak.language.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.colbystopyak.language.models.Language;
import com.colbystopyak.language.repositories.LanguageRepository;


@Service
public class MainService {
	private final LanguageRepository aRepo;
		
	public MainService(LanguageRepository aRepo) {
		this.aRepo= aRepo;
	}
	
	//Get all Lang
	
	public List<Language> getAllLanguage(){
		return this.aRepo.findAll();
	}
	
	
	//find Language byID
	
	public Language findLanguageById(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	//Create a Lang
	
	public void createLanguage(String name, String creator, String version) {
		Language  newLanguage =new Language(name, creator, version);
		aRepo.save(newLanguage);
	}
	
	public void createLanguage(Language filledlanguage) {
		this.aRepo.save(filledlanguage);
	}
	
	
	public void updateLanguage(String name, String creator, String version) {
		Language  updateLanguage =new Language(name, creator, version);
		aRepo.save(updateLanguage);
	}
	
	public void updateLanguage(Language filledlanguage) {
		this.aRepo.save(filledlanguage);
	}
	
	
	public void deleteLanguage(Long id) {
		aRepo.deleteById(id);
	}

	



	public void deleteLanguageById(Long id) {
		aRepo.deleteById(id);
		
	}
}
