package osm.mlm.model;

import android.content.Context;

import com.orm.androrm.BooleanField;
import com.orm.androrm.CharField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;
import com.orm.androrm.OneToManyField;
import com.orm.androrm.QuerySet;

public class SocialNetwork extends Model{
	
	protected BooleanField _isActive;
	protected CharField _networkName;
	protected CharField _username;
	protected CharField _password;
	
	protected ForeignKeyField<User> _user;
	
	public SocialNetwork(){
		
		_isActive= new BooleanField();
		_networkName= new CharField();
		_username= new CharField();
		_password= new CharField();
		
		_user= new ForeignKeyField<User>(User.class);
	}

	public BooleanField getmIsActive() {
		return _isActive;
	}

	public void setmIsActive(Boolean _mIsActive) {
		_isActive.set(_mIsActive);
	}

	public String getmNetworkName() {
		return _networkName.toString();
	}

	public void setmNetworkName(String _mNetworkName) {
		_networkName.set(_mNetworkName);
	}

	public String getmUsername() {
		return _username.toString();
	}

	public void setmUsername(String _mUsername) {
		_username.set(_mUsername);
	}

	public String getmPassword() {
		return _password.toString();
	}

	public void setmPassword(String _mPassword) {
		_password.set(_mPassword);
	}
	
	public User getmUser(Context _context) {
		return _user.get(_context);
	}

	public void setmUser(User _mUser) {
		_user.set(_mUser);
	}

}
