package com.yiyo.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yiyo.contact.dao.ContactoDAO;
import com.yiyo.contact.entity.Contacto;

@Service
public class ContactoServiceImpl implements ContactoService{
	
	@Autowired
	private ContactoDAO contactoDAO;

	@Transactional
	public void addContact(Contacto contact) {
		  contactoDAO.addContact(contact);
		
	}

	@Transactional
	public List<Contacto> listContact() {
		 
		return  contactoDAO.listContact();
	}

	@Transactional
	public void removeContact(Long id) {
		 
		contactoDAO.removeContact(id);
	}

}
