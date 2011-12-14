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
import osm.mlm.webservice.Callback.UpdateStatusCallback;

public class StatusRequest{
	
	
	public class UpdateStatus extends Request  implements IResponse {
	
		private Callback.UpdateStatusCallback caller;

		public UpdateStatusCallback getCaller() {
			return caller;
		}

		public void setCaller(UpdateStatusCallback caller) {
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
					//caller.updateStatusSuccessfulWithMessage((String) responseString);
				} else {
					//caller.updateStatusFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
