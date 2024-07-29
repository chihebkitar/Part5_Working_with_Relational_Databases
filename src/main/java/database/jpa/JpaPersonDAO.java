package database.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaPersonDAO implements PersonDAO{
    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hr");
    // EntityManagerFactory is a class that produces EntityManagers
    // EntityManager is how u interact with the db
    // EntityManager replaces ps , conn ... from jdbc
    // EntityManagerFactory has methods in it to auto work with rdb
    // to configure EntityManagerFactory we use class and method
    // Persistence.createEntityManagerFactory with persistence unit as argument
    // we should have inside ress a folder metainf with persistence xml file
    // represent the configs of the db for our provider hibernate
    // when we call EntityManagerFactory it reads pers.xml , map .....

    @Override
    public List<Person> findAll() {
        EntityManager em = emf.createEntityManager();
        // retrieve the em
        em.getTransaction().begin();
        // transaction in each method , bad approach since we only have jpa not spring
        List<Person> people = em.createQuery(
                "select p from Person p", Person.class).getResultList();
        // jpql , work with class not table
        // hibernate will do the rest
        em.getTransaction().commit();
        em.close();
        return people;
    }

    @Override
    public Person findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        // find by pk
        em.getTransaction().commit();
        em.close();
        return person;
    }

    @Override
    public Integer save(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        // save is deprecated
        em.getTransaction().commit();
        em.close();
        return p.getId();
    }

    @Override
    public void delete(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Person.class, p.getId()));
        // find returns that person
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Integer> getIds() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Integer> ids = em.createQuery("select p.id from Person p", Integer.class)
                .getResultList();
        return ids;
    }
    // spring will be simpler
    // spring boot even simpler combines spring and jpa
    // Spring is a comprehensive framework for building Java applications that provides extensive support for programming and configuring features such as dependency injection and transaction management. It requires manual setup and detailed configuration, often using XML or annotations. In contrast, Spring Boot builds on Spring to simplify the development process. It focuses on convention over configuration, offering auto-configuration based on library dependencies, and includes an embedded server, enabling quick and easy setup of standalone applications. Essentially, while Spring offers more control and flexibility, Spring Boot provides a faster, more streamlined way to develop Spring applications with less manual configuration.
}
