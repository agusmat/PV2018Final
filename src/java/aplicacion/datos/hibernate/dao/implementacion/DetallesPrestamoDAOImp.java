/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.DetallesPrestamoDAO;
import aplicacion.datos.hibernate.mapeos.DetallesPrestamos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Tomas Fernandez EdM
 */
public class DetallesPrestamoDAOImp implements DetallesPrestamoDAO {

	@Override
	public List<DetallesPrestamos> obtenerTodos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(DetallesPrestamos.class);
		List listado = criteria.list();
		session.close();
		return listado; //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public DetallesPrestamos consulta(String nombreUsuario, String password) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void modificar(DetallesPrestamos unDetallesPrestamo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(unDetallesPrestamo);
		session.getTransaction().commit();
		session.close(); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void agregar(DetallesPrestamos unDetallesPrestamo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(unDetallesPrestamo);
		session.getTransaction().commit();
		session.close(); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminar(DetallesPrestamos unDetallesPrestamo) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
