package com.ortiz.empleosApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.println("IdVacante: " + idVacante);
		model.addAttribute("idVacante", idVacante);		
		//TODO Buscar los detalles en la base de datos
		return "vacantes/detalle";
	}
	
	@GetMapping("/delete")
	public String EliminarVacante(@RequestParam("id") int idVacante, Model model) {
		model.addAttribute("idVacante", idVacante);
		System.out.println("borrandpo vacante con ID:" + idVacante);
		return "vacantes/mensaje";
	}
}
