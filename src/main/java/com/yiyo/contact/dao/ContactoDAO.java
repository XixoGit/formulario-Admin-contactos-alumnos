package com.yiyo.contact.dao;

import java.util.List;

import com.yiyo.contact.entity.Contacto;

public interface ContactoDAO {

	public void addContact(Contacto contact);
	public List<Contacto> listContact();
	public void removeContact(Long id);
	
	
}
