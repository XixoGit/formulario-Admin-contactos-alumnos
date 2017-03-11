package com.yiyo.contact.dao;

import java.util.List;

import com.yiyo.contact.entity.Alumno;
/*
 *   2° Creo la interfaz Alumno, con los metodos definidos, sin implementar
 */
public interface AlumnoDAO {
	
	public void addAlumno(Alumno alumno);   // INSERT
	public List<Alumno> listAlumno();       //SELECT
	public void deleteAlumno(Long id);       //DELETE
	 
	public void editAlumno(Long id);
}
