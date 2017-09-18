package com.codingdojo.crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.crud.models.Language;
import com.codingdojo.crud.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return (List<Language>) languageRepository.findAll();
	}
	
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.delete(id);
	}
	
	public Language findLanguageById(Long id) {
		return languageRepository.findOne(id);
	}
	
	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
}
