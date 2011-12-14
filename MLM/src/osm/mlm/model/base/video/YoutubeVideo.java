package osm.mlm.model.base.video;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Video;

public class YoutubeVideo extends Video{

	public YoutubeVideo() throws JSONException {
		super();
		
	}
	
	public void setupWithJSON(JSONObject dictionary, MLMActivity activity) throws JSONException{

		JSONObject jsonObject = dictionary.getJSONObject("JSON_obj");

		
		this.setOriginalUrl(jsonObject.getString("source"));
		this.setText(jsonObject.getString("story"));
		this.setThumbnailUrl(jsonObject.getString("picture"));
		if (!(jsonObject.getString("added_text")==null)){
			this.setText(jsonObject.getString("added_text"));
		}
		
		String htmlString = "<html><head> <meta name = \"viewport\" content = \"initial-scale = 1.0, user-scalable = no, width = 212\"/></head> <body style=\"background:#F00;margin-top:0px;margin-left:0px\"> <div><object width=\"320\" height=\"420\"> <param name=\"movie\" value=\"%@\"></param> <param name=\"wmode\" value=\"transparent\"></param> <embed src=\"%@\" type=\"application/x-shockwave-flash\" wmode=\"transparent\" width=\"320\" height=\"420\"></embed> </object></div></body></html>";
		this.setEmbeddedHtml(String.format(htmlString, this.getOriginalUrl(), this.getOriginalUrl()));  // check this line of code for string format
		// above line of code will depend on the response of HTML
	    
	}

}
