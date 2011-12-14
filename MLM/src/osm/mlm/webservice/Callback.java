package osm.mlm.webservice;

import java.util.ArrayList;
import java.util.Arrays;

import com.orm.androrm.Model;
import com.orm.androrm.QuerySet;

import osm.mlm.model.LifemapBase;
import osm.mlm.model.User;
import osm.mlm.model.base.Photo;
import osm.mlm.model.base.video.FacebookVideo;
import osm.mlm.model.basecontainer.Milestone;
import osm.mlm.model.basecontainer.Yearbook;

public interface Callback {

	public static interface SignUpWithEmailCallback {

		public void signUpSuccessfulWithAccessToken(String token);

		public void signUpFailedWithErrorMessage(String message);
	}

	// login delegate methods
	public interface LoginWithEmailCallback {
		public void logInSuccessfulWithAccessToken(String userToken);

		public void logInFailedWithErrorMessage(String message);
	}

	// create diary delegate methods
	public interface CreateDiaryCallback {
		public void createDiarySuccessfulWithMessage(String message);

		public void createDiaryFailedWithErrorMessage(String message);

	}

	// get all diaries delegate methods
	public interface GetAllDiariesCallback {
		public void getAllDiariesSuccessfulWithDiaries(Arrays diaries);

		public void getAllDiariesFailedWithErrorMessage(String message);
	}

	public interface GetAllDiariesWithStartDateCallback {
		public void getAllDiariesWithStartDateSuccessfulWithDiaries(Arrays diaries);

		public void getAllDiariesWithStartDateFailedWithErrorMessage(String message);
	}

	// get activities delegate methods
	public interface GetActivitiesWithStartDateCallback {
		public void getActivitiesSuccessfulWithActivities(Arrays activites);

		public void getActivitiesFailedWithErrorMessage(String message);
	}
	
	public interface GetActivitiesWithIdentifierCallback {
		public void getActivitiesSuccessfulWithActivities(ArrayList<LifemapBase> datas);

		public void getActivitiesFailedWithErrorMessage(String message);
	}

	// get all yearbooks delegate methods
	public interface GetAllYearbooksCallback {
		public void getAllYearbooksSuccessfulWithYearbooks(Arrays yearbooks);

		public void getAllYearbooksFailedWithErrorMessage(String message);
	}

	// get single yearbook delegate methods
	public interface GetSingleYearbookCallback {
		public void getSingleYearbookSuccessfulWithYearbook(Yearbook yearbooks);

		public void getSingleYearbookFailedWithErrorMessage(String message);
	}

	// create yearbook delegate methods
	public interface CreateSingleYearbookWithTitleCallback {
		public void createYearbookSuccessfulWithYearbookID(String ID);

		public void createYearbookFailedWithErrorMessage(String message);
	}

	// update yearbook delegate methods
	public interface UpdateYearbookWithIDCallback {
		public void updateYearbookSuccessfulWithMessage(String message);

		public void updateYearbookFailedWithErrorMessage(String message);
	}

	// delete yearbook delegate methods
	public interface DeleteYearbookWithIDCallback {
		public void deleteYearbookSuccessfulWithMessage(String message);

		public void deleteYearbookFailedWithErrorMessage(String message);
	}

	// get all milestones delegate methods
	public interface GetAllMilestonesCallback {
		public void getAllMilestonesSuccessfulWithMilestones(Arrays milestones);

		public void getAllMilestonesFailedWithErrorMessage(String message);
	}

	// get single milestone delegate methods
	public interface GetSingleMilestoneCallback {
		public void getSingleMilestoneSuccessfulWithMilestone(
				Milestone milestone);

		public void getSingleMilestoneFailedWithErrorMessage(String message);
	}

	// create milestone delegate methods
	public interface CreateMilestoneWithTitleCallback {
		public void createMilestoneSuccessfulWithMilestoneID(String ID);

		public void createMilestoneFailedWithErrorMessage(String message);
	}

	// update milestone delegate methods
	public interface UpdateMilestoneWithIDCallback {
		public void updateMilestoneSuccessfulWithMessage(String message);

