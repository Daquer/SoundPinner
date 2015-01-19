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

@WebServlet("/RecuperaFitness")
public class RecuperaFitness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuperaFitness() {
    }

    protected void inicia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	FacebookClient facebookClient = new DefaultFacebookClient(request.getParameter("token"));
    	String categoria = (String) request.getParameter("categoria");
    	RequestDispatcher rd = request.getRequestDispatcher("/404.jsp");
    	
    	if(categoria.equals("runs")) {
    		 setRunAttributes(facebookClient, request);
    		 rd = request.getRequestDispatcher("/mostraCorridas.jsp");
    	}
    	
		rd.forward(request,response); 
    }
    
    private void setRunAttributes(FacebookClient facebookClient, HttpServletRequest request) {
		Connection<PostFitness> runsConnection = facebookClient.fetchConnection(request.getParameter("id") + "/fitness.runs", PostFitness.class, Parameter.with("limit", "1"));

		PostFitness run = runsConnection.getData().get(0);
		
		request.setAttribute("oRunString", run.toString());
		request.setAttribute("appName", run.getApplication().getName());
		request.setAttribute("attribution", run.getAttribution());
		request.setAttribute("caption", run.getCaption());
		request.setAttribute("commentsCount", run.getComments().getTotalCount().toString());
		request.setAttribute("createdTime", run.getCreatedTime());
		request.setAttribute("description", run.getDescription());
		request.setAttribute("endTime", run.getEndTime().toString());
		request.setAttribute("profileNameFrom", run.getFrom().getName());
		request.setAttribute("icon", run.getIcon());
		request.setAttribute("fbObjectId", run.getId());
		request.setAttribute("likesCount", run.getLikesCount().toString());
		request.setAttribute("link", run.getLink());
		request.setAttribute("message", run.getMessage());
		request.setAttribute("messageTags", run.getMessageTags().toString());
		request.setAttribute("metadata", run.getMetadata() == null ? "null" : run.getMetadata().toString());
		request.setAttribute("postName", run.getName());
		request.setAttribute("objectId", run.getObjectId());
		request.setAttribute("picture", run.getPicture());
		request.setAttribute("place", run.getPlace());
		request.setAttribute("privacy", run.getPrivacy());
		request.setAttribute("properties", run.getProperties().toString());
		request.setAttribute("publishTime", run.getPublishTime().toString());
		request.setAttribute("sharesCount", run.getSharesCount().toString());
		request.setAttribute("source", run.getSource());
		request.setAttribute("startTime", run.getStartTime().toString());
		request.setAttribute("statusType", run.getStatusType());
		request.setAttribute("story", run.getStory());
		request.setAttribute("to", run.getTo().toString());
		request.setAttribute("postType", run.getType());
		request.setAttribute("updatedTime", run.getUpdatedTime() == null ? "null": run.getUpdatedTime().toString());
		request.setAttribute("withTags", run.getWithTags().toString());
		request.setAttribute("noFeedStory", run.isNoFeedStory() ? "true" : "false");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}

}
