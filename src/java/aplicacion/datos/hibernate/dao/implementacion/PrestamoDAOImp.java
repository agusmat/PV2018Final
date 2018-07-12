/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PrestamoDAO;
import aplicacion.datos.hibernate.mapeos.Editoriales;
import aplicacion.datos.hibernate.mapeos.Prestamos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tomas
 */
public class PrestamoDAOImp implements PrestamoDAO{

    @Override
    public List<Prestamos> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Prestamos.class);
        List listado=criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    public Prestamos consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Prestamos unPrestamo) {
Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unPrestamo);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Prestamos unPrestamo) {
Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unPrestamo);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Prestamos unPrestamo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
