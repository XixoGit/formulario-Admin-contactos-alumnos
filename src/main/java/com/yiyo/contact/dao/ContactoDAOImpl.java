package com.yiyo.contact.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yiyo.contact.entity.Contacto;
                                
@Repository
public class ContactoDAOImpl implements ContactoDAO {
    
	@Autowired
	private SessionFactory sessionFactory;

	// Agregamos Contacto
	public void addContact(Contacto contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	 // Listamos contacto
	public List<Contacto> listContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contacto").list();
	}

	 //eliminamos contacto
	public void removeContact(Long id) {
	  Contacto contact = (Contacto) sessionFactory.getCurrentSession().load(Contacto.class, id);
		
	  if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}
	 }
	

}
