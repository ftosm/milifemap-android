package osm.mlm.lifemap;

import osm.mlm.gallery.Constants;

import com.vendevo.lifemap.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import android.widget.ImageView;

public class ShowPhotoActivity extends Activity{
	public static final String TAG = "ShowPhotoActivity";
	String sourceUrl;
	ProgressDialog pd;
	ImageView imageView;
	AsyncTask<Void, Void, Void> task;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG,TAG);
		
		// TODO Auto-generated method stub 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_photo);
		pd  = ProgressDialog.show(this, "Loading image", "Please wait...", true,true);
		Bundle extras = getIntent().getExtras();
		sourceUrl = extras.getString("imageSource");
		imageView = (ImageView)findViewById(R.id.imageView1);
		task = new AddImageTask(sourceUrl);
		task.execute();
	}
//	

	class AddImageTask extends AsyncTask<Void, Void, Void> {
		String url;
		
		Drawable d;
		public AddImageTask(String filePath) {
			url = filePath;
		}

		@Override
		protected Void doInBackground(Void... unused) {
			d = new BitmapDrawable(Constants.downloadFile(url));
			return (null);
		}
		
		@Override
		protected void onProgressUpdate(Void... unused) {

		}
		@Override
		protected void onPostExecute(Void unused) {
			
			imageView.setBackgroundDrawable(d);
			pd.dismiss();
		}
	}
}
