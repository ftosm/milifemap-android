package osm.mlm.lifemap;
 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.orm.androrm.Model;
import com.orm.androrm.QuerySet;
import com.vendevo.lifemap.R;
import osm.mlm.gallery.Constants;import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;
import osm.mlm.model.base.Photo;
import osm.mlm.model.base.Video;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.requests.ActivitiesRequest;
import osm.mlm.webservice.requests.LogInRequest;
import osm.mlm.webservice.requests.LogInRequest.LoginWithEmail;
import osm.mlm.webservice.requests.PhotoRequest;


public class PhotosActivity extends Activity implements Callback.GetLifeMapPhotosWithStartDateCallBack{
	private static final String TAG = "PhotosActivity";
	private List <Model> photosList;
	private ArrayList<String> galleryThumbURIList; 
	Bitmap bmImg;
	GridView gridView;
	ImageAdapter imageAdapter;
	public ArrayList<View> bitmapsArray;
	private boolean isPhotoObject;
	public boolean doneShowingProgress = false;
	public String objectType;
	PhotoRequest.GetMilifemapPhotosWithStartDate request;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photos);
		Bundle extras = getIntent().getExtras();
		objectType = extras.getString("objectType");
		if(objectType.equals("photo")){
			isPhotoObject = true;
		}
		else if(objectType.equals("video")){
			isPhotoObject = false;
		}
		photosList = new ArrayList<Model>(); // this would be equal to the photos passed here...
		galleryThumbURIList = new ArrayList<String>();
		photosList = new ArrayList<Model>();	
		gridView = (GridView) findViewById(R.id.photosGridView);
		imageAdapter = new ImageAdapter(this);

		gridView.setAdapter(imageAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	if(isPhotoObject){
            		Toast.makeText(PhotosActivity.this, "" + position + ((Photo) photosList.get(position)).getOriginalUrl(), Toast.LENGTH_SHORT).show();
            		Intent i = new Intent(PhotosActivity.this, ShowPhotoActivity.class);	
            		i.putExtra("imageSource",((Photo) photosList.get(position)).getOriginalUrl());
            		startActivity(i);
                }
                else{
                	Toast.makeText(PhotosActivity.this, "" + position + ((Photo) photosList.get(position)).getOriginalUrl(), Toast.LENGTH_SHORT).show();
            		Intent i = new Intent(PhotosActivity.this, ShowPhotoActivity.class);	
            		i.putExtra("imageSource",((Video) photosList.get(position)).getOriginalUrl());
            		startActivity(i);
                }
            }
        });
	}
	 
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		osm.mlm.model.MLMFactory.setContext(this);
		PhotoRequest.GetMilifemapPhotosWithStartDate request= new PhotoRequest().new GetMilifemapPhotosWithStartDate(getApplicationContext());
		request.setCaller(this);
		try {
			request.makeRequest("4403e9c175685092|123456","2010-11-16T00:00:00Z","2011-11-16T00:00:00Z");
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
//		*********************************************
//		*********************************************
//		 MAKE REQUEST HERE
//		request = new LogInRequest().new LoginWithEmail();
//		request.setCaller(this);

//		*********************************************
//		*********************************************
		

//		Photo p1 = null;
//		try {
//			p1 = new Photo();
//			p1.setThumbnailUrl("http://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv/mid-Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv.jpg");
//			p1.setOriginalUrl("http://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv/mid-Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv.jpg");
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		
//		for(int i=0;i<40;i++){
//			//**********************************1//
//			photosList.add(p1);
//			//**********************************2//
//		}
//
//		for (Model photo : photosList) {
//			if(isPhotoObject){
//				galleryThumbURIList.add(((Photo) photo).getThumbnailUrl());
//			}
//			else{
//				//galleryThumbURIList.add(((Video) photo).getThumbnailUrl());
//			}
//		}
//
//		new AddImageTask().execute();
	}
 
 






	private class ImageAdapter extends BaseAdapter { 
		private Context mContext;
		
		public ImageAdapter(Context c) {
	        mContext = c;
	        bitmapsArray = new ArrayList<View>();
	    }
	
	    public int getCount() {
	        return bitmapsArray.size();
	    }
	
	    public Object getItem(int position) {
	        return position;
	    } 
	
	    public long getItemId(int position) {
	        return position;
	    }
	
	    public void addItem(View item){
	    	bitmapsArray.add(item);
	    }
	    public void addItemWithIndex(int index,View item){
	    	Log.v("ADD_INDEX: ",index+"");
	    	bitmapsArray.add(index,item);
	    	
	    }
	    public void removeAndAddItem(int index,View item){
//	    	bitmapsArray.remove(index);
	    	Log.v("REMOVE_INDEX: ",index+"");
	    	bitmapsArray.set(index,item);
	    }
	    public View getView(int position, View convertView, ViewGroup parent) {
	        return bitmapsArray.get(position);
	    }
	
	}
	
	
	class AddImageTask extends AsyncTask<Void, Void, Void> {
		public AddImageTask() {

		}
		Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tab_image);
		@Override
		synchronized protected Void doInBackground(Void... unused) {
			
			if(!doneShowingProgress){
				for (int i = 0; i < galleryThumbURIList.size(); i++) {
					View inflater = View.inflate(PhotosActivity.this,
				
						R.layout.custom_progress_bar, null);
				inflater.setLayoutParams(new GridView.LayoutParams(60, 60));
				inflater.setPadding(8, 8, 8, 8);	
				imageAdapter.addItem(inflater);
				publishProgress();
				}
				doneShowingProgress=true;
			}
			if(doneShowingProgress){
				for (int i = 0; i < galleryThumbURIList.size(); i++) {
					String url = galleryThumbURIList.get(i);
//					new AddImageTask(url, i).execute();
				
				
				View v = new View(PhotosActivity.this);
				Drawable d = new BitmapDrawable(Constants.downloadFile(url));
//				SDCardIO.saveToSDCard(url,Constants.downloadFile(url));
				v.setBackgroundDrawable(d);
				v.setLayoutParams(new GridView.LayoutParams(60	, 60));
				v.setPadding(8, 8, 8, 8);
				
				imageAdapter.removeAndAddItem(i,v);
				publishProgress();
				}
			}
				
		


//		    }

			return (null);
		}
		
		@Override
		protected void onProgressUpdate(Void... unused) {
			
			imageAdapter.notifyDataSetChanged();
		}
		@Override
		protected void onPostExecute(Void unused) {
//			dialog.dismiss();
		}
	}


	public void getAllPhotosWithStartDateFailedWithErrorMessage(String message) {
		// TODO Auto-generated method stub
		
	}



	public void getAllPhotosWithStartDateSuccessfulWithMessage(
			QuerySet<Photo> photos) {
	
		for(Model photo : photos){
			//**********************************1//
			photosList.add(photo);
			//**********************************2//
		}

		for (Model photo : photosList) {
			if(isPhotoObject){
				galleryThumbURIList.add(((Photo) photo).getThumbnailUrl());
				Log.d("THUMB URL: ",((Photo) photo).getThumbnailUrl());
			}
			else{
				//galleryThumbURIList.add(((Video) photo).getThumbnailUrl());
			}
		}
		
		// TODO Auto-generated method stub
		
	}



	public void getLifeMapPhotosWithStartDateSuccessfulWithMessage(
			QuerySet<Photo> photos) {
		// TODO Auto-generated method stub
		Log.v("AUTHENTICATION","SUCCESSFUL");
		Log.d("AUTHENTICATION","SUCCESSFUL");
		for(Model photo : photos){
			//**********************************1//
			photosList.add(photo);
			//**********************************2//
		}

		for (Model photo : photosList) {
			if(isPhotoObject){
				galleryThumbURIList.add(((Photo) photo).getThumbnailUrl());
				Log.d("THUMB URL: ",((Photo) photo).getThumbnailUrl());
			}
			else{
				//galleryThumbURIList.add(((Video) photo).getThumbnailUrl());
			}
		}
		new AddImageTask().execute();

	}



	public void getLifeMapPhotosWithStartDateFailedWithErrorMessage(
			String message) {
		// TODO Auto-generated method stub
		Log.v("AUTHENTICATION","FAILED");
		Log.d("AUTHENTICATION","FAILED");
		
	}
}

















