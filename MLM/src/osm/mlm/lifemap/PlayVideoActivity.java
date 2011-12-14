package osm.mlm.lifemap;

import com.vendevo.lifemap.R;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
//		String LINK = "http://commonsware.com/misc/test2.3gp";
		
		String LINK = "http://www.ted.com/talks/download/video/8584/talk/761";
		setContentView(R.layout.video_player);
		VideoView videoView = (VideoView) findViewById(R.id.videoplayerView);
		MediaController mc = new MediaController(this);
		mc.setAnchorView(videoView);
		mc.setMediaPlayer(videoView);
		Uri video = Uri.parse(LINK);
		videoView.setMediaController(mc);
		videoView.setVideoURI(video);
		videoView.start();
		
		
	}

}
