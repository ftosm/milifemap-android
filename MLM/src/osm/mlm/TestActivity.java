//package osm.mlm;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Date;
//
//import org.apache.http.client.ClientProtocolException;
//import org.json.JSONArray;
//import org.json.JSONException;
//
//import com.orm.androrm.DatabaseAdapter;
//import com.orm.androrm.Model;
//import com.vendevo.lifemap.R;
//
//import osm.mlm.model.Constants;
//import osm.mlm.model.LifemapBase;
//import osm.mlm.model.LifemapBaseContainer;
//import osm.mlm.model.MLMActivity;
//import osm.mlm.model.MLMManager;
//import osm.mlm.model.SocialNetwork;
//import osm.mlm.model.User;
//import osm.mlm.model.base.Diary;
//import osm.mlm.model.base.FoursqureCheckIn;
//import osm.mlm.model.base.Link;
//import osm.mlm.model.base.Photo;
//import osm.mlm.model.base.Status;
//import osm.mlm.model.base.Video;
//import osm.mlm.model.base.link.FacebookLink;
//import osm.mlm.model.base.link.LifemapLink;
//import osm.mlm.model.base.photo.FacebookPhoto;
//import osm.mlm.model.base.photo.FlickerPhoto;
//import osm.mlm.model.base.photo.LifemapPhoto;
//import osm.mlm.model.base.status.FacebookStatus;
//import osm.mlm.model.base.status.LifemapStatus;
//import osm.mlm.model.base.status.TwitterStatus;
//import osm.mlm.model.base.video.FacebookVideo;
//import osm.mlm.model.base.video.FlickerVideo;
//import osm.mlm.model.base.video.LifemapVideo;
//import osm.mlm.model.base.video.YoutubeVideo;
//import osm.mlm.webservice.Callback.CreateDiaryCallback;
//import osm.mlm.webservice.Callback.GetActivitiesWithIdentifierCallback;
//import osm.mlm.webservice.Callback.GetAllDiariesCallback;
//import osm.mlm.webservice.Callback.LoginWithEmailCallback;
//import osm.mlm.webservice.requests.ActivitiesRequest;
//import osm.mlm.webservice.requests.DiaryRequest;
//import osm.mlm.webservice.requests.LogInRequest;
//import osm.mlm.webservice.requests.LogInRequest.LoginWithEmail;
//import android.app.Activity;
//import android.os.Bundle;
//
//public class TestActivity extends Activity implements GetActivitiesWithIdentifierCallback,CreateDiaryCallback,LoginWithEmailCallback{
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        setupDB();
//        
////       LoginWithEmail loginRequest = new LogInRequest().new LoginWithEmail();
////       loginRequest.setCaller(this);
////       try {
////		loginRequest.makeRequest("tahniyat@sprd.co", "123456");
////	} catch (ClientProtocolException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	} catch (JSONException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
////        
//        MLMFactory.setContext(getApplicationContext());
//        
//        ActivitiesRequest.GetAllActivitiesWithIdentifier activitiesRequest= new ActivitiesRequest().new GetAllActivitiesWithIdentifier(getApplicationContext());
//        activitiesRequest.setCaller(this);
//        try {
//			activitiesRequest.makeRequest("4403e9c175685092|123456","2010-11-16T00:00:00Z","2011-11-16T00:00:00Z",Constants.MILIFEMAP_VIDEO+","+Constants.FACEBOOK_VIDEO+","+Constants.FLICKR_VIDEO);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
////        DiaryRequest.CreateDiary diaryRequest = new DiaryRequest().new CreateDiary();
////        diaryRequest.setCaller(this);
////        try {
////        	Date now= new Date();
////			diaryRequest.makeRequest("4403e9c175685092|123456","Hassan Adnan","Bismillah",now.toString());
////		} catch (ClientProtocolException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (JSONException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////        
//    }
//
//
//    public void setupDB(){
//    	 
//    	 List<Class<? extends Model>> models = new ArrayList<Class<? extends Model>>();
//         
//    	 models.add(LifemapBase.class);
//         models.add(LifemapBaseContainer.class);
//         models.add(MLMActivity.class);
//         models.add(MLMManager.class);
//         models.add(SocialNetwork.class);
//         models.add(User.class);
//         
//         models.add(Photo.class);
//     //    models.add(FacebookPhoto.class);
//       //  models.add(FlickerPhoto.class);
//         //models.add(LifemapPhoto.class);
//         
//         models.add(Link.class);
//         //models.add(FacebookLink.class);
//         //models.add(LifemapLink.class);
//         
//         models.add(Diary.class);
//         models.add(FoursqureCheckIn.class);
//         
//         models.add(Status.class);
//         //models.add(LifemapStatus.class);
//         //models.add(TwitterStatus.class);
//         //models.add(FacebookStatus.class);
//         
//         models.add(Video.class);
//         //models.add(YoutubeVideo.class);
//         //models.add(FacebookVideo.class);
//         //models.add(FlickerVideo.class);
//         //models.add(LifemapVideo.class);
//         
//         
//         
//         
//         DatabaseAdapter.setDatabaseName("mlm_db");
//         DatabaseAdapter adapter = new DatabaseAdapter(getApplicationContext());
//         adapter.setModels(models);
//    }
//
//
//	
//
//
//	public void getActivitiesSuccessfulWithActivities(MLMActivity[] activites) {
//		// TODO Auto-generated method stubac
//		
//		
//	}
//
//
//	public void getActivitiesFailedWithErrorMessage(String message) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	
//	public void createDiarySuccessfulWithMessage(String message) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	
//	public void createDiaryFailedWithErrorMessage(String message) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	public void logInSuccessfulWithAccessToken(String token) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	
//	public void logInFailedWithErrorMessage(String message) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	public void getActivitiesSuccessfulWithActivities(Arrays activites) {
//		// TODO Auto-generated method stub
//		
//	}
//}