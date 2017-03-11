package com.yiyo.contact.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yiyo.contact.entity.Alumno;


/*
 *   3° implemento los metodos
 */

@Repository                                           //@Repository y @Autowired son anotaciones exclusiva de Spring
public class AlumnoDAOImpl  implements AlumnoDAO{
	//@Repository indica que la clase AlumnoDAOimple esta fuertemente ligada a la persistencia con la BD
	
	
	 // SessionFactory: Es el responsable de crear la sesión a través de la cual Hibernate realizara las transacciones y accesos de datos pertinentes.
	@Autowired
	private SessionFactory sessionFactory; //con @Autowired Hace que se instancie la clase SessionFactory
	 
	
	public void addAlumno(Alumno alumno) {  //agragamos contacto
		 
		sessionFactory.getCurrentSession().save(alumno); //obtiene la sesion y guarda los datos del alumno
	}

	@Override 
	public List<Alumno> listAlumno() {
		 
		return sessionFactory.getCurrentSession().createQuery("from Alumno").list();//retorna el alumno
	}
	@Override
	public void deleteAlumno(Long id) {   //elimina por id
		 Alumno alumno = (Alumno) sessionFactory.getCurrentSession().load(Alumno.class, id);//se obtiene el alumno en cuestion con su id
		 if (null != alumno) {
				sessionFactory.getCurrentSession().delete(alumno);
			}
	}


	@Override
	public void editAlumno(Long id) {
		 Alumno alumno = (Alumno) sessionFactory.getCurrentSession().load(Alumno.class, id);
		 if (null != alumno) {
				sessionFactory.getCurrentSession().update(alumno);;
			}
	}
	

}
