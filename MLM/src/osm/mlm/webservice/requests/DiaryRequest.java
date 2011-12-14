package osm.mlm.webservice.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import osm.mlm.model.Constants;
import osm.mlm.model.MLMActivity;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.Callback.GetAllDiariesWithStartDateCallback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;
import osm.mlm.webservice.RequestHandler;
import osm.mlm.webservice.Callback.CreateDiaryCallback;
import osm.mlm.webservice.Callback.GetAllDiariesCallback;
import osm.mlm.webservice.requests.ActivitiesRequest.GetAllActivitiesWithIdentifier;

public class DiaryRequest{
	
	private Context _context;
	private DiaryRequest caller;
	
	public class CreateDiary extends Request  implements IResponse {
	
		private Callback.CreateDiaryCallback caller;

		public CreateDiaryCallback getCaller() {
			return caller;
		}

		public void setCaller(CreateDiaryCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String title, String text, String time) throws ClientProtocolException, IOException, JSONException {
			
			params= new ArrayList<NameValuePair>(); 
			params.add(new BasicNameValuePair("url", Constants.BASE_URL+"/discover/diary"));
			params.add(new BasicNameValuePair("email", userToken));
			params.add(new BasicNameValuePair("password", title));
			params.add(new BasicNameValuePair("password", text));
			params.add(new BasicNameValuePair("password", time));
	
			appendRequest(params,this);
		}

		public void onResponse(JSONObject responseString) {

			try {
				if (!checkForError(responseString)) {
					
					caller.createDiarySuccessfulWithMessage(responseString.getString(Constants.MESSAGE_KEY));
				} else {
					caller.createDiaryFailedWithErrorMessage(responseString.getString(Constants.MESSAGE_KEY));
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class GetAllDiaries extends Request  implements IResponse {
		
		private Callback.GetAllDiariesCallback caller;

		public GetAllDiariesCallback getCaller() {
			return caller;
		}

		public void setCaller(GetAllDiariesCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken) throws ClientProtocolException, IOException, JSONException {
		
			params= new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("url", Constants.BASE_URL+"discover/get_diary_service"));
			params.add(new BasicNameValuePair("userToken", userToken));
			
			appendRequest(params,this);
				
			

		}

		public void onResponse(JSONObject responseString) {

			try {
				if (!checkForError(responseString)) {
					
					JSONArray activityDicts=responseString.getJSONArray(Constants.RESULT_KEY);
					
					for(int i=0;i<activityDicts.length();i++){
						MLMActivity activity=new MLMActivity();
						activity.setupWithDictionary(activityDicts.getJSONObject(i));
					}
					
					//caller.getAllDiariesSuccessfulWithDiaries();
				} else {
					caller.getAllDiariesFailedWithErrorMessage(responseString.getString(Constants.MESSAGE_KEY));
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class GetAllDiariesWithStartDate extends ActivitiesRequest{
		
		private Callback.GetAllDiariesWithStartDateCallback caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetAllDiariesWithStartDate(Context context) {
			//super();
			activityRequest= new GetAllActivitiesWithIdentifier(context);
		}
		
		public GetAllDiariesWithStartDateCallback getCaller() {
			return caller;
		}

		public void setCaller(GetAllDiariesWithStartDateCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate, String spanEndDate,String filter) throws ClientProtocolException, IOException, JSONException {
			
			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate, filter);

		}
	}
}
