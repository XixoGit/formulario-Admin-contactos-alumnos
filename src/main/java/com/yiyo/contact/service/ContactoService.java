package com.yiyo.contact.service;

import java.util.List;

import com.yiyo.contact.entity.Contacto;

public interface ContactoService {
	
	public void addContact(Contacto contact);
	public List<Contacto> listContact();
	public void removeContact(Long id);

}
