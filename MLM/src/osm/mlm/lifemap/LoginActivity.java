package osm.mlm.lifemap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.orm.androrm.DatabaseAdapter;
import com.orm.androrm.Model;
import com.vendevo.lifemap.R;

import osm.mlm.model.Constants;
import osm.mlm.model.LifemapBase;
import osm.mlm.model.LifemapBaseContainer;
import osm.mlm.model.MLMActivity;
import osm.mlm.model.MLMManager;
import osm.mlm.model.SocialNetwork;
import osm.mlm.model.User;
import osm.mlm.model.base.Diary;
import osm.mlm.model.base.FoursqureCheckIn;
import osm.mlm.model.base.Link;
import osm.mlm.model.base.Photo;
import osm.mlm.model.base.Status;
import osm.mlm.model.base.Video;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.requests.LogInRequest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements Callback.LoginWithEmailCallback{

	private String loginName;
	private String password;
	EditText loginEditText;
	EditText passwordEditText;
	LogInRequest.LoginWithEmail request;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		loginEditText = (EditText) findViewById(R.id.loginEditText) ;
		passwordEditText = (EditText) findViewById(R.id.passwordEditText) ;
		
		osm.mlm.model.MLMFactory.setContext(this);
		request = new LogInRequest().new LoginWithEmail();
		request.setCaller(this);
		registerLoginButton();
		registerAboutButton();
		setupDB();
	}

	
	private void registerLoginButton(){
		Button loginButton = (Button) findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				loginName = loginEditText.getText().toString();
				Log.v("LOGIN NAME PASSED : ",loginName);
				password= passwordEditText.getText().toString();
				Log.v("PASSWORD PASSED : ",password);
				try {
					request.makeRequest(loginName, password);
					
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(isValid()){
					Intent i = new Intent(LoginActivity.this, MiLifeMapActivity.class);
					
					startActivity(i);
				}
				else{
					
				}
				
			}
		});
		
	}
	
	private boolean isValid(){
		
		// VERIFY loginName and password here... and start appropriate activity, based on the outcome !
		
		
		return true;
	}
	
	private void registerAboutButton(){
		Button aboutButton = (Button) findViewById(R.id.aboutButton);
		aboutButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LoginActivity.this, AboutActivity.class);
				startActivity(i);
			}
		});
		
	}


	public void logInSuccessfulWithAccessToken(String token) {
		// TODO Auto-generated method stub
		Log.v("LOGIN SUCCESSFUL - token: ",token);
		Constants.USER_TOKEN=token;
	
	}


	public void logInFailedWithErrorMessage(String message) {
		// TODO Auto-generated method stub
		Log.v("LOGIN FAILED : ",message);
	}
	
	  public void setupDB(){
//	    	 
	    	 List<Class<? extends Model>> models = new ArrayList<Class<? extends Model>>();
	         
	    	 models.add(LifemapBase.class);
	         models.add(LifemapBaseContainer.class);
	         models.add(MLMActivity.class);
	         models.add(MLMManager.class);
	         models.add(SocialNetwork.class);
	         models.add(User.class);
	         
	         models.add(Photo.class);
	     //    models.add(FacebookPhoto.class);
	       //  models.add(FlickerPhoto.class);
	         //models.add(LifemapPhoto.class);
	         
	         models.add(Link.class);
	         //models.add(FacebookLink.class);
	         //models.add(LifemapLink.class);
	         
	         models.add(Diary.class);
	         models.add(FoursqureCheckIn.class);
	         
	         models.add(Status.class);
	         //models.add(LifemapStatus.class);
	         //models.add(TwitterStatus.class);
	         //models.add(FacebookStatus.class);
	         
	         models.add(Video.class);
	         //models.add(YoutubeVideo.class);
	         //models.add(FacebookVideo.class);
	         //models.add(FlickerVideo.class);
	         //models.add(LifemapVideo.class);
	         
	         
	         
	         
	         DatabaseAdapter.setDatabaseName("mlm_db");
	         DatabaseAdapter adapter = new DatabaseAdapter(getApplicationContext());
	         adapter.setModels(models);
	    }

}
