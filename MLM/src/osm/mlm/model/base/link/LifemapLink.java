package osm.mlm.model.base.link;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Link;

public class LifemapLink extends Model{

	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public LifemapLink() throws JSONException {
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
		
//		this.setmMessage(jsonObject.getString("link"));
//		this.setmMessage(jsonObject.getString("message"));
//		this.setmThumnailImageUrl(jsonObject.getString("name"));
//		this.setmTitle(jsonObject.getString("picture"));
//		if (!(jsonObject.getString("added_text")==null)){
//			this.setmStatus(jsonObject.getString("added_text"));
//		}
	}

}
