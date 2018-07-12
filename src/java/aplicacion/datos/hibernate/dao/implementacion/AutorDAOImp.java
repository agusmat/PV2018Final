/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.AutorDAO;
import aplicacion.datos.hibernate.mapeos.Autores;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tomas
 */
public class AutorDAOImp implements AutorDAO {

    @Override
    public List<Autores> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Autores.class);
        List listado = criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    public Autores consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Autores unAutor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unAutor);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Autores unAutor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unAutor);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Autores unAutor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
