//package cz.vsb.vea.cz.vsb.vea.lab02v2.repositories;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.stereotype.Repository;
//
//import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Order;
//import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
//
//@Repository
//@ConditionalOnProperty(
//		  value="accessType",
//		  havingValue = "jpa",
//		  matchIfMissing = false)
//
//public class PersonRepositoryJpa implements PersonRepositoryInterface{
//
//	@PersistenceContext
//	private EntityManager em;
//
//	public List<Person> getAllPersons() {
//		return em.createQuery("SELECT p FROM Person p",
//				Person.class).getResultList();
//	}
//
//	public Person find(long id) {
//		return em.find(Person.class, (int)id);
//	}
//
//	@Transactional
//	public Person save(Person person) {
//		if (person.getId() == 0) {
//			em.persist(person);
//		} else {
//			person = em.merge(person);
//		}
//		return person;
//	}
//
//	@Transactional
//	public Order saveOrder(Order order) {
//		if (order.getId() == 0) {
//			em.persist(order);
//		} else {
//			order = em.merge(order);
//		}
//		return order;
//	}
//
//}
