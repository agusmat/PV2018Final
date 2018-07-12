/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PerfilDAO;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Usuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Agustin
 */
public class PerfilDAOImp implements PerfilDAO {

    @Override
    public List<Perfiles> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Perfiles.class);
        criteria.add(Restrictions.like("perEstado", true));
        List listado=criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfiles consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Perfiles usuario) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Perfiles usuario) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Perfiles usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
