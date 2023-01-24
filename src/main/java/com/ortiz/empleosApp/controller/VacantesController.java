package com.ortiz.empleosApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ortiz.empleosApp.model.Vacante;
import com.ortiz.empleosApp.service.IVacanteService;


@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	IVacanteService vacanteService;
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.println("IdVacante: " + idVacante);
		Vacante vacante = vacanteService.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		System.out.println("Vacante:" + vacante);
		//TODO Buscar los detalles en la base de datos
		return "detalle";
	}
	
	@GetMapping("/delete")
	public String EliminarVacante(@RequestParam("id") int idVacante, Model model) {
		model.addAttribute("idVacante", idVacante);
		System.out.println("borrandpo vacante con ID:" + idVacante);
		return "vacantes/mensaje";
	}
}
