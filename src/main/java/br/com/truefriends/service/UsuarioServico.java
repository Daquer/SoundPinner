package br.com.truefriends.service;

import javax.persistence.EntityManager;

import br.com.truefriends.modelo.Usuario;
import br.com.truefriends.persistencia.UsuarioDAO;
import br.com.truefriends.util.JPAUtil;

import com.restfb.types.User;

public class UsuarioServico {
	
private EntityManager em;	
	
public UsuarioServico(){
 this.em = new JPAUtil().getEntityManager();
}

/*
 * @Parametro:Novo Usuário do Facebook
 */
public Usuario persisteUsuarioServico(User usuarioFacebook){
	
	
	//O Usuario que será persistido
	Usuario usuario = new Usuario();
	
	//sempre necessário ter o id do usuario para persistir no SGBD
	if(usuarioFacebook.getId()!=null && !usuarioFacebook.getId().equals(""))
		usuario.setId(usuarioFacebook.getId());
	
	if(usuarioFacebook.getEmail()!=null)
		usuario.setEmail(usuarioFacebook.getEmail());

	if(usuarioFacebook.getFirstName()!=null)
		usuario.setNome(usuarioFacebook.getFirstName());
	
	if(usuarioFacebook.getBirthday()!=null)
	   usuario.setDataNascimento(usuarioFacebook.getBirthday());
	
	UsuarioDAO persiste = new UsuarioDAO(em);
    return persiste.persisteUsuario(usuario);
    
}

}
