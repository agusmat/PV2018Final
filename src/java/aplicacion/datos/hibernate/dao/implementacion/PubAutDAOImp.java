/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.PubAutDAO;
import aplicacion.datos.hibernate.mapeos.Perfiles;
import aplicacion.datos.hibernate.mapeos.PubAut;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Tomas
 */
public class PubAutDAOImp implements PubAutDAO {

    @Override
    public List<PubAut> obtenerTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(PubAut.class);
        List listado = criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfiles consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(PubAut unPubAut) {
         Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(unPubAut);
		session.getTransaction().commit();
		session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(PubAut unPubAut) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(unPubAut);
		session.getTransaction().commit();
		session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(PubAut unPubAut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
