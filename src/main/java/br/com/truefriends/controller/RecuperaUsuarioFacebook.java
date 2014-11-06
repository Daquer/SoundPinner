package br.com.truefriends.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.FacebookType;
import com.restfb.types.User;


@WebServlet("/RecuperaUsuarioFacebook")
public class RecuperaUsuarioFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public RecuperaUsuarioFacebook() {
      
    }

   
  protected void inicia(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   
	   
	   FacebookClient facebookClient = new DefaultFacebookClient(request.getParameter("token"));
	   User facebookUser = facebookClient.fetchObject("me", User.class);
	   Connection<User> friendsFB = facebookClient.fetchConnection("me/friends", User.class);
	   
	   //Connection<Post> me = facebookCliente.fetchConnection("me/activities", User.class);
	   String friendsRuns = "";
	   String friendsName = "";
	   for (int i=0;i < friendsFB.getData().size(); i++) {
		  String nome = friendsFB.getData().get(i).getName();
		  String id = friendsFB.getData().get(i).getId();
		  String runsJson = "";

		  JsonObject runsConnection = facebookClient.fetchObject(id + "/fitness.runs", JsonObject.class);
		  if (runsConnection.getJsonArray("data").length() != 0 ) {
			  runsJson = runsJson + runsConnection.getJsonArray("data").getJsonObject(0).getString("start_time");
		  }

		  friendsRuns = nome + " " + id + " " + "<br />";
	   }
	   
	   String postsString = "";
	  
//		   for (int i=0;i < myPostsFB.getData().size(); i++) {
//			   NamedFacebookType appPost = myPostsFB.getData().get(i).getApplication();
//			   if(appPost != null) {
//				   postsString += appPost.getName() + " " + myPostsFB.getData().get(i).getSource() + "<br />";
//			   }
//		   }

	   
//	   Usuario usuario = new Usuario();
//	   
//	   UsuarioServico usuarioServico = new UsuarioServico();
//	   usuario = usuarioServico.persisteUsuarioServico(facebookUser);
       
	   
//	   request.setAttribute("nome_usuario", usuario.getNome());
//	   request.setAttribute("id_usuario", usuario.getId());
//	   request.setAttribute("email_usuario", usuario.getEmail());
//	   request.setAttribute("dtnasc_usuario", usuario.getDataNascimento());
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
