package br.com.truefriends.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.truefriends.modelo.Usuario;
import br.com.truefriends.service.UsuarioServico;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;


@WebServlet("/RecuperaUsuarioFacebook")
public class RecuperaUsuarioFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public RecuperaUsuarioFacebook() {
      
    }

   
  protected void inicia(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   
	   
	   FacebookClient facebookCliente = new DefaultFacebookClient(request.getParameter("token"));
	   User facebookUser = facebookCliente.fetchObject("me", User.class);
	   Connection<User> friendsFB = facebookCliente.fetchConnection("me/friends", User.class);
	   Connection<Post> myPostsFB = facebookCliente.fetchConnection("me/posts", Post.class, Parameter.with("limit", "1000"));
	   //Connection<Post> me = facebookCliente.fetchConnection("me/activities", User.class);
	   
	   String friendsName = "";
/*	   for (int i=0;i < friendsFB.getData().size(); i++) {
		  String nome = friendsFB.getData().get(i).getName();
		  String id = friendsFB.getData().get(i).getId();
		  friendsName = friendsName + nome +" " + id +"<br />";
	   }*/
	   
	   String postsString = "";
	  
		   for (int i=0;i < myPostsFB.getData().size(); i++) {
			   NamedFacebookType appPost = myPostsFB.getData().get(i).getApplication();
			   if(appPost != null) {
				   postsString += appPost.getName() + " " + myPostsFB.getData().get(i).getSource() + "<br />";
			   }
		   }

	   
	   Usuario usuario = new Usuario();
	   
	   UsuarioServico usuarioServico = new UsuarioServico();
	   usuario = usuarioServico.persisteUsuarioServico(facebookUser);
       
	   
	   request.setAttribute("nome_usuario", usuario.getNome());
	   request.setAttribute("id_usuario", usuario.getId());
	   request.setAttribute("email_usuario", usuario.getEmail());
	   request.setAttribute("dtnasc_usuario", usuario.getDataNascimento());
	   request.setAttribute("friendsCount", friendsFB.getData().size());
	   request.setAttribute("friendsNames", friendsName);
	   request.setAttribute("myPosts", postsString);
	   
	   
	   RequestDispatcher rd = request.getRequestDispatcher("/results.jsp");  
	   rd.forward(request,response);  
   }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}

}
