package com.springboot.organizer.list;


import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ListLearningController {
	
	public ListLearningController(ListLearningRepository listLearningRepository) {
		super();
		this.listLearningRepository = listLearningRepository;
	}

	private ListLearningRepository listLearningRepository;
			
	@GetMapping("list-learning")
	public String listAllforms(ModelMap model) {
		String username = getLoggedInUsername(model);
				
		List<ListLearning> forms = listLearningRepository.findByUsername(username);
		model.addAttribute("forms", forms);
		
		return "listLearning";
	}

	@GetMapping("add-form")
	public String showNewformPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		ListLearning form = new ListLearning(0, username, "", LocalDate.now().plusMonths(1), false);
		model.put("form", form);
		return "form";
	}

	@PostMapping("add-form")
	public String addNewform(ModelMap model, @Valid ListLearning form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "form";
		}
		
		String username = getLoggedInUsername(model);
		form.setUsername(username);
		listLearningRepository.save(form);
		return "redirect:list-learning";
	}

	@GetMapping("delete-form")
	public String deleteform(@RequestParam int id) {
		listLearningRepository.deleteById(id);
		return "redirect:list-learning";
		
	}

	@GetMapping(value="update-form")
	public String showUpdateformPage(@RequestParam int id, ModelMap model) {
		ListLearning form = listLearningRepository.findById(id).get();
		model.addAttribute("form", form);
		return "form";
	}

	@PostMapping(value="update-form")
	public String updateform(ModelMap model, @Valid ListLearning form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "form";
		}
		
		String username = getLoggedInUsername(model);
		form.setUsername(username);
		listLearningRepository.save(form);
		return "redirect:list-learning";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}