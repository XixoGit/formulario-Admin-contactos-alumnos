package com.yiyo.contact.service;

import java.util.List;

import com.yiyo.contact.entity.Alumno;
/*
 *   4° Creo la interfaz AlumnoService, idem al AlumnoDAO
 */
public interface AlumnoService {
	
	
	public void agregaAlumno(Alumno alumno); 
	public List<Alumno> mostrarAlumno();       //SELECT
	public void eliminaAlumno(Long id);       //DELETE
    
	public void modificaAlumno(Long id);
	
}
