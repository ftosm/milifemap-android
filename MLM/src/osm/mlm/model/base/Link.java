package osm.mlm.model.base;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;
import com.orm.androrm.QuerySet;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;

public class Link extends Model{
	
	protected CharField _message;
	protected CharField _originalUrl;
	protected CharField _status;
	protected CharField _thumnailImageUrl;
	protected CharField _title;
	protected CharField _linkType;

	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public Link() throws JSONException{
		super();
		
		_message= new CharField();
		_originalUrl= new CharField();
		_status= new CharField();
		_thumnailImageUrl= new CharField();
		_title= new CharField();
		_linkType= new CharField();
		
		_lifemapBase= new ForeignKeyField<LifemapBase>(LifemapBase.class);
	}
	
	public void setupWithJSON(JSONObject dictionary, LifemapBase lifemapBase, String linkType) throws JSONException{
		
		String jsonObjString= dictionary.getString("JSON_obj");
		JSONObject jsonObj= new JSONObject(jsonObjString);
		
		setMessage(jsonObj.getString("link"));
		setOriginalUrl(jsonObj.getString("story"));
		setThumnailImageUrl(jsonObj.getString("name"));
		setTitle(jsonObj.getString("picture"));
		
		if (!(jsonObj.getString("added_text")==null)){
			setStatus(jsonObj.getString("added_text"));
		}
		
		setType(linkType);
		setLifemapBase(lifemapBase);
	}
	
	public LifemapBase getLifemapBase() {
		return _lifemapBase.get();
	}
	public void setLifemapBase(LifemapBase lifemapBase) {
		_lifemapBase.set(lifemapBase);
	}
	
	public String getMessage() {
		return _message.toString();
	}
	public void setMessage(String message) {
		_message.set(message);
	}
	public String getOriginalUrl() {
		return _originalUrl.toString();
	}
	public void setOriginalUrl(String originalUrl) {
		_originalUrl.set(originalUrl);
	}
	public String getStatus() {
		return _status.toString();
	}
	public void setStatus(String status) {
		_status.set(status);
	}
	public String getThumnailImageUrl() {
		return _thumnailImageUrl.toString();
	}
	public void setThumnailImageUrl(String thumnailImageUrl) {
		_thumnailImageUrl.set(thumnailImageUrl);
	}
	public String getTitle() {
		return _title.toString();
	}
	public void setTitle(String title) {
		_title.set(title);
	}
	
	public String getType() {
		return _linkType.toString();
	}
	public void setType(String linkType) {
		_linkType.set(linkType);
	}
	
	public static final QuerySet<Link> objects(Context context) {
	        return objects(context, Link.class);
	    }
	
	

}
