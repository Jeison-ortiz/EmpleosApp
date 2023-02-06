package com.ortiz.empleosApp.service;

import java.util.List;

import com.ortiz.empleosApp.model.Vacante;

public interface IVacanteService {
	
	List<Vacante> buscarTodas();
	
	Vacante buscarPorId(Integer idVacante);
	
	void guardar (Vacante vacante);
}
