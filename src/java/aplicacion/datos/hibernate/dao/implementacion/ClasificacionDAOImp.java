/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.ClasificacionDAO;
import aplicacion.datos.hibernate.mapeos.Clasificaciones;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Tomas Fernandez EdM
 */
public class ClasificacionDAOImp implements ClasificacionDAO{

	@Override
	public List<Clasificaciones> obtenerTodos() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clasificaciones.class);
        List listado=criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Clasificaciones consulta(String nombreUsuario, String password) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void modificar(Clasificaciones unaClasificacion) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaClasificacion);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void agregar(Clasificaciones unaClasificacion) {
		Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaClasificacion);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminar(Clasificaciones unaClasificacion) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
