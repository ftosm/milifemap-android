package osm.mlm.model;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.DateField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

public class LifemapBase extends Model{

	protected CharField _ID;
	protected CharField _feedLookupType;
	protected CharField _createdAt;
	
	
	//protected ForeignKeyField<MLMActivity> _activity;

	public LifemapBase() throws JSONException{
		super();
		
		_ID= new CharField(100);
		_feedLookupType= new CharField(100);
		_createdAt= new CharField();
		
	//	_activity= new ForeignKeyField<MLMActivity>(MLMActivity.class);		
	}
	

	public void setupWithJSON(JSONObject dictionary, MLMActivity activity) throws JSONException{

		String jsonObjString= dictionary.getString("JSON_obj");
		JSONObject jsonObj= new JSONObject(jsonObjString);

		setCreatedAt(jsonObj.getString("created_at"));
		setFeedLookupType(dictionary.getString("feed_lookupType"));
		setID(dictionary.getString("id"));
		
		
		//this.setActivity(activity);
	    
	}
	public String getID() {
		return _ID.toString();
	}

	public void setID(String _mID) {
		_ID.set(_mID);
	}

	public String getFeedLookupType() {
		return _feedLookupType.toString();
	}

	public void setFeedLookupType(String feedLookupType) {
		_feedLookupType.set(feedLookupType);
	}

	public String getCreatedAt() {
		return _createdAt.toString();
	}

	public void setCreatedAt(String createdAt) {
		_createdAt.set(createdAt);
	}
	
//	public MLMActivity getActivity(Context _context) {
//		return _activity.get(_context);
//	}

//	public void setActivity(MLMActivity mActivity) {
//		_activity.set(mActivity);
//	}

	
}
