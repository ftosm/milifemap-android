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

public class Photo extends Model{
	
	protected CharField _originalUrl;
	protected CharField _thumbnailUrl;
	protected CharField _text;
	protected CharField _photoType;
	
	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public Photo() throws JSONException{
		super();
		
		_originalUrl= new CharField();
		_thumbnailUrl= new CharField();
		_text= new CharField();
		_photoType= new CharField();
		
		_lifemapBase= new ForeignKeyField<LifemapBase>(LifemapBase.class);

	}
	
	public void setupWithJSON(JSONObject dictionary, LifemapBase lifemapBase, String photoType) throws JSONException{
		
		String jsonObjString= dictionary.getString("JSON_obj");
		JSONObject jsonObj= new JSONObject(jsonObjString);
		
		setText(jsonObj.getString("text"));
		setOriginalUrl(jsonObj.getString("image_large")); 
		setThumbnailUrl(jsonObj.getString("image_thumb")); /*need thumbnail URL here*/
		setType(photoType);
		setLifemapBase(lifemapBase);
	}
		
	
	public LifemapBase getLifemapBase() {
		return _lifemapBase.get();
	}
	public void setLifemapBase(LifemapBase lifemapBase) {
		_lifemapBase.set(lifemapBase);
	}
	
	public String getOriginalUrl() {
		return _originalUrl.toString();
	}
	public void setOriginalUrl(String originalUrl) {
		_originalUrl.set(originalUrl);
	}
	public String getThumbnailUrl() {
		return _thumbnailUrl.toString();
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		_thumbnailUrl.set(thumbnailUrl);
	}
	public String getText() {
		return _text.toString();
	}
	public void setText(String text) {
		_text.set(text);
	}
	
	public String getType() {
		return _photoType.toString();
	}
	public void setType(String photoType) {
		_photoType.set(photoType);
	}
	
	public static final QuerySet<Photo> objects(Context context) {
	        return objects(context, Photo.class);
	    }

}
