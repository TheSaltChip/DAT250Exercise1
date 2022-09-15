package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Person p = new Person();
        p.setName("Max Mustermann");

        Address a = new Address();
        a.setNumber(28);
        a.setStreet("Inndalsveien");
        a.addOwner(p);

        Pincode pc = new Pincode();
        pc.setCount(1);
        pc.setPincode("123");

        CreditCard c1 = new CreditCard();
        c1.setLimit(-10000);
        c1.setBalance(-5000);
        c1.setNumber(12345);
        c1.setPincode(pc);


        CreditCard c2 = new CreditCard();
        c2.setLimit(2000);
        c2.setBalance(1);
        c2.setNumber(123);
        c2.setPincode(pc);

        Bank bank = new Bank();
        bank.addCreditCard(c1);
        bank.addCreditCard(c2);
        bank.setName("Pengebank");

        c1.setOwningBank(bank);
        c2.setOwningBank(bank);

        p.addAddress(a);
        p.addCreditCard(c1);
        p.addCreditCard(c2);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        em.persist(bank);
        em.persist(pc);
        tx.commit();
        em.close();
        factory.close();

        // TODO: Persist object world corresponding to the domain model of experiment 2.
    }
}
