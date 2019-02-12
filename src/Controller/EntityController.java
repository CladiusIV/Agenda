/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alumno
 */
public class EntityController extends GestorContactos{

    public static void EntityControllerOpen() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaPU");
        javax.persistence.EntityManager em = emf.createEntityManager();
        
    }
    
    public void EntityControllerClose(){
        
    }
}
