package osm.mlm.model.base.status;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Status;

public class FacebookStatus extends Model{

	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public FacebookStatus() throws JSONException {
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

		//this.setText(jsonObj.getJSONObject("text").toString());
	//	this.setText(jsonObject.getString("text"));
	}

}
