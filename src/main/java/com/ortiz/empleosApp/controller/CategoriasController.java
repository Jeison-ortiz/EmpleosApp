package com.ortiz.empleosApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value ="/categorias")
public class CategoriasController {

	@GetMapping("/index")
	public String mostrarIndex() {
		return "categorias/listCategorias";
	}
	
	@GetMapping("/listCategorias")
	public String listarVacantes(Model model) {
		System.out.println("Se llama a listar vacantes");
		return "categorias/listCategorias";
	}
	
	@GetMapping("/crear")
	public String crear() {
		return "categorias/formCategorias";
	}
	
	@PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre) {
		System.out.println("Categoria: " + nombre);		
		return "categorias/listCategorias";
	}
}
