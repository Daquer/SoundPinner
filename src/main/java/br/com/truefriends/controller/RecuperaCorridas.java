package br.com.truefriends.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.truefriends.modelo.Runs;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;

/**
 * Servlet implementation class RecuperaCorridas
 */
@WebServlet("/RecuperaCorridas")
public class RecuperaCorridas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperaCorridas() {
    }

    protected void inicia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	  FacebookClient facebookClient = new DefaultFacebookClient(request.getParameter("token"));
 	  Connection<Runs> runsConnection = facebookClient.fetchConnection(request.getParameter("id") + "/fitness.runs", Runs.class, Parameter.with("limit", "999"));
 	  
 	  Runs runs = new Runs();
 	  request.setAttribute("runs", runs);
 	 
 	  RequestDispatcher rd = request.getRequestDispatcher("/mostraCorridas.jsp");  
 	  rd.forward(request,response); 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}

}
