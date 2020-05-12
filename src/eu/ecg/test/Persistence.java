package eu.ecg.test;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class Persistence implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceUnit(unitName = "example")
    private EntityManagerFactory factory;

    @PersistenceContext(unitName = "example")
    private EntityManager em;

    /**
     * @see PersistenceContextType#EXTENDED
     */
    @Produces
    @ApplicationManaged
    public EntityManager applicationManaged() {
        System.out.println("Persistence.applicationManaged()");
        return this.factory.createEntityManager();
    }

    /**
     * @see PersistenceContextType#TRANSACTION
     */
    @Produces
    @ContainerManaged
    public EntityManager containerManaged() {
        System.out.println("Persistence.containerManaged()");
        return this.em;
    }

}