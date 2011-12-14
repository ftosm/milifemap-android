package osm.mlm.webservice;


import java.util.List;
import java.util.concurrent.*;

import org.apache.http.NameValuePair;


public class RequestHandler implements Callable {

	private  IResponse _requester;
	private List<NameValuePair> _params;
	
	public RequestHandler( List<NameValuePair> params,IResponse requester){
		
		_requester=requester;
		_params=params;
		
	}
	
	public Object call() throws Exception {
		
		RequestExecutor requestExecutor = new RequestExecutor(_params,_requester);
		_requester.onResponse(requestExecutor.execute());
		
		return null;
	}

	public IResponse getRequester() {
		return _requester;
	}

	public void setRequester(IResponse requester) {
		this._requester= requester;
	}
	
	
	

}
