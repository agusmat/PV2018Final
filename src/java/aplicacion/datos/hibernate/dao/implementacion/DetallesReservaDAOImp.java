/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.DetallesReservaDAO;
import aplicacion.datos.hibernate.mapeos.DetallesPrestamos;
import aplicacion.datos.hibernate.mapeos.DetallesReservas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Tomas
 */
public class DetallesReservaDAOImp implements DetallesReservaDAO{

    @Override
    public List<DetallesReservas> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(DetallesReservas.class);
		List listado = criteria.list();
		session.close();
		return listado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetallesReservas consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(DetallesReservas unDetallesReservas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(unDetallesReservas);
		session.getTransaction().commit();
		session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(DetallesReservas unDetallesReservas) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(unDetallesReservas);
		session.getTransaction().commit();
		session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(DetallesReservas unDetallesReservas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
