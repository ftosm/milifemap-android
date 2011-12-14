package osm.mlm.gallery;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

public class Constants {
	static Bitmap bmImg;
	public static final String folderPath = Environment.getExternalStorageDirectory().toString() + "/MiLifeMap";
    public static Bitmap downloadFile(String fileUrl){
    	
    	URL myFileUrl =null;          
        try {
             myFileUrl= new URL(fileUrl);
        } catch (MalformedURLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }
        try {
             HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
             conn.setDoInput(true);
             conn.connect();
             InputStream is = conn.getInputStream();
             
             bmImg = BitmapFactory.decodeStream(is);
             
        } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }
        
		
		return bmImg;
   }
    
	public static String extractFileName(String fileURL){
		
		String [] filenameComponents = fileURL.split("/");
		Log.v("last image name: ", filenameComponents[filenameComponents.length-1]);
		
		return filenameComponents[filenameComponents.length-1];
	}
}
