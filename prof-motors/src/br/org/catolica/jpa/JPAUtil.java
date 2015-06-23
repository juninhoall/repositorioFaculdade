package br.org.catolica.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JPAUtil {

	private static final String PERSISTENCE_UNIT_NAME = "default";

	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	private JPAUtil() {
	}

	public static boolean isEntityManagerOpen(){
		return JPAUtil.manager.get() != null && JPAUtil.manager.get().isOpen();
	}
	
	public static EntityManager getEntityManager() {
		if (JPAUtil.factory == null) {
			JPAUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager em = JPAUtil.manager.get();
		if (em == null || !em.isOpen()) {
			em = JPAUtil.factory.createEntityManager();
			JPAUtil.manager.set(em);
		}
		return em;
	}
	
	public static void evictCache(EntityManager em, String region){
		((Session)em.getDelegate()).getSessionFactory().getCache().evictQueryRegion(region);
	}

	public static void closeEntityManager() {
		EntityManager em = JPAUtil.manager.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) { 
				tx.commit();
			}
			em.close();
			JPAUtil.manager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory(){
		closeEntityManager();
		JPAUtil.factory.close();
	}
}
