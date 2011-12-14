//package osm.mlm.lifemap;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.vendevo.lifemap.R;
//
//import osm.mlm.gallery.Photo;
//import osm.mlm.gallery.Video;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.GridView;
//import android.widget.Toast;
//import android.widget.AdapterView.OnItemClickListener;
//
//
//public class VideosActivity extends Activity{
//	private static final String TAG = "PhotosActivity";
//	private List <Video> videosList;
//	private ArrayList<String> videoThumbList; 
//	Bitmap bmImg;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.photos);
//		
//		videosList = new ArrayList<Video>(); // this would be equal to the photos passed here...
//		videoThumbList = new ArrayList<String>();
//		//populate photos List
//		Video v1 = new Video("http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png","http://www.funphotoart.com/wp-content/uploads/2008/01/photoshop-website-home-button-icon26.gif");
//		Video v2 = new Video("http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png","http://www.funphotoart.com/wp-content/uploads/2008/01/photoshop-website-home-button-icon26.gif");
//		Video v3 = new Video("http://www.funphotoart.com/wp-content/uploads/2008/01/photoshop-website-home-button-icon26.gif","http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png");
//		videosList.add(v1);
//		videosList.add(v2);
//		videosList.add(v3);
//		
//		
//		for (Video video : videosList) {
//			videoThumbList.add(video.getThumbnailURL());
//		}
//		
//		String[] videosArray = videoThumbList.toArray(new String[videoThumbList.size()]);
//
//		
//		GridView gridView = (GridView) findViewById(R.id.photosGridView);
////		
////		gridView.setAdapter(new ImageAdapter(this,videosArray));
//		gridView.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(VideosActivity.this, "" + position + videosList.get(position).getSourceURL(), Toast.LENGTH_SHORT).show();
//                
//                Intent i = new Intent(VideosActivity.this, ShowPhotoActivity.class);
//                i.putExtra("imageSource",videosList.get(position).getSourceURL());
////                Log.v(TAG,"STARTING ANOTHER ACTIVITY !!!!");
//                startActivity(i);
//            }
//        });
//	}
//}
