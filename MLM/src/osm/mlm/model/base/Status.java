package osm.mlm.model.base;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;

import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;
import com.orm.androrm.QuerySet;

public class Status extends Model{
	
	protected CharField _text;
	protected CharField _statusType;
	
	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public Status() throws JSONException{
		super();
		
		_text= new CharField();
		_statusType= new CharField();
		
		_lifemapBase= new ForeignKeyField<LifemapBase>(LifemapBase.class);
	}
	
	public void setupWithJSON(JSONObject dictionary, LifemapBase lifemapBase, String statusType) throws JSONException{

		String jsonObjString = dictionary.getString("JSON_obj");
		JSONObject jsonObj = new JSONObject(jsonObjString);

		setText(jsonObj.getString("text"));
		setType(statusType);
		setLifemapBase(lifemapBase);
		
	}

	public LifemapBase getLifemapBase() {
		return _lifemapBase.get();
	}
	public void setLifemapBase(LifemapBase lifemapBase) {
		_lifemapBase.set(lifemapBase);
	}
	
	public String getText() {
		return _text.toString();
	}

	public void setText(String text) {
		_text.set(text);
	}
	
	public String getType() {
		return _statusType.toString();
	}

	public void setType(String statusType) {
		_statusType.set(statusType);
	}
	
	public static final QuerySet<Status> objects(Context context) {
	        return objects(context, Status.class);
	    }


}
