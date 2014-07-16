package br.com.truefriends.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory=
    Persistence.createEntityManagerFactory("truefriends");
	
	public EntityManager getEntityManager(){
		
		return entityManagerFactory.createEntityManager();
		
	}
	
}
