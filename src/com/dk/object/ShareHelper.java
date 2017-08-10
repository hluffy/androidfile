package com.dk.object;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ShareHelper {
	private Context context;
	
	public ShareHelper(){
		
	}
	public ShareHelper(Context context){
		this.context = context;
	}
	
	public void save(String username,String password){
		SharedPreferences sp = context.getSharedPreferences("mysq", Context.MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.putString("username", username);
		edit.putString("password", password);
		edit.commit();
		
	}
	
	public Map<String,String> read(){
		Map<String,String> data = new HashMap<String,String>();
		SharedPreferences sp = context.getSharedPreferences("mysq", Context.MODE_PRIVATE);
		data.put("username", sp.getString("username", ""));
		data.put("password", sp.getString("password", ""));
		return data;
	}

}