//package osm.mlm.lifemap;
// 
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.vendevo.lifemap.R;
//
//import osm.mlm.gallery.Constants;
//import osm.mlm.gallery.Photo;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.Toast;
//
//public class PhotosActivity extends Activity{
//	private static final String TAG = "PhotosActivity";
//	private List <Photo> photosList;
//	private ArrayList<String> photoThumbURIList; 
//	Bitmap bmImg;
//	GridView gridView;
//	ImageAdapter imageAdapter;
//	public ArrayList<View> bitmapsArray;
//	public ProgressDialog dialog;
//	public static int cancelFlag=0;
//	Handler myHandler;
//	Handler myHandler2;
//	
//	
//	@Override
//	protected void onStart() {
//		// TODO Auto-generated method stub
//		super.onStart();
//		//populate photos List
//		myHandler = new Handler();
//		myHandler2 = new Handler();
//		Photo p1 = new Photo("http://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv/mid-Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv.jpg","http://bitmapheaven.com/bitmap/dnload/true/polarbear-1920.jpg");
//		Photo p2 = new Photo("http://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv/mid-Jupiter_from_Voyager_1_PIA02855_thumbnail_300px_max_quality.ogv.jpg","http://www.web-vista.com/wp-content/uploads/2010/12/water-world-wallpaper.jpg");
//		Photo p3 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/image/42771_milifemap_4458_thumb.jpeg","http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png");
//		Photo p4 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/image/42771_milifemap_4458_thumb.jpeg","http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png");
//		Photo p5 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/image/42771_milifemap_4458_thumb.jpeg","http://bitmapheaven.com/bitmap/dnload/true/polarbear-1920.jpg");
//
//		
//		for(int i=0;i<8;i++){
//			//**********************************1//
//			photosList.add(p1);
//			photosList.add(p2);
//			photosList.add(p3);
//			photosList.add(p4);
//			photosList.add(p5);
//			//**********************************2//
//		}
//
//		for (Photo photo : photosList) {
//			photoThumbURIList.add(photo.getThumbnailURL());
//		}
//
//		
//		
//		Thread inflaterThread = new Thread(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
////				myHandler2.post(new Runnable() {
//					
////					public void run() {
//						// TODO Auto-generated method stub
//						for (int i = 0; i < photoThumbURIList.size(); i++) {
//							View inflater = View.inflate(PhotosActivity.this,
//									R.layout.custom_progress_bar, null);
//							inflater.setLayoutParams(new GridView.LayoutParams(60, 60));
//							inflater.setPadding(8, 8, 8, 8);	
//							imageAdapter.addItem(inflater);
//						}
////					} 
////				});
//			} 
//		});
//		 
//		Thread mythread = new Thread(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
//				myHandler.post(new Runnable() {
//					
//					public void run() {
//						// TODO Auto-generated method stub
//						for (int i = 0; i < photoThumbURIList.size(); i++) {
//							String url = photoThumbURIList.get(i);
//							new AddImageTask(url, i).execute();
//						}
//					}
//				});
//			}
//		});
//		inflaterThread.start();
////		while(inflaterThread.isAlive()){
////			
////		}
//		mythread.start(); 
//		
//		
//		
////		new PullImages().start();
//		// TODO Auto-generated method stub
//
//	}
// 
// 
//	private class PullImages extends Thread{
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			super.run();
//
//			Looper.prepare();
//
//			for (int i = 0; i < photoThumbURIList.size(); i++) {
//				String url = photoThumbURIList.get(i);
////				new AddImageTask(url, i).execute();
//			}
//			Looper.loop();
//			
//		}
//		
//	}
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.photos);
//		
//		photosList = new ArrayList<Photo>(); // this would be equal to the photos passed here...
//		photoThumbURIList = new ArrayList<String>();
//		
//		gridView = (GridView) findViewById(R.id.photosGridView);
//		imageAdapter = new ImageAdapter(this);
//
//		gridView.setAdapter(imageAdapter);
//		gridView.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(PhotosActivity.this, "" + position + photosList.get(position).getSourceURL(), Toast.LENGTH_SHORT).show();
//                
//                Intent i = new Intent(PhotosActivity.this, ShowPhotoActivity.class);
//                i.putExtra("imageSource",photosList.get(position).getSourceURL());
//
//                startActivity(i);
//            }
//        });
//	}
//
//
//
//
//	private class ImageAdapter extends BaseAdapter { 
//		private Context mContext;
//		
//		public ImageAdapter(Context c) {
//	        mContext = c;
//	        bitmapsArray = new ArrayList<View>();
//	    }
//	
//	    public int getCount() {
//	        return bitmapsArray.size();
//	    }
//	
//	    public Object getItem(int position) {
//	        return position;
//	    } 
//	
//	    public long getItemId(int position) {
//	        return position;
//	    }
//	
//	    public void addItem(View item){
//	    	bitmapsArray.add(item);
//	    }
//	    public void addItemWithIndex(int index,View item){
//	    	Log.v("ADD_INDEX: ",index+"");
//	    	bitmapsArray.add(index,item);
//	    	
//	    }
//	    public void removeAndAddItem(int index,View item){
////	    	bitmapsArray.remove(index);
//	    	Log.v("REMOVE_INDEX: ",index+"");
//	    	bitmapsArray.set(index,item);
//	    }
//	    public View getView(int position, View convertView, ViewGroup parent) {
//	        return bitmapsArray.get(position);
//	    }
//	
//	}
//	
//	
//	class AddImageTask extends AsyncTask<Void, Void, Void> {
//		String url;
//		int index;
//		public AddImageTask(String filePath, int index) {
//			// TODO Auto-generated constructor stub
//			this.index = index;
//			url = filePath;
//		}
//		Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tab_image);
//		@Override
//		synchronized protected Void doInBackground(Void... unused) {
//			
//			
//				
//
//				View v = new View(PhotosActivity.this);
//				Drawable d = new BitmapDrawable(Constants.downloadFile(url));
////				SDCardIO.saveToSDCard(url,Constants.downloadFile(url));
//				v.setBackgroundDrawable(d);
//				v.setLayoutParams(new GridView.LayoutParams(60	, 60));
//				v.setPadding(8, 8, 8, 8);
//				
//				imageAdapter.removeAndAddItem(index,v);
//
//				publishProgress();
//		
//
//
////		    }
//
//			return (null);
//		}
//		
//		@Override
//		protected void onProgressUpdate(Void... unused) {
//			
//			imageAdapter.notifyDataSetChanged();
//		}
//		@Override
//		protected void onPostExecute(Void unused) {
////			dialog.dismiss();
//		}
//	}
//}
//
//
//
//


