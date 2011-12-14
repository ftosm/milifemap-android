package osm.mlm.model;

import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;
import com.orm.androrm.OneToManyField;
import com.orm.androrm.QuerySet;

public class User extends Model{
	
	protected CharField _accessToken;
	protected CharField _firstName;
	protected CharField _lastName;
	protected CharField _email;
	protected CharField _profileImageUrl;
	protected CharField _profileImageThumbUrl;
	
	protected ForeignKeyField<MLMManager> _mLMManager;
	protected OneToManyField<User,SocialNetwork> _socialNetworks;
	
	public User(){
		
		_accessToken= new CharField();
		_firstName= new CharField();
		_lastName= new CharField();
		_email= new CharField();
		_profileImageUrl= new CharField();
		_profileImageThumbUrl= new CharField();
		
		_mLMManager= new ForeignKeyField<MLMManager>(MLMManager.class);
		_socialNetworks= new OneToManyField<User,SocialNetwork>(User.class,SocialNetwork.class);
		
	}
	
	
	public String getAccessToken() {
		return _accessToken.toString();
	}
	public void setAccessToken(String _mAccessToken) {
		_accessToken.set(_mAccessToken);
	}
	public String getFirstName() {
		return _firstName.toString();
	}
	public void setFirstName(String _mFirstName) {
		_firstName.set(_mFirstName);
	}
	public String getLastName() {
		return _lastName.toString();
	}
	public void setLastName(String _mLastName) {
		_lastName.set(_mLastName);
	}
	public String getEmail() {
		return _email.toString();
	}
	public void setEmail(String _mEmail) {
		_email.set(_mEmail);
	}
	public String getProfileImageUrl() {
		return _profileImageUrl.toString();
	}
	public void setProfileImageUrl(String _mProfileImageUrl) {
		_profileImageUrl.set(_mProfileImageUrl);
	}
	public String getProfileImageThumbUrl() {
		return _profileImageThumbUrl.toString();
	}
	public void setProfileImageThumbUrl(String _mProfileImageThumbUrl) {
		_profileImageThumbUrl.set(_mProfileImageThumbUrl);
	}
	
	public QuerySet<SocialNetwork> getSocialNetwork(Context _context) {
		return _socialNetworks.get(_context, this);
	}

	public void setSocialNetwork(SocialNetwork _mSocialNetwork) {
		_socialNetworks.add(_mSocialNetwork);
	}

	public MLMManager getMLMManager(Context _context) {
		return _mLMManager.get(_context);
	}

	public void setMLMManager(MLMManager _mMLMManager) {
		_mLMManager.set(_mMLMManager);
	}


}
