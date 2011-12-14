package osm.mlm.webservice.requests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.webservice.Callback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;
import osm.mlm.webservice.Callback.CreateDiaryCallback;
import osm.mlm.webservice.Callback.LoginWithEmailCallback;
import osm.mlm.webservice.Callback.SignUpWithEmailCallback;

public class SignUpRequest{
	
	
	public class SignUpWithEmail extends Request  implements IResponse {
	
		private Callback.SignUpWithEmailCallback caller;

		public SignUpWithEmailCallback getCaller() {
			return caller;
		}

		public void setCaller(SignUpWithEmailCallback caller) {
			this.caller = caller;
		}

		public void makeRequest(String email, String password) {
//			
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
				//	caller.signUpSuccessfulWithAccessToken((String) responseString);
				} else {
					//caller.signUpFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
