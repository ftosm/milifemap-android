package osm.mlm.lifemap;

import com.vendevo.lifemap.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
        registerActivityButton();
        registerPhotosButton();
        registerVideosButton();
	}

private void registerActivityButton(){
    	
    	Button activityButton = (Button) findViewById(R.id.activityButton);
    	activityButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				
			}
		});
    	
    }
    
    private void registerPhotosButton(){
    	Button activityButton = (Button) findViewById(R.id.photosButton);
    	activityButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				Intent i = new Intent(WelcomeActivity.this, PhotosActivity.class);
				i.putExtra("objectType", "photo");
				startActivity(i);
				
				// TODO Auto-generated method stub
				
			}
		});
    	
    }
    
    private void registerVideosButton(){
    	Button activityButton = (Button) findViewById(R.id.videosButton);
    	activityButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
//				Intent i = new Intent(WelcomeActivity.this, PhotosActivity.class);
				Intent i = new Intent(WelcomeActivity.this, PlayVideoActivity.class);
				i.putExtra("objectType", "video");
				startActivity(i);
				
			}
		});
    	
    }
	    

}


