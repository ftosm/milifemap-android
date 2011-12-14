package osm.mlm.model;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.base.Diary;
import osm.mlm.model.base.FoursqureCheckIn;
import osm.mlm.model.base.Link;
import osm.mlm.model.base.Photo;
import osm.mlm.model.base.Status;
import osm.mlm.model.base.Video;
import osm.mlm.model.base.link.FacebookLink;
import osm.mlm.model.base.link.LifemapLink;
import osm.mlm.model.base.photo.FacebookPhoto;
import osm.mlm.model.base.photo.FlickerPhoto;
import osm.mlm.model.base.photo.LifemapPhoto;
import osm.mlm.model.base.status.FacebookStatus;
import osm.mlm.model.base.status.LifemapStatus;
import osm.mlm.model.base.status.TwitterStatus;
import osm.mlm.model.base.video.FacebookVideo;
import osm.mlm.model.base.video.FlickerVideo;
import osm.mlm.model.base.video.LifemapVideo;
import osm.mlm.model.base.video.YoutubeVideo;
import android.content.Context;

public class MLMFactory {

	private static MLMFactory _sharedInstance; // this is a singleton class, and
	private static LifemapBase lifemapBase;										// its static instance
	private static Context context;

	private MLMFactory() {
	}
	public static Context getContext() {
		return context;
	}

	public static void setContext(Context context) {
		MLMFactory.context = context;
	}

	public static synchronized MLMFactory getInstance() {
		if (_sharedInstance == null) {
			_sharedInstance = new MLMFactory();
		}
		return _sharedInstance;
	}

	public static LifemapBase createDataOfType(String assetType,
			JSONObject dictionary, MLMActivity activity) throws JSONException {

		lifemapBase = new LifemapBase();
		lifemapBase.setupWithJSON(dictionary, activity);
		lifemapBase.save(context);

		activity.setData(lifemapBase);
		activity.save(context);

		String jsonObjString = dictionary.getString("JSON_obj");
		JSONObject jsonObj = new JSONObject(jsonObjString);

		if (assetType.equals(Constants.kFeedTypeLifeMapPhoto)
				|| assetType.equals(Constants.kFeedTypeFaceBookPhoto)
				|| assetType.equals(Constants.kFeedTypeFlickerPhoto)) {

			Photo photo = new Photo();
			photo.setupWithJSON(dictionary, lifemapBase, assetType);
			photo.save(context);
		}

		if (assetType.equals(Constants.kFeedTypeLifeMapVideo)
				|| assetType.equals(Constants.kFeedTypeFlickerVideo)
				|| assetType.equals(Constants.kFeedTypeYouTubeVideo)) {

			Video video = new Video();
			video.setupWithJSON(dictionary, lifemapBase, assetType);
			video.save(context);
		}

		if (assetType.equals(Constants.kFeedTypeLifeMapDiary)) {

			Diary diary = new Diary();
			diary.setupWithJSON(jsonObj, lifemapBase);
			diary.save(context);

		}

		if (assetType.equals(Constants.kFeedTypeLifeMapStatus)
				|| assetType.equals(Constants.kFeedTypeFaceBookStatus)
				|| assetType.equals(Constants.kFeedTypeTwitterStatus)) {

			Status status = new Status();
			status.setupWithJSON(jsonObj, lifemapBase, assetType);
			status.save(context);

		}

		if (assetType.equals(Constants.kFeedTypeFourSquareCheckIn)) {

			FoursqureCheckIn foursquareCheckIn = new FoursqureCheckIn();
			foursquareCheckIn.setupWithJSON(dictionary, activity);
			foursquareCheckIn.save(context);
		}

		if (assetType.equals(Constants.kFeedTypeLifeMapLink)) {

			Link link = new Link();
			link.setupWithJSON(jsonObj, lifemapBase, assetType);
			link.save(context);
		}

		if (assetType.equals(Constants.kFeedTypeFaceBookLink)) {
			createDataWithDictionary(dictionary, activity);
		}

		return null;

	}

	public static LifemapBase createDataWithDictionary(JSONObject dictionary,
			MLMActivity activity) throws JSONException {

		LifemapBase data = null;

		if (isFacebookVideo(dictionary)) {

			Video video = new Video();
			video.setupWithJSON(dictionary, lifemapBase, Constants.kFeedTypeFaceBookVideo);
			video.save(context);

		}

		if (isFacebookLink(dictionary)) {
			
			Link link = new Link();
			link.setupWithJSON(dictionary, data, Constants.kFeedTypeFaceBookLink);
			link.save(context);
		}

		if (isYoutubeVideo(dictionary)) {

			Video video = new Video();
			video.setupWithJSON(dictionary, lifemapBase, Constants.kFeedTypeYouTubeVideo);
			video.save(context);

		}

		// to be implemented - Status: check for possible error

		return data;
	}

	public static Boolean isFacebookVideo(JSONObject dictionary)
			throws JSONException { // chk the arguments, should it be hash map
									// or jsonObj

		Boolean result = true;

		JSONObject jsonObj = dictionary;
		jsonObj = jsonObj.getJSONObject("JSON_obj");

		String type = jsonObj.getString("type");
		String objectID = jsonObj.getString("object_id");

		if (!(type.equals("video"))) {
			result = false;
		}

		if (!(objectID.length() > 0)) {
			result = false;
		}

		// to be implemented - Status: check for possible error

		return result;
	}

	public static Boolean isYoutubeVideo(JSONObject dictionary)
			throws JSONException { // chk the arguments, should it be hash map
									// or jsonObj
		Boolean result = true;

		JSONObject jsonObj = dictionary;
		jsonObj = jsonObj.getJSONObject("JSON_obj");

		String type = jsonObj.getString("type");
		String objectID = jsonObj.getString("object_id");

		if (!(type.equals("video"))) {
			result = false;
		}

		if (!(objectID.length() > 0)) { // chk this with obj-C code
			result = false;
		}

		// to be implemented - Status: check for possible error

		return result;
	}

	public static Boolean isFacebookLink(JSONObject dictionary)
			throws JSONException { // chk the arguments, should it be hash map
									// or jsonObj
		Boolean result = true;

		JSONObject jsonObj = dictionary;
		jsonObj = jsonObj.getJSONObject("JSON_obj");

		String type = jsonObj.getString("type");
		String objectID = jsonObj.getString("object_id");

		if (!(type.equals("photo"))) {
			result = false;
		}

		if (!(objectID.length() > 0)) {
			result = false;
		}

		// to be implemented - Status: check for possible error

		return result;
	}

}
