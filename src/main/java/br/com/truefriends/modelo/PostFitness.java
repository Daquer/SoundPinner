package br.com.truefriends.modelo;

import static com.restfb.util.DateUtils.toDateFromLongFormat;

import java.io.Serializable;
import java.util.Date;

import com.restfb.Facebook;
import com.restfb.types.Post;

//https://developers.facebook.com/docs/reference/opengraph/action-type/fitness.runs
public class PostFitness extends Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//verificar a necessidade de campo place
	
	
	@Facebook("start_time")
	private String startTime;
	 
	@Facebook("end_time")
	private String endTime;
	
	@Facebook("publish_time")
	private String publishTime;
	
	@Facebook
	private String message;
	
	@Facebook("no_feed_story")
	private boolean noFeedStory;
	
	public Date getStartTime() {
		return toDateFromLongFormat(startTime);
	}
	
	public Date getEndTime() {
		return toDateFromLongFormat(endTime);
	}
	
	public Date getPublishTime() {
		return toDateFromLongFormat(publishTime);
	}
	
	public String getMessage() {
		return message;
	}

	public boolean isNoFeedStory() {
		return noFeedStory;
	}
}