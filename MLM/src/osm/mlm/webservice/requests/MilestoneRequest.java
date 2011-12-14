package osm.mlm.webservice.requests;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.basecontainer.Milestone;
import osm.mlm.model.basecontainer.Yearbook;
import osm.mlm.webservice.Callback;
import osm.mlm.webservice.IResponse;
import osm.mlm.webservice.Request;
import osm.mlm.webservice.Callback.CreateDiaryCallback;
import osm.mlm.webservice.Callback.CreateMilestoneWithTitleCallback;
import osm.mlm.webservice.Callback.CreateSingleYearbookWithTitleCallback;
import osm.mlm.webservice.Callback.DeleteMilestoneWithIDCallback;
import osm.mlm.webservice.Callback.DeleteYearbookWithIDCallback;
import osm.mlm.webservice.Callback.GetAllMilestonesCallback;
import osm.mlm.webservice.Callback.GetAllYearbooksCallback;
import osm.mlm.webservice.Callback.GetSingleMilestoneCallback;
import osm.mlm.webservice.Callback.GetSingleYearbookCallback;
import osm.mlm.webservice.Callback.LoginWithEmailCallback;
import osm.mlm.webservice.Callback.UpdateMilestoneWithIDCallback;
import osm.mlm.webservice.Callback.UpdateYearbookWithIDCallback;

public class MilestoneRequest{
	
	
	public class GetAllMilestones extends Request  implements IResponse {
	
		private Callback.GetAllMilestonesCallback caller;

		public GetAllMilestonesCallback getCaller() {
			return caller;
		}

		public void setCaller(GetAllMilestonesCallback caller) {
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
					//caller.getAllMilestonesSuccessfulWithMilestones((Arrays) responseString);
				} else {
					//caller.getAllMilestonesFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class GetSingleMilestoneWithRefMilestone extends Request  implements IResponse {
		
		private Callback.GetSingleMilestoneCallback caller;

		public GetSingleMilestoneCallback getCaller() {
			return caller;
		}

		public void setCaller(GetSingleMilestoneCallback caller) {
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
					//caller.getSingleMilestoneSuccessfulWithMilestone((Milestone) responseString);
				} else {
					//caller.getSingleMilestoneFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class CreateMilestoneWithTitle extends Request  implements IResponse {
		
		private Callback.CreateMilestoneWithTitleCallback caller;

		public CreateMilestoneWithTitleCallback getCaller() {
			return caller;
		}

		public void setCaller(CreateMilestoneWithTitleCallback caller) {
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
					//caller.createMilestoneSuccessfulWithMilestoneID((String) responseString);
				} else {
					//caller.createMilestoneSuccessfulWithMilestoneID((String)responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class UpdateMilestoneWithID extends Request  implements IResponse {
		
		private Callback.UpdateMilestoneWithIDCallback caller;

		public UpdateMilestoneWithIDCallback getCaller() {
			return caller;
		}

		public void setCaller(UpdateMilestoneWithIDCallback caller) {
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
					//caller.updateMilestoneSuccessfulWithMessage((String) responseString);
				} else {
					//caller.updateMilestoneFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class DeleteMilestoneWithID extends Request  implements IResponse {
		
		private Callback.DeleteMilestoneWithIDCallback caller;

		public DeleteMilestoneWithIDCallback getCaller() {
			return caller;
		}

		public void setCaller(DeleteMilestoneWithIDCallback caller) {
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
					//caller.deleteMilestoneSuccessfulWithMessage((String) responseString);
				} else {
					//caller.deleteMilestoneFailedWithErrorMessage((String) responseString);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
