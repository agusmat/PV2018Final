/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PublicacionesDAO;
import aplicacion.datos.hibernate.mapeos.Publicaciones;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Agustin
 */
public class PublicacionesDAOImp implements PublicacionesDAO {

    @Override
    public List<Publicaciones> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Publicaciones.class);
        criteria.add(Restrictions.like("pubEstado", true));
        List listado=criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publicaciones consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Publicaciones usuario) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
     //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Publicaciones usuario) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Publicaciones usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