		public void updateMilestoneFailedWithErrorMessage(String message);
	}

	// delete milestone delegate methods
	public interface DeleteMilestoneWithIDCallback {
		public void deleteMilestoneSuccessfulWithMessage(String message);

		public void deleteMilestoneFailedWithErrorMessage(String message);
	}

	// update status delegate methods
	public interface UpdateStatusCallback {
		public void updateStatusSuccessfulWithMessage(String message);

		public void updateStatusFailedWithErrorMessage(String message);
	}

	// upload link delegate methods
	public interface UploadLinkWithUrlCallback {
		public void uploadLinkSuccessfulWithMessage(String message);

		public void uploadLinkFailedWithErrorMessage(String message);
	}

	// get User Info delegate methods
	public interface GetUserInfoCallback {
		public void getUserInfoSuccessfulWithUser(User user);

		public void getUserInfoFailedWithErrorMessage(String message);
	}

	// upload video delegate methods
	public interface UploadVideoWithFilePathCallback {
		public void uploadVideoSuccessfulWithMessage(String message);

		public void uploadVideoFailedWithErrorMessage(String message);
	}

	public interface UploadVideoWithVideoDataCallback {
		public void uploadVideoSuccessfulWithMessage(String message);

		public void uploadVideoFailedWithErrorMessage(String message);
	}

	// upload photo delegate methods
	public interface UploadPhotoCallback {
		public void uploadPhotoSuccessfulWithMessage(String message);

		public void uploadPhotoFailedWithErrorMessage(String message);
	}

	// get facebook video delegate methods
	public interface GetFacebookVideoUrlWithVideoCallback {
		public void getFacebookVideoSuccessfulWithURL(FacebookVideo fbVideo);

		public void getFacebookVideoFailedWithErrorMessage(String message);
	}
	
	// get photos delegate methods
	public interface GetAllPhotosWithStartDateCallBack{
		public void getAllPhotosWithStartDateSuccessfulWithMessage(QuerySet<Photo> photos);
		public void getAllPhotosWithStartDateFailedWithErrorMessage(String message);
	}
	
	public interface GetLifeMapPhotosWithStartDateCallBack{
		public void getLifeMapPhotosWithStartDateSuccessfulWithMessage(QuerySet<Photo> photos);
		public void getLifeMapPhotosWithStartDateFailedWithErrorMessage(String message);
	}
	
	public interface GetFacebookPhotosWithStartDateCallBack{
		public void getFacebookPhotosWithStartDateSuccessfulWithMessage(QuerySet<Photo> photos);
		public void getFacebookPhotosWithStartDateFailedWithErrorMessage(String message);
	}
	
	public interface GetFlickerPhotosWithStartDateCallBack{
		public void getFlickerPhotosWithStartDateSuccessfulWithMessage(QuerySet<Photo> photos);
		public void getFlickerPhotosWithStartDateFailedWithErrorMessage(String message);
	}
	
	// get videos delegate methods
	public interface GetAllVideosWithStartDateCallBack{
		public void getAllVideosWithStartDateSuccessfulWithMessage(Arrays activites);
		public void getAllVideosWithStartDateFailedWithErrorMessage(String message);
	}
	public interface GetMilifemapVideosWithStartDateCallBack{
		public void getMilifemapVideosWithStartDateSuccessfulWithMessage(QuerySet<Photo> photos);
		public void getMilifemapVideosWithStartDateFailedWithErrorMessage(String message);
	}
	
	public interface GetFacebookVideosWithStartDateCallBack{
		public void getFacebookVideosWithStartDateSuccessfulWithMessage(Arrays activites);
		public void getFacebookVideosWithStartDateFailedWithErrorMessage(String message);
	}
	
	public interface GetFlickrVideosWithStartDateCallBack{
		public void getFlickrVideosWithStartDateSuccessfulWithMessage(Arrays activites);
		public void getFlickrVideosWithStartDateFailedWithErrorMessage(String message);
	}
	

}
