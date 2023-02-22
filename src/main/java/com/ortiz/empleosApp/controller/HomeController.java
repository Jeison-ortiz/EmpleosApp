package com.ortiz.empleosApp.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ortiz.empleosApp.model.Vacante;
import com.ortiz.empleosApp.service.IVacanteService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacanteService serviceVacantes;

	@GetMapping("/tabla")
	public String  mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		System.out.println("Lista->>>>>" + lista);
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a ortizNet");
		vacante.setFecha(new Date());
		vacante.setSalario(9865.0);
		model.addAttribute("vacante", vacante);
		return "detalle";
		
	}
	
	@GetMapping("/")
	public String mostraHomeM(Model model) {		
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "home";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de sistemas");
		lista.add("Auxiliar de conta");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		return "listado";
	}

}
