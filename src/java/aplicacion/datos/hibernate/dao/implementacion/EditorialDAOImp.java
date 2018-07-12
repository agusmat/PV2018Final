/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.implementacion;


import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.EditorialDAO;
import aplicacion.datos.hibernate.mapeos.Editoriales;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Agustin
 */
public class EditorialDAOImp implements EditorialDAO {

    @Override
    public List<Editoriales> obtenerTodos() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Editoriales.class);
        criteria.add(Restrictions.like("editEstado", true));
        List listado=criteria.list();
        session.close();
        return listado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editoriales consulta(String nombreUsuario, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Editoriales unaEditorial) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unaEditorial);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Editoriales unaEditorial) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(unaEditorial);
        session.getTransaction().commit();
        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Editoriales unaEditorial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
