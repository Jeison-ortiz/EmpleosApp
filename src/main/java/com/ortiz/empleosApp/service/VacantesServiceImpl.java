package com.ortiz.empleosApp.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ortiz.empleosApp.model.Vacante;

@Service
public class VacantesServiceImpl implements IVacanteService {

	private List<Vacante> listaVacantes = null;
	
	public VacantesServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		listaVacantes= new LinkedList<Vacante>();
		try {
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing Civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("09-02-2022"));
			vacante1.setSalario(890000.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");	
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Solicitamos Contador public para diseñar puente peatonal");
			vacante2.setFecha(sdf.parse("09-02-2022"));
			vacante2.setSalario(8500.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero electrico");
			vacante3.setDescripcion("Solicitamos ingeniero electrico para diseñar puente peatonal");
			vacante3.setFecha(sdf.parse("09-02-2022"));
			vacante3.setSalario(8500.0);
			vacante3.setDestacado(0);
			
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador grafico");
			vacante4.setDescripcion("Solicitamos diseñador grafico para diseñar puente peatonal");
			vacante4.setFecha(sdf.parse("09-02-2022"));
			vacante4.setSalario(8500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa3.png");
			
			listaVacantes.add(vacante1);
			listaVacantes.add(vacante2);
			listaVacantes.add(vacante3);
			listaVacantes.add(vacante4);
				
		}catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	@Override
	public List<Vacante> buscarTodas() {	
		return listaVacantes;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		
		for(Vacante vacante: listaVacantes) {
			if (vacante.getId() == idVacante){
				return vacante;
			}
		}
		
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		listaVacantes.add(vacante);
		
	}

}
