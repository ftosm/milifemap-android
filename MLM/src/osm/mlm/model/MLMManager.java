package osm.mlm.model;

import java.lang.reflect.Array;
import java.util.Arrays;

import android.content.Context;

import com.orm.androrm.BooleanField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;

public class MLMManager extends Model{
	
	protected BooleanField _firstRun;
	
	protected ForeignKeyField<User> _currentUser;
	
	static MLMManager sharedInstance;
	
	public MLMManager(){
		
		_firstRun= new BooleanField();
		
		_currentUser= new ForeignKeyField<User>(User.class);
	}


	public Boolean getFirstRun() {
		return _firstRun.get();
	}

	public void setFirstRun(Boolean _mFirstRun) {
		_firstRun.set(_mFirstRun);
	}
	
	public User getUser(Context _context) {
		return _currentUser.get(_context);
	}

	public void setUser(User _mUser) {
		_currentUser.set(_mUser);
	}
	
	public static Context getContext(){
		return null;
		// to be implemented
	}
	
	public static MLMManager sharedManager(){
		// to be implemented
		return sharedInstance;
	}
	
	public void loadModel(){
		// to be implemented
	}

	public static MLMManager createManager(){
		// to be implemented
		MLMManager manager=null;
		return manager;
	}
	
	public void saveModel(){
		// to be implemented
	}
	
	public static Arrays filterActiviesOfKinds(Arrays feedTypes, Arrays activities){
		Arrays filtered=null;
		// to be implemented
		return filtered;
	}
	

}
