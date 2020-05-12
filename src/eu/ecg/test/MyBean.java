package eu.ecg.test;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Named
public class MyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String VIEW_ID = "/Transactional.xhtml?faces-redirect=true";

    @Inject
    @ApplicationManaged
    private EntityManager em1;

    @Inject
    @ContainerManaged
    private EntityManager em2;

    @Transactional
    public String save1() {
        System.out.println("MyBean.save1()");
        this.em1.flush(); // NOTE: needs Transaction!
        System.out.println("OK!");
        return VIEW_ID;
    }

    @Transactional
    public String save2() {
        System.out.println("MyBean.save2()");
        this.em2.flush(); // NOTE: needs Transaction!
        System.out.println("OK!");
        return VIEW_ID;
    }
}
