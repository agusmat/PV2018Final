/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;


import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PubClaDAO;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.PubCla;
import java.util.List;
import org.apache.catalina.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author Agustin
 */
public class PubClaDAOImp implements PubClaDAO {
    
    
    @Override
    public List<PubCla> obtenerTodos() {
        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Perfiles.class);
        criteria.add(Restrictions.like("pcEstado", true));
        List listado=criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PubCla consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void modificar(PubCla usuario) {
        org.hibernate.Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(PubCla usuario) {
        org.hibernate.Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(PubCla usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
