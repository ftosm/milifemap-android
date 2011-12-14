package osm.mlm.webservice.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.orm.androrm.QuerySet;

import android.content.Context;

import osm.mlm.model.Constants;
import osm.mlm.model.LifemapBase;
import osm.mlm.model.base.Photo;
import osm.mlm.model.base.photo.FlickerPhoto;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.Callback.GetActivitiesWithIdentifierCallback;
import osm.mlm.webservice.Callback.GetAllPhotosWithStartDateCallBack;
import osm.mlm.webservice.Callback.GetFacebookPhotosWithStartDateCallBack;
import osm.mlm.webservice.Callback.GetFlickerPhotosWithStartDateCallBack;
import osm.mlm.webservice.Callback.GetLifeMapPhotosWithStartDateCallBack;
import osm.mlm.webservice.Request;

public class PhotoRequest extends ActivitiesRequest {

	public class GetAllPhotosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetAllPhotosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;
		
		public GetAllPhotosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(_context);
			activityRequest.setCaller(this);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetAllPhotosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {

			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);
		}

	
		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getAllPhotosWithStartDateFailedWithErrorMessage(message);
		}

		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> datas) {
			
			caller.getAllPhotosWithStartDateSuccessfulWithMessage(Photo.objects(_context).all());
			
		}

	
	}
	
	public class GetMilifemapPhotosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetLifeMapPhotosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetMilifemapPhotosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
			activityRequest.setCaller(this);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetLifeMapPhotosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate) throws ClientProtocolException, IOException, JSONException {

			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, Constants.MILIFEMAP_PHOTO);
		}

		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getLifeMapPhotosWithStartDateFailedWithErrorMessage(message);
		}

		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> datas) {
			caller.getLifeMapPhotosWithStartDateSuccessfulWithMessage(Photo.objects(_context).all());
			
		}
	
	}
	
	public class GetFacebookPhotosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetFacebookPhotosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetFacebookPhotosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetFacebookPhotosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {

			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);

		}

		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getFacebookPhotosWithStartDateFailedWithErrorMessage(message);
		}

		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> datas) {
			
			caller.getFacebookPhotosWithStartDateSuccessfulWithMessage(Photo.objects(_context).all());
			// TODO Auto-generated method stub
			
		}
	
	}
	
	public class GetFlickrPhotosWithStartDate extends Request implements GetActivitiesWithIdentifierCallback{

		private Callback.GetFlickerPhotosWithStartDateCallBack caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetFlickrPhotosWithStartDate(Context context) {
			super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
		}
		
		public GetAllActivitiesWithIdentifier getCaller() {
			return activityRequest;
		}

		public void setCaller(GetFlickerPhotosWithStartDateCallBack caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {

			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);
		}

		public void getActivitiesSuccessfulWithActivities(ArrayList<LifemapBase> lifemapbaseList) {
		
			caller.getFlickerPhotosWithStartDateSuccessfulWithMessage(Photo.objects(_context).all());
			
		}

		public void getActivitiesFailedWithErrorMessage(String message) {
			caller.getFlickerPhotosWithStartDateFailedWithErrorMessage(message);
			
		}
	
	}
	
}