//package com.vendevo.lifemap;
// 
//
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import com.vendevo.lifemap.SDCardIO;
//
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.entity.FileEntity;
//
//import com.vendevo.lifemap.gallery.Constants;
//import com.vendevo.lifemap.gallery.Photo;
//
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.Drawable;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//
//public class PhotosActivity extends Activity{
//	private static final String TAG = "PhotosActivity";
//	private List <Photo> photosList;
//	private ArrayList<String> photoThumbURIList; 
//	Bitmap bmImg;
//	GridView gridView;
//	private String[] mPhotoList;
//	ImageAdapter imageAdapter;
//	public ArrayList<View> bitmapsArray;
//	public ProgressDialog dialog;
//	public static int cancelFlag=0;
//	Handler myThreadHandler;
//	Handler myHandler;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.photos);
////		ProgressDialog pd = ProgressDialog.show(PhotosActivity.this, "Loading gallery", "Please wait...", true,true);
//		photosList = new ArrayList<Photo>(); // this would be equal to the photos passed here...
//		photoThumbURIList = new ArrayList<String>();
//		myHandler = new Handler();
//		Thread initialThread = new Thread(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
//				//populate photos List
//				Photo p1 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/image/42771_milifemap_4458_thumb.jpeg","http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png");
//				Photo p2 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/video/annoying_27154_thumb.jpg","http://www.web-vista.com/wp-content/uploads/2010/12/water-world-wallpaper.jpg");
//				Photo p3 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/video/annoyin_49794_thumb.jpg","http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png");
//				Photo p4 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/image/42771_milifemap_4458_thumb.jpeg","http://icons.iconarchive.com/icons/iconshock/high-detail-social/128/twitter-icon.png");
//				Photo p5 = new Photo("http://milifemap-staging.s3.amazonaws.com/4403e9c175685092/image/42771_milifemap_4458_thumb.jpeg","http://bitmapheaven.com/bitmap/dnload/true/polarbear-1920.jpg");
//				
//				//**********************************1//
//				for(int i=0;i<6;i++){
//					photosList.add(p1);
//					photosList.add(p2);
//					photosList.add(p3);
//					photosList.add(p4);
//					photosList.add(p5);
//				}
//				
//				
//				for (Photo photo : photosList) {
////					if(!photoThumbURIList.contains(photo.getThumbnailURL())){
//						photoThumbURIList.add(photo.getThumbnailURL());
////					}
//				}
//				final View inflater = View.inflate(PhotosActivity.this, R.layout.custom_progress_bar, null);
//			    inflater.setLayoutParams(new GridView.LayoutParams(60	, 60));
//				inflater.setPadding(8, 8, 8, 8);
//				
//				
//				myHandler.post(new Runnable() {
//					
//					public void run() {
//						// TODO Auto-generated method stub
//						for (int i=0;i<photoThumbURIList.size();i++) {
//							imageAdapter.addItem(inflater);
////							imageAdapter.notifyDataSetChanged();
//						}
//					}
//				});
//				 
//				gridView = (GridView) findViewById(R.id.photosGridView);
//				imageAdapter = new ImageAdapter(PhotosActivity.this);
//
//				gridView.setAdapter(imageAdapter);
//				gridView.setOnItemClickListener(new OnItemClickListener() {
//		            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//		                Toast.makeText(PhotosActivity.this, "" + position + photosList.get(position).getSourceURL(), Toast.LENGTH_SHORT).show();
//		                
//		                Intent i = new Intent(PhotosActivity.this, ShowPhotoActivity.class);
//		                i.putExtra("imageSource",photosList.get(position).getSourceURL());
//
//		                startActivity(i);
//		            }
//		        });
//				
//					
//				myHandler.post(new Runnable() {
//					
//					public void run() {
//						// TODO Auto-generated method stub
//						for (int i = 0; i < photoThumbURIList.size(); i++) {
//							String url = photoThumbURIList.get(i);
//							new AddImageTask(url, i).execute();
//						}
//					}
//				});
//								
//			}
//		});
//		
//		
//		initialThread.start();
//		
//	}
//
//	private class ImageAdapter extends BaseAdapter {
//		private Context mContext;
//		
//		public ImageAdapter(Context c) {
//	        mContext = c;
//	        
//	        bitmapsArray = new ArrayList<View>();
//	    }
//	
//	    public int getCount() {
//	        return bitmapsArray.size();
//	    }
//	
//	    public Object getItem(int position) {
//	        return position;
//	    } 
//	
//	    public long getItemId(int position) {
//	        return position;
//	    }
//	
//	    public void addItem(View item){
//	    	bitmapsArray.add(item);
//	    }
//	    public void addItemWithIndex(int index,View item){
//	    	Log.v("ADD_INDEX: ",index+"");
//	    	bitmapsArray.add(index,item);
//	    	
//	    }
//	    public void removeAndAddItem(int index,View item){
////	    	bitmapsArray.remove(index);
//	    	Log.v("REMOVE_INDEX: ",index+"");
//	    	bitmapsArray.set(index,item);
//	    }
//	    public View getView(int position, View convertView, ViewGroup parent) {
//	        return bitmapsArray.get(position);
//	    }
//	
//	}
//	
//	
//	class AddImageTask extends AsyncTask<Void, Void, Void> {
//		String url;
//		int index;
//		public AddImageTask(String filePath, int index) {
//			// TODO Auto-generated constructor stub
//			this.index = index;
//			url = filePath;
//		}
//		Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tab_image);
//		@Override
//		synchronized protected Void doInBackground(Void... unused) {
//				View v = new View(PhotosActivity.this);
//				Drawable d;
//				
//				if(SDCardIO.fileExists(Constants.extractFileName(url))){
//					Log.v(TAG, "File Already exists!!!! getting from SDCard");
//					d= new BitmapDrawable(SDCardIO.getFromSDCard(Constants.extractFileName(url)));
//				}else{
//					Log.d(TAG, "File does NOT exist!!!! downloading and getting from SDCard");
//					SDCardIO.saveToSDCard(Constants.extractFileName(url), Constants.downloadFile(url));
//					d= new BitmapDrawable(SDCardIO.getFromSDCard(Constants.extractFileName(url)));
//				}
//
//				v.setBackgroundDrawable(d);
//				v.setLayoutParams(new GridView.LayoutParams(60	, 60));
//				v.setPadding(8, 8, 8, 8);
//				
//				imageAdapter.removeAndAddItem(index,v);
//
//				publishProgress();
////		    }
//
//			return (null);
//		}
//		
//		@Override
//		protected void onProgressUpdate(Void... unused) {
//			
//			imageAdapter.notifyDataSetChanged();
//		}
//		@Override
//		protected void onPostExecute(Void unused) {
////			dialog.dismiss();
//		}
//	}
//}
//
