package osm.mlm.model;

import java.util.Arrays;

public class Constants {
	
	//public static final String BASE_URL ="http://alpha-1.milifemap.com";
	public static final String BASE_URL ="http://ec2-50-17-219-153.compute-1.amazonaws.com";



	//Response keys
	public static final String RESULT_KEY ="result";
	public static final String RESPONSE_FAIL ="Failure";
	public static final String MESSAGE_KEY ="message";
	public static String USER_TOKEN=null;
	//Asset types
	public static final String kAssetTypeKey ="asset_type";
	
	public static final String kFeedTypeKey ="feed_lookupType";
	public static final String kFeedTypeLifeMapPhoto ="Lifemap_Photo";
	public static final String kFeedTypeFaceBookPhoto ="Facebook_Photo";
	public static final String kFeedTypeFlickerPhoto ="Flickr_Photo";

	public static final String kFeedTypeLifeMapVideo ="Lifemap_Video";
	public static final String kFeedTypeFaceBookVideo ="Facebook_Video";
	public static final String kFeedTypeYouTubeVideo ="Youtube_Video";
	public static final String kFeedTypeFlickerVideo ="Flickr_Video";



	public static final String kFeedTypeLifeMapDiary ="Lifemap_Diary";
	public static final String kFeedTypeFourSquareCheckIn ="Foursquare_Checkin";

	public static final String kFeedTypeLifeMapStatus ="Lifemap_Status";
	public static final String kFeedTypeFaceBookStatus ="Facebook_Status";
	public static final String kFeedTypeTwitterStatus ="Twitter_Status";

	public static final String kFeedTypeLifeMapLink ="Lifemap_Link";
	public static final String kFeedTypeFaceBookLink ="Facebook_Link"; /*This can futher point to Facebok video, youtube video, and simple URL*/



	public static final String kUploadTypeVideo ="Video";
	public static final String kUploadTypePhoto ="Photo";


	//Activity lookup IDs
	public static final String DIARY ="5";
	public static final String SHARE_INFO ="6";
	public static final String MILIFEMAP_FILE ="7";
	public static final String MILIFEMAP_STATUS ="8";
	public static final String MILIFEMAP_LINK ="9";
	public static final String MILIFEMAP_PHOTO ="10";
	public static final String MILIFEMAP_VIDEO ="11";
	public static final String SOCIAL_CONNECTION ="12";
	public static final String FACEBOOK_USERINFO ="13";
	public static final String FACEBOOK_INBOX ="14";
	public static final String FACEBOOK_OUTBOX ="15";
	public static final String FACEBOOK_STATUS ="16";
	public static final String FACEBOOK_LINK ="17";
	public static final String FACEBOOK_PHOTO ="18";
	public static final String FACEBOOK_VIDEO ="17";
	public static final String FACEBOOK_EVENT ="19";
	public static final String FACEBOOK_NOTE ="20";
	public static final String TWITTER_STATUS ="21";
	public static final String TWITTER_MENTION="22";
	public static final String TWITTER_INBOX ="23";
	public static final String TWITTER_OUTBOX ="24";
	public static final String FOURSQUARE_CHEKIN ="32";
	public static final String FLICKR_PHOTO ="33";
	public static final String FLICKR_VIDEO ="34";


	//Upload filters
	public static final String kYES ="1";
	public static final String kNO ="0";


	//Discover type
	public static final String kDiscoverTypeMilestone ="milestone";
	public static final String kDiscoverTypeYearbook ="yearbook";


	//TimeLine
	public static final int kEND_OF_TIMES_YEAR =1900;
	public static final String[] kMONTHS_ARRAY ={"January","February", "March","April","May","June","July","August","September","October","November","December"};


	//Notifications
	public static final String kNewDiaryAdded ="kNewDiaryAdded";
	public static final String kNewMilestoneAdded ="kNewMilestoneAdded";
	public static final String kNewYearbookAdded ="kNewYearbookAdded";
}
