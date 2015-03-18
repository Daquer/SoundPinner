package br.com.truefriends.persistencia;

import javax.persistence.EntityManager;

import br.com.truefriends.modelo.Fitness;

public class FitnessDAO {
	
	private final EntityManager em;

	public FitnessDAO(EntityManager em){
		this.em=em;
	}

	//Persiste o novo usuario do facebook
	public Fitness persisteUsuario(Fitness fitness){
		em.getTransaction().begin();
		fitness = em.merge(fitness);
	    em.getTransaction().commit();
	    
	    return fitness;
	}
}
