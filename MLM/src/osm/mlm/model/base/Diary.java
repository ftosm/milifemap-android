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

public class Diary extends Model{
	
	protected CharField _title;
	protected CharField _text;
	
	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public Diary() throws JSONException{
		
		//super();
		
		_title= new CharField();
		_text= new CharField();
		
		_lifemapBase=new ForeignKeyField<LifemapBase>(LifemapBase.class);
		
	}
	public LifemapBase getLifemapBase() {
		return _lifemapBase.get();
	}
	public void setLifemapBase(LifemapBase lifemapBase) {
		_lifemapBase.set(lifemapBase);
	}
	public void setupWithJSON(JSONObject dictionary, LifemapBase lifemapBase) throws JSONException{

		JSONObject jsonObject = dictionary;

		this.setText(jsonObject.getString("text"));
		this.setTitle(jsonObject.getString("title"));
		this.setLifemapBase(lifemapBase);
	}
	
	public String getTitle() {
		return _title.toString();
	}
	public void setTitle(String title) {
		_title.set(title);
	}
	public String getText() {
		return _text.toString();
	}
	public void setText(String text) {
		_text.set(text);
	}
	
	public static final QuerySet<Diary> objects(Context context) {
	        return objects(context, Diary.class);
	}
	
	

}
