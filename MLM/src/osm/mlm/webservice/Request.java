package osm.mlm.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import osm.mlm.model.Constants;

public class Request {

	public List<NameValuePair> params;

	public Boolean checkForError(JSONObject jsonResponse) throws JSONException {

		

		if (jsonResponse.get(Constants.RESULT_KEY).equals(
				Constants.RESPONSE_FAIL)) {
			return true;
		} else {
			return false;
		}
	}

	public void appendRequest(List<NameValuePair> params, IResponse caller)
			throws ClientProtocolException, IOException, JSONException {

		ExecutorService es = Executors.newFixedThreadPool(3);
		RequestHandler handler= new RequestHandler(params,caller);
		final Future future = es.submit(handler);
		
		// RequestExecutor.references.add(caller);

	}

}
