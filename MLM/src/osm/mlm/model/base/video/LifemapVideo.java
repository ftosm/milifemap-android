package osm.mlm.model.base.video;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Video;

public class LifemapVideo extends Video{

	public LifemapVideo() throws JSONException {
		super();
		
	}
	
	public void setupWithJSON(JSONObject dictionary, MLMActivity activity) throws JSONException{

		JSONObject jsonObject= dictionary.getJSONObject("JSON_obj");

		this.setText(jsonObject.getString("text"));
		this.setThumbnailUrl(jsonObject.getString("screenshot"));
		this.setOriginalUrl(jsonObject.getString("filename"));
	    
	}

}
