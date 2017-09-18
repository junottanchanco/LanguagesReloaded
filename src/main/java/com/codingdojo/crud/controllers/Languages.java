package com.codingdojo.crud.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codingdojo.crud.models.Language;
import com.codingdojo.crud.services.LanguageService;

@Controller
public class Languages {
	
	private final LanguageService languageService;
	
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String lang(Model model) {
		model.addAttribute("lang", new Language());
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "languages.jsp";
	}
	
	@RequestMapping("/languages/show/{id}")
	public String showLang(Model model, @PathVariable("id") Long id) {
		model.addAttribute("language", languageService.findLanguageById(id));
		return "showLanguage.jsp";
	}
	
	@PostMapping("/languages/new")
	public String createLang(@Valid @ModelAttribute("lang") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}else {
			languageService.addLanguage(language);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguageById(id);
		if(language != null) {
			model.addAttribute("language", language);
			return "editLanguage.jsp";
		}else {
			return "redirect:/";
		}
	}
	@PostMapping("/languages/edit/{id}")
	public String updateLang(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") int id) {
		if(result.hasErrors()) {
			return "editLanguage.jsp";
		}else {
			languageService.updateLanguage(language);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String deleteLang(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
}
