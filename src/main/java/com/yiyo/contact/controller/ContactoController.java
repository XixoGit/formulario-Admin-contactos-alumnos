package com.yiyo.contact.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yiyo.contact.entity.Contacto;
import com.yiyo.contact.service.ContactoService;

 //Nuestro controlador Spring tiene tres métodos para manipular la gestión de contactos.

@Controller
public class ContactoController {
	
	@Autowired
	private ContactoService contactoService;
	
	//listContact: obtiene los contactos de la BD y los muestra
	                                                               // Este metodo utiliza la capa Service
	@RequestMapping("/")                                       //la interfaz contactoService y su implementacion
	public String listContacts(Map<String, Object> map) {           // y obtiene todos los contactos de nuestra app

		map.put("contacto", new Contacto());
		map.put("listadoContactos", contactoService.listContact());

		return "contactos";
	}
    //addContact: añade contactos
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")Contacto contact, BindingResult result) {    //con @ModelAttribute("contact") obtenemos los datos del contacto
	 

		contactoService.addContact(contact);

		return "redirect:/";   //este metodo redirecciona al index
	}
	
	//DeleteContact  : elimina un contacto
	
	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId")   //Este metodo necesita el id para eliminar el contacto
	Long contactId) {

		contactoService.removeContact(contactId);

		return "redirect:/";         // este metodo redirecciona al index
	}
	
}
