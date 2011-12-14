package osm.mlm.lifemap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import osm.mlm.gallery.Constants;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

public class SDCardIO {

	public static void saveToSDCard(String fileName,Bitmap bitmap){
		
		File f = null;
		f = new File(Constants.folderPath);
		if(!f.exists()){
			
			boolean retValue = f.mkdir();
			Log.v("Directory: ",""+retValue);
		}
		File myFile = new File(Constants.folderPath+"/"+fileName+".bmp");
		Log.v("saveToSdCard function ","filename with which to save: "+myFile.getName());
		try {
			FileOutputStream outStream = new FileOutputStream(myFile);
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
//			bitmap.
		   
		   outStream.flush();
		   outStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public static boolean fileExists(String fileName){
	
		File f=null;
		File[] files = null;
		f = new File(Constants.folderPath);
		if(!f.exists()){
			f.mkdir();
		}
		
		files = f.listFiles();
		
		for (File aFile : files) {
			if(aFile.getName().equals( fileName+".bmp")){
				Log.v("filename from sdcard: ", aFile.getName());
				Log.v("filename passed: ", fileName);
				return true;
			}
			else{
				Log.v("fileExists function", "else PART :");
				Log.v("filename from sdcard: ", aFile.getName());
				Log.v("filename passed: ", fileName);
				
			}
		}
		return false;
	}
	
	public static Bitmap getFromSDCard(String fileName){
		fileName += ".bmp";
		Log.v("getFromSDCard function : ", "filename :" + fileName);
		return BitmapFactory.decodeFile(Constants.folderPath+"/"+fileName);
	}
	

}
