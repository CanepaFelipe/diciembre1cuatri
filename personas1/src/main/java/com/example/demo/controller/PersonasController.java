package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.repository.PersonasRepository;

@Controller
public class PersonasController {
	@Autowired
	private PersonasRepository PersonaRepository;

	@GetMapping("/personas1")
	public String listarPersonas(Model model) {
		model.addAttribute("personas1", PersonaRepository.findAll());
		return "index";
	}

	@PostMapping("/personas1")
	public String agregarPersona(@RequestBody Personas persona) {
		PersonaRepository.save(persona);
		return "redirect:/index";
	}

	@GetMapping("eliminar/(id)")
	public String delete(Model model, @PathVariable int id) {
	service.delete(id);
	return "redirect:/listar";
	}
	}