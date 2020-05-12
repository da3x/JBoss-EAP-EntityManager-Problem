package eu.ecg.test;
import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Named
public class MyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    @ApplicationManaged
    private EntityManager em;

    @Transactional
    public void save() {
        System.out.println("MyBean.save()");
        this.em.flush(); // NOTE: needs Transaction!
        System.out.println("OK!");
    }

    @Transactional
    public void select() {
        System.out.println("MyBean.select()");
        this.em.flush(); // NOTE: needs Transaction!
        System.out.println("OK!");
    }
}
