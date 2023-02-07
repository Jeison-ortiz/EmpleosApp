package com.ortiz.empleosApp.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ortiz.empleosApp.model.Vacante;
import com.ortiz.empleosApp.service.IVacanteService;
import com.ortiz.empleosApp.util.Utilieria;


@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	IVacanteService vacanteService;
	
	Utilieria utileria;
	
	@GetMapping("/crear")
	public String crear() {
		System.out.println("Se llama al metodo post ");
		return "vacantes/formVacantes";
	}
	
	@GetMapping("/listVacantes")
	public String listarVacantes(Model model) {
		
		System.out.println("Se llama a listar vacantes");
		return "vacantes/listVacantes";
	}
	
	@PostMapping("/save2")
	public String guardar2(Vacante vacante, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart) {
		
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un herror: " +error.getDefaultMessage());
			}
			return "vacantes/formVacantes";
		}
		
		if(!multiPart.isEmpty()) {
			String ruta = "c:/empleos/img-vacantes";
			String nombreImagen = Utilieria.guardarArchivo(multiPart, ruta);
			if(nombreImagen != null) {
				vacante.setImagen(nombreImagen);
			}
		}
		vacanteService.guardar(vacante);
		attributes.addFlashAttribute("msg", "Registro guardado");
		System.out.println("Vacante ome: " + vacante);
		return "redirect:/vacantes/home";
	}
			
//	@PostMapping("/save")
//	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
//			@RequestParam("estatus") String status, @RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado,
//			@RequestParam("salario") double salario, @RequestParam("detalles") String detalles) {
//		System.out.println("Vacante:--->> ");	
//		return "vacantes/listVacantes";
//	}
	
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
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}

