/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author alumno
 */
public class GestorContactos {

    EntityManagerFactory emf;
    EntityManager em;
    
    public GestorContactos()
    {
        emf = Persistence.createEntityManagerFactory("AgendaPU");    
        em = emf.createEntityManager();
    }
    
    public void agregar(Contacto nuevo) {
        em.getTransaction().begin();
        em.persist(nuevo);
        em.getTransaction().commit();
    }

    public void agregarTel(Telefonos nuevo){
        em.getTransaction().begin();
        em.persist(nuevo);
        em.getTransaction().commit();
    }
    
    public List<Contacto> listarTodos() {

        Query q = em.createQuery("select c from Contacto c");
        List<Contacto> salida = q.getResultList();

        return salida;
    }

    public void actualizar(Contacto modificado) {
        em.getTransaction().begin();
        em.merge(modificado);
        em.getTransaction().commit();

    }

    public void borrar(int idCliente) {
        Contacto c = em.find(Contacto.class, idCliente);
        if (c != null) {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
    }
}
