package osm.mlm.model.base.video;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Video;

public class FacebookVideo extends Model{

	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public FacebookVideo() throws JSONException {
		super();
		
		_lifemapBase= new ForeignKeyField<LifemapBase>(LifemapBase.class);
	}
	
	public LifemapBase getLifemapBase() {
		return _lifemapBase.get();
	}
	public void setLifemapBase(LifemapBase lifemapBase) {
		_lifemapBase.set(lifemapBase);
	}
	
	public void setupWithJSON(JSONObject dictionary, MLMActivity activity) throws JSONException{

		JSONObject jsonObject = dictionary.getJSONObject("JSON_obj");
//
//		this.setmVideoID(jsonObject.getString("object_id"));
//		this.setmOrignialUrl(jsonObject.getString("link"));
//		this.setmText(jsonObject.getString("message"));
//		this.setmThumbnailUrl(jsonObject.getString("picture"));
//		if (!(jsonObject.getString("added_text")==null)){
//			this.setmText(jsonObject.getString("added_text"));
//		}
//		
//		//Construct the embebded html
//	    updateWithVideoUrl(this.getmOrignialUrl());
	    
	}
	
	public void updateWithVideoUrl(String videoUrl){
		
		String path = videoUrl;
		String htmlString = "<html><head> <meta name = \"viewport\" content = \"initial-scale = 1.0, user-scalable = no, width = 212\"/></head> <body style=\"background:#F00;margin-top:0px;margin-left:0px\"> <div><object width=\"320\" height=\"420\"> <param name=\"movie\" value=\"%@\"></param> <param name=\"wmode\" value=\"transparent\"></param> <embed src=\"%@\" type=\"application/x-shockwave-flash\" wmode=\"transparent\" width=\"320\" height=\"420\"></embed> </object></div></body></html>";
		//this.setmEmbeddedHtml(String.format(htmlString, path, path));  // check this line of code for string format
		// above line of code will depend on the response of HTML
	}

}
