package com.dmr.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dmr.util.PersistenceUtilJPAImpl;

public abstract class GenericDAO<T> {

	protected Class<T> typeParameterClass;
	// private Session session; //native Hibernate solution
	private EntityManager em;

	public T findByID(Long id) {

		T person = em.find(typeParameterClass, id);
		return person;
	}

	public List<T> findAll() {
		List<T> list = em.createQuery("select c from " + typeParameterClass.getName() + " c").getResultList();
		return list;
	}

	public boolean save(T element) {
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(element);
			tx.commit();
			return true;
		} catch (EntityExistsException ex) {
			return false;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	public boolean remove(T element) {

		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(element);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(T element) {
		// Transaction tx = null;
		EntityTransaction tx = null;
		try {
			// tx = session.beginTransaction();
			tx = em.getTransaction();
			tx.begin();
			em.merge(element);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	public void intialiazeSession() {
		// session = PersistenceUtilHibernateImpl.getSessionFactory().openSession();
		em = PersistenceUtilJPAImpl.getEntityManagerFactory().createEntityManager();
	}

	public void closeSession() {
		em.close();
	}

}
