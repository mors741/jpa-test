package com.mors741.jpa;

import javax.persistence.*;
import java.util.List;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "test";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // create new teller
        em.getTransaction().begin();
        Teller teller = new Teller();
        teller.setId(1L);
        teller.setName("Teller1");
        TellerPosKeys keys = new TellerPosKeys();
        keys.setTellerId(teller.getId());
        keys.setMasterKey("MASTER0KEY");
        keys.setPrivateKey("PRIVATE0KEY");
        teller.setPosKeys(keys);
        em.persist(teller);
        em.getTransaction().commit();

        // read the existing entries and write to console
        TypedQuery<Teller> q = em.createQuery("select t from Teller t", Teller.class);
        List<Teller> tellerList = q.getResultList();
        for (Teller t : tellerList) {
            System.out.println(t);
        }
        System.out.println("Size: " + tellerList.size());

        em.close();
    }
}
