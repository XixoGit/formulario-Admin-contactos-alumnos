package com.yiyo.contact.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yiyo.contact.entity.Alumno;
import com.yiyo.contact.service.AlumnoService;

@Controller
public class AlumnoController {
	         
	@Autowired
	private AlumnoService alumnoService;
                                                                  //Listar select
	@RequestMapping("/listar")
	public String listar(Map<String, Object> map){
		map.put("alumnocomand", new Alumno());
		map.put("listadoAlum", alumnoService.mostrarAlumno());
		
		return "alumnos";
	}
		                                                                        //Agregar  insert
	@RequestMapping(value = "/agrega", method = RequestMethod.POST)
	public String agregar(@ModelAttribute("alu")Alumno a, BindingResult result ){
		
		alumnoService.agregaAlumno(a);
		
		return "redirect:/listar";
	}
	                                                                //eliminar Delete - http://localhost:8081/contacto-manager/elimina/4
	@RequestMapping("/elimina/{alumnoId}")                                                                                   //elimina al registro 4
	public String eliminar(@PathVariable("alumnoId") Long alumnoId){
		
		alumnoService.eliminaAlumno(alumnoId);
		
		return "redirect:/listar";
	}

	@RequestMapping("/modifica/{alumnoId}")                                                                                   //elimina al registro 4
	public String modifica(@PathVariable("alumnoId") Long alumnoId){
		
		alumnoService.modificaAlumno(alumnoId);
		
		return "redirect:/listar";
	}
}

