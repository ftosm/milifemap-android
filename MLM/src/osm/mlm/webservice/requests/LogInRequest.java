package osm.mlm.webservice.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.Constants;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;
import osm.mlm.webservice.Callback.CreateDiaryCallback;
import osm.mlm.webservice.Callback.LoginWithEmailCallback;

public class LogInRequest{
	
	
	public class LoginWithEmail extends Request  implements IResponse {
	
		private Callback.LoginWithEmailCallback caller;

		public LoginWithEmailCallback getCaller() {
			return caller;
		}

		public void setCaller(LoginWithEmailCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String email, String password) throws ClientProtocolException, IOException, JSONException {
			
			params= new ArrayList<NameValuePair>(); 
			params.add(new BasicNameValuePair("email", email));
			params.add(new BasicNameValuePair("password", password));
	
			appendRequest(params,this);
			

		}

		
		public void onResponse(JSONObject responseString) {

			try {
				if (!checkForError(responseString)) {
					caller.logInSuccessfulWithAccessToken(responseString.getString(Constants.RESULT_KEY));
				} else {
					caller.logInFailedWithErrorMessage(responseString.getString(Constants.MESSAGE_KEY));
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
