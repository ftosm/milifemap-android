package osm.mlm.model.base;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import osm.mlm.model.Constants;
import osm.mlm.model.LifemapBase;
import osm.mlm.model.MLMActivity;

import android.content.Context;

import com.orm.androrm.CharField;
import com.orm.androrm.ForeignKeyField;
import com.orm.androrm.Model;
import com.orm.androrm.QuerySet;

public class Video extends Model {

	protected CharField _embeddedHtml;
	protected CharField _originalUrl;
	protected CharField _text;
	protected CharField _thumbnailUrl;
	protected CharField _videoID;
	protected CharField _videoType;

	protected ForeignKeyField<LifemapBase> _lifemapBase;

	public Video() throws JSONException {
		super();

		_embeddedHtml = new CharField();
		_originalUrl = new CharField();
		_text = new CharField();
		_thumbnailUrl = new CharField();
		_videoType = new CharField();

		_lifemapBase = new ForeignKeyField<LifemapBase>(LifemapBase.class);
	}

	public void setupWithJSON(JSONObject dictionary, LifemapBase lifemapBase,
			String videoType) throws JSONException {

		String jsonObjString = dictionary.getString("JSON_obj");
		JSONObject jsonObj = new JSONObject(jsonObjString);

		if (videoType.equals(Constants.kFeedTypeYouTubeVideo)) {

			setOriginalUrl(jsonObj.getString("source"));
			setText(jsonObj.getString("story"));
			setThumbnailUrl(jsonObj.getString("picture"));

			if (!(jsonObj.getString("added_text") == null)) {
				setText(jsonObj.getString("added_text"));
			}

			// Construct the embebded html
			updateWithVideoUrl(getOriginalUrl());
		} else if (videoType.equals(Constants.kFeedTypeLifeMapVideo)) {

			setText(jsonObj.getString("text"));
			setThumbnailUrl(jsonObj.getString("screenshot"));
			setOriginalUrl(jsonObj.getString("filename"));
		}

		else if (videoType.equals(Constants.kFeedTypeFlickerVideo)) {

			JSONArray jsonArray = jsonObj.getJSONObject("source_url")
					.getJSONObject("sizes").getJSONArray("size");

			this.setThumbnailUrl(jsonArray.getJSONObject(1).getString("source"));
			this.setOriginalUrl(jsonArray.getJSONObject(
					(jsonArray.length()) - 1).getString("source"));

		}

		else if (videoType.equals(Constants.kFeedTypeFaceBookVideo)) {

			setVideoID(jsonObj.getString("object_id"));
			setOriginalUrl(jsonObj.getString("link"));
			setText(jsonObj.getString("message"));
			setThumbnailUrl(jsonObj.getString("picture"));

			if (!(jsonObj.getString("added_text") == null)) {
				setText(jsonObj.getString("added_text"));
			}

			// Construct the embebded html
			updateWithVideoUrl(getOriginalUrl());
		}

		setType(videoType);
		setLifemapBase(lifemapBase);

	}

	public void updateWithVideoUrl(String videoUrl) {

		String path = videoUrl;
		String htmlString = "<html><head> <meta name = \"viewport\" content = \"initial-scale = 1.0, user-scalable = no, width = 212\"/></head> <body style=\"background:#F00;margin-top:0px;margin-left:0px\"> <div><object width=\"320\" height=\"420\"> <param name=\"movie\" value=\"%@\"></param> <param name=\"wmode\" value=\"transparent\"></param> <embed src=\"%@\" type=\"application/x-shockwave-flash\" wmode=\"transparent\" width=\"320\" height=\"420\"></embed> </object></div></body></html>";
		setEmbeddedHtml(String.format(htmlString, path, path)); // check this
																// line of code
																// for string
																// format
		// above line of code will depend on the response of HTML
	}

	public LifemapBase getLifemapBase() {
		return _lifemapBase.get();
	}

	public void setLifemapBase(LifemapBase lifemapBase) {
		_lifemapBase.set(lifemapBase);
	}

	public String getEmbeddedHtml() {
		return _embeddedHtml.toString();
	}

	public void setEmbeddedHtml(String _mEmbeddedHtml) {
		_embeddedHtml.set(_mEmbeddedHtml);
	}

	public String getOriginalUrl() {
		return _originalUrl.get();
	}

	public void setOriginalUrl(String originalUrl) {
		_originalUrl.set(originalUrl);
	}

	public String getText() {
		return _text.toString();
	}

	public void setText(String text) {
		_text.set(text);
	}

	public CharField getThumbnailUrl() {
		return _thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		_thumbnailUrl.set(thumbnailUrl);
	}

	public CharField getVideoID() {
		return _videoID;
	}

	public void setVideoID(String videoID) {
		_videoID.set(videoID);
	}

	public String getType() {
		return _videoType.toString();
	}

	public void setType(String videoType) {
		_videoType.set(videoType);
	}

	public static final QuerySet<Video> objects(Context context) {
		return objects(context, Video.class);
	}
}
