package br.com.truefriends.persistencia;

import javax.persistence.EntityManager;

import br.com.truefriends.modelo.Usuario;


public class UsuarioDAO {

private final EntityManager em;

public UsuarioDAO(EntityManager em){
	this.em=em;
}

//Persiste o novo usuario do facebook
public Usuario persisteUsuario(Usuario usuario){
	em.getTransaction().begin();
	usuario = em.merge(usuario);
    em.getTransaction().commit();
    
    return usuario;
}


}
