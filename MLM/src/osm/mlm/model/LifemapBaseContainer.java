package osm.mlm.model;

import java.lang.reflect.Array;
import java.util.HashMap;

import android.R.string;
import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.DateField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;
import com.orm.androrm.OneToManyField;
import com.orm.androrm.QuerySet;

public class LifemapBaseContainer extends Model{
	
	protected DateField _timeline;
	protected CharField _title;
	
	protected OneToManyField<LifemapBaseContainer,MLMActivity> _item;
	protected ForeignKeyField<LifemapBase> _cover;
	
	public LifemapBaseContainer(){
		super();
		_timeline= new DateField();
		_title= new CharField();//Field length?
		
		_item= new OneToManyField<LifemapBaseContainer, MLMActivity>(LifemapBaseContainer.class, MLMActivity.class);
		_cover= new ForeignKeyField<LifemapBase>(LifemapBase.class);
	}
	
	public void setTitle(String title){
		_title.set(title);
	}
	
	public void setTimeline(String timeline){
		_timeline.fromString(timeline);
	}
	
	public String getTitle(){
		return _title.get();
	}
	
	public String getTimeline(){
		return _timeline.getDateString();
	}
	
	public LifemapBase getCover(Context _context) {
		return _cover.get(_context);
	}

	public void setCover(LifemapBase _lifemapBase) {
		_cover.set(_lifemapBase);
	}

	public QuerySet<MLMActivity> getItem(Context _context) {
		return _item.get(_context, this);
	}

	public void setItem(MLMActivity _activity) {
		_item.add(_activity);
	}
	
	public void removeItem(MLMActivity _activity){
		// to be implemented
	}
	
	public String allKeys(){
		String keys = null;
		// to be implemented
		return keys;
	}
	
	public String allValues(){
		String values = null;
		// to be implemented
		return values;
	}
	
	public Array sortedItems(){
		Array items = null;
		// to be implemented
		return items;
	}
	
	public Array allPhotos(){
		Array photos = null;
		// to be implemented
		return photos;
	}
	
	public Array allVideos(){
		Array videos = null;
		// to be implemented
		return videos;
	}
	
	public Array allFiles(){
		Array files = null;
		// to be implemented
		return files;
	}
	
	public HashMap<String, String> keyValuePairs(){
		HashMap<String, String> aDictionary = null;
		// to be implemented
		return aDictionary;
	}
	
	public Array sectionHeaders(){
		Array return1 = null;
		// to be implemented
		return return1;
	}
	
	public void updateDetailsWithItems(Array items){
		
		// to be implemented
		
	}
	
	public Object compareUsingTimeLine(LifemapBaseContainer obj){
		// to be implemented
		return obj;
	}

}
