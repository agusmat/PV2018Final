/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.ReservasDAO;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.Reservas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tiago
 */
public class ReservasDAOImp implements ReservasDAO {

    @Override
    public List<Reservas> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Reservas.class);
        criteria.add(Restrictions.like("revEstado", true));
        List listado=criteria.list();
        session.close();
        return listado;
    }

    @Override
    public Perfiles consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Reservas usuario) {
         Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Reservas usuario) {
       Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Reservas usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
