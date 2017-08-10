package com.dk;

import com.dk.object.FileHelper;
import com.dk.object.LogoutData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract.Helpers;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener, OnCheckedChangeListener{
	private String fileNameData = "data.txt";
	private String fileNameState = "state.txt";
	private TextView userName;
	private TextView password;
	private Button myButton;
	private Switch mySwitch;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		buidView();
//		mySwitch.setChecked(true);
		FileHelper fileHelper = new FileHelper(context);
		String data = fileHelper.read(fileNameData);
		String userNameFileString = null;
		String passwordFileString = null;
		if(data!=null&&data.length()!=0){
			String[] strarrayStrings = data.split(",");
			userNameFileString = strarrayStrings[0].split(":")[1];
			passwordFileString = strarrayStrings[1].split(":")[1];
			userName.setText(userNameFileString);
			password.setText(passwordFileString);
		}
		String stateString = fileHelper.read(fileNameState);
		if(stateString!=null&&stateString.length()!=0){
			if(stateString.equals("true")){
				mySwitch.setChecked(true);
			}else{
				mySwitch.setChecked(false);
			}
		}
		
		if(mySwitch.isChecked()&&userNameFileString!=null&&passwordFileString!=null){
			myButton.performClick();
		}
		
		
	}
	
	private void buidView(){
		userName = (TextView)findViewById(R.id.username);
		password = (TextView)findViewById(R.id.password);
		myButton = (Button)findViewById(R.id.myButton);
		mySwitch = (Switch)findViewById(R.id.mySwitch);
		
		context = getApplicationContext();
		
		myButton.setOnClickListener(this);
		mySwitch.setOnCheckedChangeListener(this);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String usernameStr = userName.getText().toString();
		String passwordStr = password.getText().toString();
		if("admin".equals(usernameStr)&&"admin".equals(passwordStr)){
			FileHelper fileHelper = new FileHelper(context);
			String dataString = "admin:"+usernameStr+",passwordStr:"+passwordStr;
			fileHelper.save(fileNameData,dataString);
			Intent intent = new Intent();
			intent.setClass(this, AndroidfileActivity.class);
			startActivity(intent);
		}else {
			Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
		}
		
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		FileHelper fileHelper = new FileHelper(context);
		if(buttonView.isChecked()){
//			Toast.makeText(this, "是", Toast.LENGTH_SHORT).show();
			
			fileHelper.save(fileNameState, "true");
		}else{
//			Toast.makeText(this, "否", Toast.LENGTH_SHORT).show();
			fileHelper.save(fileNameState, "false");
		}
		
	}

}
