package com.dmr.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Singleton
public class PersistenceUtilHibernateImpl implements PersistenceUtil {
	private static SessionFactory factory;
	private static PersistenceUtilHibernateImpl instance;

	private PersistenceUtilHibernateImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException ex) {
//			throw new PersistenceInitialisationException("str", ex);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static synchronized PersistenceUtilHibernateImpl getInstance() {
		if (instance == null) {
			instance = new PersistenceUtilHibernateImpl();
		}
		return instance;
	}

	public static SessionFactory getSessionFactory() {
		if (instance == null) {
			instance = new PersistenceUtilHibernateImpl();
		}
		return factory;
	}
}
