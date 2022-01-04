//package cz.vsb.vea.cz.vsb.vea.lab02v2.DAO.jpa;
//
//import cz.vsb.vea.cz.vsb.vea.lab02v2.DAO.PersonDao;
//import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Transactional
//@Repository
//public class PersonDaoJpa implements PersonDao<Person> {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public Person insert(Person person) {
//        em.persist(person);
//        em.flush();
//        return person;
//    }
//
//    @Override
//    public List<Person> getAll() {
//        return em.createQuery("select t from Person t", Person.class).getResultList();
//    }
//
//    @Override
//    public Person findById(long id) {
//        return em.find(Person.class, id);
//    }
//
//    @Override
//    public Person update(Person person) {
//        em.merge(person);
//        em.flush();
//        return person;
//    }
//
//    @Override
//    public void delete(long id) {
//        Person person = em.find(Person.class, id);
//        em.remove(person);
//    }
//}