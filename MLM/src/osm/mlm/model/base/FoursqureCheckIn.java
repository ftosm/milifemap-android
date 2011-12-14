package osm.mlm.model.base;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;
import android.content.Context;
import android.location.Location;

import com.orm.androrm.CharField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.LocationField;
import com.orm.androrm.Model;
import com.orm.androrm.QuerySet;

public class FoursqureCheckIn extends Model{
	
	protected LocationField _longitude;
	protected LocationField _latitude;
	protected CharField _shortName;

	protected ForeignKeyField<LifemapBase> _lifemapBase;
	
	public FoursqureCheckIn() throws JSONException{
		super();
		
		_latitude= new LocationField();
		_longitude= new LocationField();
		_shortName= new CharField(100);
		
		_lifemapBase= new ForeignKeyField<LifemapBase>(LifemapBase.class);
	}
	
	public void setupWithJSON(JSONObject dictionary, MLMActivity activity) throws JSONException{

		JSONObject jsonObject = dictionary;

//		this.setText(jsonObject.getString("text"));
//		this.setTitle(jsonObject.getString("title"));
//		this.setLifemapBase(lifemapBase);
	}
	
	public LifemapBase getLifemapBase() {
		return _lifemapBase.get();
	}
	public void setLifemapBase(LifemapBase lifemapBase) {
		_lifemapBase.set(lifemapBase);
	}
	
	public Location getmLongitude() {
		return _longitude.get();
	}
	public void setmLongitude(Location longitude) {
		_longitude.set(longitude);
	}
	public Location getmLatitude() {
		return _latitude.get();
	}
	public void setmLatitude(Location _latitude) {
		_latitude.set(_latitude);
	}
	public String getmShortName() {
		return _shortName.toString();
	}
	public void setmShortName(String _mShortName) {
		_shortName.set(_mShortName);
	}
	
	public static final QuerySet<FoursqureCheckIn> objects(Context context) {
	        return objects(context,FoursqureCheckIn.class);
	    }

}
