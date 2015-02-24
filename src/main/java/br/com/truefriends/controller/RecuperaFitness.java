package br.com.truefriends.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import br.com.truefriends.modelo.PostFitness;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;

@WebServlet("/RecuperaFitness")
public class RecuperaFitness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuperaFitness() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inicia(request, response);
	}
	
    protected void inicia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	FacebookClient facebookClient = new DefaultFacebookClient(request.getParameter("token"));
    	String categoria = (String) request.getParameter("categoria");
//    	String extractMode = (String) request.getParameter("extract");
    	
    	String idRun = (String) request.getParameter("idRun");
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/404.jsp");
//    	if(extractMode.equals("graphapi")) {
    	if(idRun != null && !idRun.equals("")) {
    		getSingleRun(request, facebookClient, idRun);
    		rd = request.getRequestDispatcher("/mostraCorridas.jsp");
    	}
    	
		if(categoria != null && categoria.equals("runs")) {
//    			setRunAttributesGraphApi(facebookClient, request);
			setRuns(facebookClient, request);
			rd = request.getRequestDispatcher("/mostraCorridas.jsp");
		}
//    	}
//    	else if(extractMode.equals("jsoup")) {
//    		setRunAttributesJsoup(facebookClient, request);
//    		rd = request.getRequestDispatcher("/nikeRuns.jsp");
//    	}
		request.setAttribute("token", request.getParameter("token"));
		rd.forward(request,response); 
    }
    


	private void getSingleRun(HttpServletRequest request, FacebookClient facebookClient, String idRun) {
		PostFitness run = facebookClient.fetchObject(idRun, PostFitness.class);
		
		setRunAttributesGraphApi(request, run);
	}


	private void setRuns(FacebookClient facebookClient,
			HttpServletRequest request) {
		Connection<PostFitness> runsConnection = facebookClient.fetchConnection(request.getParameter("id") + "/fitness.runs", PostFitness.class, Parameter.with("limit", "5"));
		List<PostFitness> postsFit = new ArrayList<PostFitness>();
		
		for(PostFitness postFit : runsConnection.getData()) {
			postsFit.add(postFit);
		}
		
		request.setAttribute("runs", postsFit);
	}

	private void setRunAttributesJsoup(FacebookClient facebookClient, HttpServletRequest request) {
		// TODO Auto-generated method stub
    	Connection<PostFitness> runsConnection = facebookClient.fetchConnection(request.getParameter("id") + "/fitness.runs", PostFitness.class, Parameter.with("limit", "5"));
    	PostFitness run = runsConnection.getData().get(0);
    	
    	String appName = run.getApplication().getName();
    	String courseUrl = run.getDataCourse().getCourse().getUrl();
    	
//    	Document doc = Jsoup.connect("https://www.runtastic.com/en/users/jr-cefet/sport-sessions/355090258").get();
    	
    	try {
			Document doc = Jsoup.connect(courseUrl).get();
			
			
			if(appName.equals("Nike")) {
//				String nikeFuel = doc.select(".stat-heading.wide.fuel.first span").text() + " " + doc.select(".stat-heading.wide.fuel.first div").text();
//				String totalDistance = doc.select(".stat-heading.wide.distance span").first().text() + " " + doc.select(".stat-heading.wide.distance span span").text();
//				String totalTime = doc.select(".stat-heading.wide.time span").text();
//				String avgPace = doc.select(".stat-heading.wide.pace span").first().text();
//				
//				request.setAttribute("nikeFuel", nikeFuel);
//				request.setAttribute("totalDistance", totalDistance);
//				request.setAttribute("totalTime", totalTime);
//				request.setAttribute("avgPace", avgPace);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}


	private void setRunAttributesGraphApi(HttpServletRequest request, PostFitness run) {
		
		request.setAttribute("oRunString", run.toString());
		request.setAttribute("courseUrl", run.getDataCourse().getCourse().getUrl());
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


}
