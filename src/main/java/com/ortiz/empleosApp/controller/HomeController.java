package com.ortiz.empleosApp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ortiz.empleosApp.model.Vacante;

@Controller
public class HomeController {

	@GetMapping("/tabla")
	public String  mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
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
//		model.addAttribute("mensaje", "Bienvenidos a empleos App");
//		model.addAttribute("fecha", new Date());
		
		String nombre ="Auxiliar de Contabilidad";
		Date fechaPub = new Date();
		double salario = 9000.0;
		boolean vigente = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fechaPub", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
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
	
	
	
	
	private List<Vacante> getVacantes(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> listaVacantes= new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing Civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("09-02-2022"));
			vacante1.setSalario(8500.0);
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Solicitamos Contador public para diseñar puente peatonal");
			vacante2.setFecha(sdf.parse("09-02-2022"));
			vacante2.setSalario(8500.0);
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(2);
			vacante3.setNombre("Ingeniero electrico");
			vacante3.setDescripcion("Solicitamos ingeniero electrico para diseñar puente peatonal");
			vacante3.setFecha(sdf.parse("09-02-2022"));
			vacante3.setSalario(8500.0);
			
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(2);
			vacante4.setNombre("Diseñador grafico");
			vacante4.setDescripcion("Solicitamos diseñador grafico para diseñar puente peatonal");
			vacante4.setFecha(sdf.parse("09-02-2022"));
			vacante4.setSalario(8500.0);
			
			listaVacantes.add(vacante1);
			listaVacantes.add(vacante2);
			listaVacantes.add(vacante3);
			listaVacantes.add(vacante4);
				
		}catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
		return listaVacantes;
		
	}
}
