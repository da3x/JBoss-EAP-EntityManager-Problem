package eu.ecg.test;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Named
@ConversationScoped
public class MyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String VIEW_ID = "/Transactional.xhtml?faces-redirect=true";

    @Inject
    @ApplicationManaged
    private EntityManager em1;

    @Inject
    @ContainerManaged
    private EntityManager em2;

    private String value;

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

    @Transactional
    public String select1() {
        System.out.println("MyBean.select1()");
        this.em1.flush(); // NOTE: needs Transaction!
        System.out.println("OK!");
        return VIEW_ID;
    }

    @Transactional
    public String select2() {
        System.out.println("MyBean.select2()");
        this.em2.flush(); // NOTE: needs Transaction!
        System.out.println("OK!");
        return VIEW_ID;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
