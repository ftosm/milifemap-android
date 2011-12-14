package osm.mlm.model.base.video;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Video;

public class FlickerVideo extends Video{

	public FlickerVideo() throws JSONException {
		super();
		
	}
	
	public void setupWithJSON(JSONObject dictionary, MLMActivity activity) throws JSONException{

		JSONObject jsonObject = dictionary.getJSONObject("JSON_obj");
		
		JSONArray jsonArray = jsonObject.getJSONObject("source_url").getJSONObject("sizes")
							.getJSONArray("size");
		
		this.setThumbnailUrl(jsonArray.getJSONObject(1).getString("source"));
		this.setOriginalUrl(jsonArray.getJSONObject((jsonArray.length())-1).getString("source"));
	
	}


}
