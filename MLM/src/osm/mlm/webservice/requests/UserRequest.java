package osm.mlm.webservice.requests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.User;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;
import osm.mlm.webservice.Callback.CreateDiaryCallback;
import osm.mlm.webservice.Callback.GetUserInfoCallback;
import osm.mlm.webservice.Callback.LoginWithEmailCallback;
import osm.mlm.webservice.Callback.UploadLinkWithUrlCallback;

public class UserRequest{
	
	
	public class GetUserInfo extends Request  implements IResponse {
	
		private Callback.GetUserInfoCallback caller;

		public GetUserInfoCallback getCaller() {
			return caller;
		}

		public void setCaller(GetUserInfoCallback caller) {
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
				//	caller.getUserInfoSuccessfulWithUser((User) responseString);
				} else {
					//caller.getUserInfoFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
