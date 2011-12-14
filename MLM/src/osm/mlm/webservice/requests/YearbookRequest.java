package osm.mlm.webservice.requests;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.basecontainer.Yearbook;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;
import osm.mlm.webservice.Callback.CreateDiaryCallback;
import osm.mlm.webservice.Callback.CreateSingleYearbookWithTitleCallback;
import osm.mlm.webservice.Callback.DeleteYearbookWithIDCallback;
import osm.mlm.webservice.Callback.GetAllYearbooksCallback;
import osm.mlm.webservice.Callback.GetSingleYearbookCallback;
import osm.mlm.webservice.Callback.LoginWithEmailCallback;
import osm.mlm.webservice.Callback.UpdateYearbookWithIDCallback;

public class YearbookRequest{
	
	
	public class GetAllYearbooks extends Request  implements IResponse {
	
		private Callback.GetAllYearbooksCallback caller;

		public GetAllYearbooksCallback getCaller() {
			return caller;
		}

		public void setCaller(GetAllYearbooksCallback caller) {
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
					//caller.getAllYearbooksSuccessfulWithYearbooks((Arrays) responseString);
				} else {
					//caller.getAllYearbooksFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class GetSingleYearbookWithRefYearbook extends Request  implements IResponse {
		
		private Callback.GetSingleYearbookCallback caller;

		public GetSingleYearbookCallback getCaller() {
			return caller;
		}

		public void setCaller(GetSingleYearbookCallback caller) {
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
					//caller.getSingleYearbookSuccessfulWithYearbook((Yearbook) responseString);
				} else {
					//caller.getSingleYearbookFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class CreateYearbookWithTitle extends Request  implements IResponse {
		
		private Callback.CreateSingleYearbookWithTitleCallback caller;

		public CreateSingleYearbookWithTitleCallback getCaller() {
			return caller;
		}

		public void setCaller(CreateSingleYearbookWithTitleCallback caller) {
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
					//caller.createYearbookFailedWithErrorMessage((String)responseString);
				} else {
				//	caller.createYearbookSuccessfulWithYearbookID((String)responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class UpdateYearbookWithID extends Request  implements IResponse {
		
		private Callback.UpdateYearbookWithIDCallback caller;

		public UpdateYearbookWithIDCallback getCaller() {
			return caller;
		}

		public void setCaller(UpdateYearbookWithIDCallback caller) {
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
					//caller.updateYearbookSuccessfulWithMessage((String) responseString);
				} else {
				//	caller.updateYearbookFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class DeleteYearbookWithID extends Request  implements IResponse {
		
		private Callback.DeleteYearbookWithIDCallback caller;

		public DeleteYearbookWithIDCallback getCaller() {
			return caller;
		}

		public void setCaller(DeleteYearbookWithIDCallback caller) {
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
					//caller.deleteYearbookSuccessfulWithMessage((String) responseString);
				} else {
					//caller.deleteYearbookFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
