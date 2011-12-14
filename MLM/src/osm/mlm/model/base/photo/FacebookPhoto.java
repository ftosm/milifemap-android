package osm.mlm.model.base.photo;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Photo;

public class FacebookPhoto extends Model{

	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public FacebookPhoto() throws JSONException {
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

		//JSONObject jsonObject = dictionary.get("JSON_obj");
		
//		//this.setmOriginalUrl(jObj.getJSONObject("source").toString());
//		this.setmOriginalUrl(jsonObject.getString("source")); 
//		this.setmThumbnailUrl(jsonObject.getJSONObject("source").toString()); /*need thumbnail URL here*/

	}

}
