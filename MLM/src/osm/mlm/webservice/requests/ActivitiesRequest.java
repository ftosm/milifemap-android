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

import com.orm.androrm.Model;

import android.content.Context;

import osm.mlm.model.Constants;
import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;
import osm.mlm.model.base.Photo;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;
import osm.mlm.webservice.Callback.CreateDiaryCallback;
import osm.mlm.webservice.Callback.GetActivitiesWithIdentifierCallback;
import osm.mlm.webservice.Callback.GetActivitiesWithStartDateCallback;
import osm.mlm.webservice.Callback.LoginWithEmailCallback;

public class ActivitiesRequest {

	protected Context _context;

	public class GetAllActivitiesWithStartDate extends Request implements
			Callback.GetActivitiesWithIdentifierCallback {

		private Callback.GetActivitiesWithStartDateCallback caller;
		private ActivitiesRequest.GetAllActivitiesWithIdentifier activityRequest;

		public GetAllActivitiesWithStartDate(Context context) {
			_context = context;
			activityRequest = new GetAllActivitiesWithIdentifier(context);

		}

		public Callback.GetActivitiesWithStartDateCallback getCaller() {
			return caller;
		}

		public void setCaller(GetActivitiesWithStartDateCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate,
				String spanEndDate) throws ClientProtocolException,
				IOException, JSONException {

			activityRequest.makeRequest(userToken, spanStartDate, spanEndDate,
					"all");

		}

	
		public void getActivitiesFailedWithErrorMessage(String message) {
			// TODO Auto-generated method stub
			
		}

		public void getActivitiesSuccessfulWithActivities(
				ArrayList<LifemapBase> data) {
			// TODO Auto-generated method stub
			
		}

	}

	public class GetAllActivitiesWithIdentifier extends Request implements
			IResponse {

		private Callback.GetActivitiesWithIdentifierCallback caller;

		public GetAllActivitiesWithIdentifier(Context context) {
			_context = context;

		}

		public GetActivitiesWithIdentifierCallback getCaller() {
			return caller;
		}

		public void setCaller(GetActivitiesWithIdentifierCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String userToken, String spanStartDate,
				String spanEndDate, String filter)
				throws ClientProtocolException, IOException, JSONException {

			params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("url", Constants.BASE_URL
					+ "/timeline/show_feeds_service"));
			params.add(new BasicNameValuePair("userToken", userToken));
			params.add(new BasicNameValuePair("spanStartDate", spanStartDate));
			params.add(new BasicNameValuePair("spanEndDate", spanEndDate));
			params.add(new BasicNameValuePair("filter", filter));

			appendRequest(params, this);

		}

		public void onResponse(JSONObject responseString) {

			try {
				if (!checkForError(responseString)) {

					ArrayList<LifemapBase> lifemapBaseList = new ArrayList<LifemapBase>();
					JSONArray activityDicts = responseString
							.getJSONArray(Constants.RESULT_KEY);

					for (int i = 0; i < activityDicts.length(); i++) {

						MLMActivity activity = new MLMActivity();
						activity.setupWithDictionary(activityDicts
								.getJSONObject(i));

						
						//lifemapBaseList.add(activity.getData(_context));

					}
					caller.getActivitiesSuccessfulWithActivities(null);
				} else {
					caller.getActivitiesFailedWithErrorMessage(responseString
							.getString(Constants.RESULT_KEY));
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
