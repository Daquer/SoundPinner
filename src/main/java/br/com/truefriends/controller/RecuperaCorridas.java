package br.com.truefriends.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.truefriends.modelo.PostFitness;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Application;

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
    	String fase = (String) request.getParameter("fase");
    	
    	if(fase.equals("inicio")) {
    		PostFitness runs = inicia(facebookClient, request);
    		request.setAttribute("run", runs);
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/mostraCorridas.jsp");
		rd.forward(request,response); 
    }
    
	private PostFitness inicia(FacebookClient facebookClient, HttpServletRequest request) {
		Connection<PostFitness> runsConnection = facebookClient.fetchConnection(request.getParameter("id") + "/fitness.runs", PostFitness.class, Parameter.with("limit", "1"));
		return new PostFitness();
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
