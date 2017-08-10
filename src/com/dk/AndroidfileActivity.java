package com.dk;

import com.dk.object.FileHelper;
import com.dk.object.LogoutData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class AndroidfileActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
//	private Context context;
	private String fileNameData = "data.txt";
	private String fileNameState = "state.txt";
	private Button myButton;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bindView();
//		context = getApplicationContext();
//		FileHelper fileHelper = new FileHelper(context);
//		String data = fileHelper.read();
//		Toast.makeText(this, data, Toast.LENGTH_LONG).show();
	}
	
	private void bindView(){
		context = getApplicationContext();
		myButton = (Button)findViewById(R.id.logoutButton);
		
		myButton.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
//		FileHelper fileHelper = new FileHelper(context);
//		fileHelper.save(fileNameData, null);
		FileHelper fileHelper = new FileHelper(context);
		fileHelper.save(fileNameState, "false");
		Intent intent = new Intent();
		intent.setClass(this, LoginActivity.class);
		startActivity(intent);
		
	}
}