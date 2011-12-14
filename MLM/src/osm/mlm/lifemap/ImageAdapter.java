package osm.mlm.lifemap;
//package com.vendevo.lifemap;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//
//import com.vendevo.lifemap.gallery.Constants;
//
//public class ImageAdapter extends BaseAdapter {
//	private Context mContext;
//	private String[] mPhotoList;
//	public ImageAdapter(Context c, String[] photoList) {
//        mContext = c;
//        mPhotoList = photoList;
//    }
//
//    public int getCount() {
//        return mPhotoList.length;
//    }
//
//    public Object getItem(int position) {
//        return position;
//    }
//
//    public long getItemId(int position) {
//        return position;
//    }
//
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//    	
//        ImageView imageView = new ImageView(mContext);
////        if (convertView == null) {
////            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
//            imageView.setAdjustViewBounds(true);
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setPadding(2, 2, 2, 2);
////        } else {
////            imageView = (ImageView) convertView;
////        }
////        Log.v(TAG,"EFEFEFEFEFEFEFEFEFEFEFEFEFEF");
//        Bitmap bitmap = Constants.downloadFile(mPhotoList[position]);
////        Log.v(TAG,"TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//        imageView.setImageBitmap(bitmap);
////        Log.v(TAG,"GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
//        
//        return imageView;
//    }
//}