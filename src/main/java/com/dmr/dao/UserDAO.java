package com.dmr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dmr.model.User;
import com.dmr.util.PersistenceUtilJPAImpl;

public class UserDAO extends GenericDAO<User> {

	public UserDAO() {
		typeParameterClass = User.class;
	}

	public boolean findByLoginAndPassword(String login, String password) {
		EntityManager em = PersistenceUtilJPAImpl.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("from User where login=?1 and password=?2");
		q.setParameter(1, login);
		q.setParameter(2, password);
		List<User> users = q.getResultList();
		em.close();
		if (users != null) {
			return true;
		}
		return false;
	}

	public List<User> findByMail(String mail) {
		EntityManager em = PersistenceUtilJPAImpl.getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("select u from User u where u.mail=?1");
		q.setParameter(1, mail);
		List<User> users = q.getResultList();
		em.close();
		return users;
	}
}
