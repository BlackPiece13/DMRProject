package com.dmr.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtilJPAImpl implements PersistenceUtil {
	private static PersistenceUtilJPAImpl instance;
	private static EntityManagerFactory emf;

	private PersistenceUtilJPAImpl() {
		try {
			emf = Persistence.createEntityManagerFactory("bibliotheque-pu");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static synchronized PersistenceUtilJPAImpl getInstance() {
		if (instance == null) {
			instance = new PersistenceUtilJPAImpl();
		}
		return instance;
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (instance == null) {
			instance = new PersistenceUtilJPAImpl();
		}
		return emf;
	}
}
