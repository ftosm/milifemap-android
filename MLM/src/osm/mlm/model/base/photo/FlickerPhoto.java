package osm.mlm.model.base.photo;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Photo;

public class FlickerPhoto extends Model{

	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public FlickerPhoto() throws JSONException {
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

//		JSONObject jsonObject= dictionary.get("JSON_obj");
//		
//		JSONArray jsonArray = jsonObject.getJSONObject("source_url").getJSONObject("sizes")
//							.getJSONArray("size");
		
//		this.setmThumbnailUrl(jsonArray.getJSONObject(1).getString("source"));
//		this.setmOriginalUrl(jsonArray.getJSONObject((jsonArray.length())-1).getString("source"));
		
	}

}
