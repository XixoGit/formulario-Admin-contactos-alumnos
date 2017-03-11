package com.yiyo.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yiyo.contact.dao.AlumnoDAO;
import com.yiyo.contact.entity.Alumno;

/*
 *   4° usamos la interfaz AlumnoService
 */
@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
    private AlumnoDAO alumnoDAO;
	                                  //@Transactional es otra anotacion de spring,indica que el metodo en cuestion realizara transacciones
	@Transactional
	public void agregaAlumno(Alumno al) {
		 alumnoDAO.addAlumno(al);
		
	}

	@Transactional
	public List<Alumno> mostrarAlumno() {
		 
		return alumnoDAO.listAlumno();
	}

	@Transactional 
	public void eliminaAlumno(Long id) {
		 
		alumnoDAO.deleteAlumno(id);
	}

	@Transactional
	public void modificaAlumno(Long id) {
		 
		alumnoDAO.editAlumno(id);
	}

}
