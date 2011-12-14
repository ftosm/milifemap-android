package osm.mlm.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.MLMFactory;
import osm.mlm.webservice.requests.ActivitiesRequest;
import osm.mlm.webservice.requests.DiaryRequest;
import osm.mlm.webservice.requests.LogInRequest;

import android.util.Log;

public class RequestExecutor{

	private IResponse _caller;
	private List<NameValuePair> _postParameters;
	private HttpPost _request;
	private JSONObject _jsonObj;
	private BufferedReader _in = null;
	private RequestExecutor _requestExecutorInstance;
	
	
	public RequestExecutor(List<NameValuePair> postParameters, IResponse caller){
		setCaller(caller);
		setPostParameters(postParameters);
		
	}

//	public static synchronized RequestExecutor getInstance(List<NameValuePair> postParameters, IResponse caller) {
//		
//	
//		
//		if (_requestExecutorInstance == null) {
//			_requestExecutorInstance = new RequestExecutor();
//		}
//		
//		_requestExecutorInstance.setCaller(caller);
//		_requestExecutorInstance.setPostParameters(postParameters);
//		
//		return _requestExecutorInstance;
//	}

	public JSONObject execute()
			throws ClientProtocolException, IOException, JSONException {


		try {
			HttpClient client = new DefaultHttpClient();
			String url=getPostParameters().get(0).getValue();
			_request= new HttpPost(url);
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
					_postParameters);

			_request.setEntity(formEntity);
			HttpResponse response = client.execute(_request);
			_in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = _in.readLine()) != null) {
				sb.append(line + NL);
			}
			_in.close();

			String result = sb.toString();
			Log.i("Result Tag", result);
			_jsonObj = new JSONObject(result);

		} finally {
		}


		return _jsonObj;
	}

	public IResponse getCaller() {
		return _caller;
	}

	public void setCaller(IResponse _caller) {
		this._caller = _caller;
	}

	public List<NameValuePair> getPostParameters() {
		return _postParameters;
	}

	public void setPostParameters(List<NameValuePair> _postParameters) {
		this._postParameters = _postParameters;
	}

}
