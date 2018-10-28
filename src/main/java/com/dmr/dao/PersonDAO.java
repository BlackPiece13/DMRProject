package com.dmr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dmr.model.Person;
import com.dmr.util.PersistenceUtilJPAImpl;

public class PersonDAO extends GenericDAO<Person> {

	public PersonDAO() {
		typeParameterClass = Person.class;
	}

	public List<Person> findByName(String firstName, String lastName) {
		EntityManager em = PersistenceUtilJPAImpl.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("select p from Person p where lastName=?1 and firstName=?2");
		q.setParameter(2, firstName);
		q.setParameter(1, lastName);
		List<Person> persons = q.getResultList();
		em.close();
		return persons;
	}

}
