package com.ortiz.empleosApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ortiz.empleosApp.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

}
