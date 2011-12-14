package osm.mlm.model;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.DateField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

public class MLMActivity extends Model{
	
	protected CharField _createdAt;
	protected CharField _timeline;
	protected CharField _ID;
	
	protected ForeignKeyField<LifemapBase> _data;
	
	public MLMActivity() throws JSONException{
		super();
		
		_createdAt= new CharField();
		_timeline= new CharField();
		_ID= new CharField();
		
		_data= new ForeignKeyField<LifemapBase>(LifemapBase.class);
		
		
	}


	public LifemapBase setupWithDictionary(JSONObject dictionary) throws JSONException{
		
		
		String jsonObjString= dictionary.getString("JSON_obj");
		JSONObject jsonObj= new JSONObject(jsonObjString);
		
		setID(dictionary.getString("id"));
		setTimeline(dictionary.getString("timeline"));
		setCreatedAt(jsonObj.getString("created_at"));
		
		//setData(lifemapBase);
		
		return MLMFactory.createDataOfType(dictionary.getString(Constants.kFeedTypeKey),dictionary, this);
	}
	
	public String getCreatedAt() {
		return _createdAt.toString();
	}


	public void setCreatedAt(String _mCreatedAt) {
		_createdAt.set(_mCreatedAt);
	}


	public String getTimeline() {
		return _timeline.toString();
	}


	public void setTimeline(String _mTimeline) {
		_timeline.set(_mTimeline);
	}


	public String getID() {
		return _ID.get();
	}


	public void setID(String _mID) {
		_ID.set(_mID);
	}


	public LifemapBase getData(Context _context) {
		return _data.get(_context);
	}


	public void setData(LifemapBase _mLifemapBase) {
		_data.set(_mLifemapBase);
	}
	

}
