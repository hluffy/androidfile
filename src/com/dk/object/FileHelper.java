package com.dk.object;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.content.Context;

public class FileHelper {
	private Context context;
	
	public FileHelper(){
		
	}
	
	public FileHelper(Context context){
		this.context = context;
	}
	
	public void save(String fileName,String contentData){
		FileOutputStream fos;
		try {
			fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			fos.write(contentData.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String read(String fileName){
		FileInputStream input = null;
		StringBuffer sb = new StringBuffer();
		try {
			input = context.openFileInput(fileName);
			 byte[] temp = new byte[1024];
			 int len = 0;
			 while((len=input.read(temp))>0){
				 sb.append(new String(temp,0,len));
			 }
			 input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
		
	}

}
