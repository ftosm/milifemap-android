
package osm.mlm.webservice.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import osm.mlm.model.LifemapBase;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.Callback.GetActivitiesWithIdentifierCallback;
import osm.mlm.webservice.Callback.GetAllVideosWithStartDateCallBack;
import osm.mlm.webservice.Callback.GetFacebookVideoUrlWithVideoCallback;
import osm.mlm.webservice.Callback.GetFacebookVideosWithStartDateCallBack;
import osm.mlm.webservice.Callback.GetFlickrVideosWithStartDateCallBack;
import osm.mlm.webservice.Callback.GetMilifemapVideosWithStartDateCallBack;
import osm.mlm.webservice.Callback.UploadVideoWithFilePathCallback;
import osm.mlm.webservice.Callback.UploadVideoWithVideoDataCallback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;

public class VideoRequest extends ActivitiesRequest{
	
	
	public class UploadVideoWithFilePath extends Request  implements IResponse {
	
		private Callback.UploadVideoWithFilePathCallback caller;

		public UploadVideoWithFilePathCallback getCaller() {
			return caller;
		}

		public void setCaller(UploadVideoWithFilePathCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String title, String text, String time) throws ClientProtocolException, IOException, JSONException {

//			   params= new ArrayList<NameValuePair>(); 
//			   params.add(new BasicNameValuePair("email", userToken));
//			   params.add(new BasicNameValuePair("password", title));
//			   params.add(new BasicNameValuePair("password", text));
//			   params.add(new BasicNameValuePair("password", time));
//
//			   appendRequest(params,this);
			   
			   }

		
		public void onResponse(JSONObject responseString) {

			try {
				if (checkForError( responseString)) {
					//caller.uploadVideoSuccessfulWithMessage((String) responseString);
				} else {
					//caller.uploadVideoFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class UploadVideoWithVideoData extends Request  implements IResponse {
		
		private Callback.UploadVideoWithVideoDataCallback caller;

		public UploadVideoWithVideoDataCallback getCaller() {
			return caller;
		}

		public void setCaller(UploadVideoWithVideoDataCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String email, String password) {
			
//			params= new LinkedHashMap<String, String>();
//			
//			params.put("email", email);
//			params.put("password", password);
//			
//			appendRequest(params,this);
			

		}

		
		public void onResponse(JSONObject responseString) {

			try {
				if (checkForError(responseString)) {
					//caller.uploadVideoSuccessfulWithMessage((String) responseString);
				} else {
					//caller.uploadVideoFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class GetFacebookVideoUrlWithVideo extends Request  implements IResponse {
		
		private Callback.GetFacebookVideoUrlWithVideoCallback caller;

		public GetFacebookVideoUrlWithVideoCallback getCaller() {
			return caller;
		}

		public void setCaller(GetFacebookVideoUrlWithVideoCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String email, String password) {
			
//			params= new LinkedHashMap<String, String>();
//			
//			params.put("email", email);
//			params.put("password", password);
//			
//			appendRequest(params,this);
//			

		}

		
		public void onResponse(JSONObject responseString) {

			try {
				if (checkForError(responseString)) {
					//caller.getFacebookVideoSuccessfulWithURL((FacebookVideo) responseString);
				} else {
					//caller.getFacebookVideoFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class GetAllVideosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetAllVideosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetAllVideosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetAllVideosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {
			
			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);

		}

		
		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getAllVideosWithStartDateFailedWithErrorMessage(message);
		}

		
		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> datas) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	public class GetMilifemapVideosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetMilifemapVideosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetMilifemapVideosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetMilifemapVideosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {
			
			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);

		}

		
		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getMilifemapVideosWithStartDateFailedWithErrorMessage(message);
		}

		
		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> datas) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	public class GetFacebookVideosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetFacebookVideosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetFacebookVideosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetFacebookVideosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {
			
			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);
		}

		
		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getFacebookVideosWithStartDateFailedWithErrorMessage(message);
		}

		
		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> datas) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	public class GetFlickrVideosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetFlickrVideosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetFlickrVideosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetFlickrVideosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {
			
			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);

		}
		
		
		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getFlickrVideosWithStartDateFailedWithErrorMessage(message);
		}

		
		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> datas) {
			// TODO Auto-generated method stub
			
		}
	
	}

	

}
