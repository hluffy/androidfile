package com.dk;

import com.dk.object.FileHelper;
import com.dk.object.LogoutData;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
	private Notification notify1;
	private static final int NOTIFYID_1 = 1;
	private String fileNameData = "data.txt";
	private String fileNameState = "state.txt";
	private Button myButton;
	private Context context;
	private Button myTest;
	private NotificationManager manager;
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
		myTest = (Button)findViewById(R.id.myTest);
		manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
		myButton.setOnClickListener(this);
		myTest.setOnClickListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
//		FileHelper fileHelper = new FileHelper(context);
//		fileHelper.save(fileNameData, null);
		switch (v.getId()) {
		case R.id.logoutButton:
			System.out.println("mybutton");
			FileHelper fileHelper = new FileHelper(context);
			fileHelper.save(fileNameState, "false");
			Intent intent = new Intent();
			intent.setClass(this, LoginActivity.class);
			startActivity(intent);
			break;
			
		case R.id.myTest:
			Intent it = new Intent(this, LoginActivity.class);
            PendingIntent pit = PendingIntent.getActivity(this, 0, it, 0);
            Notification.Builder mBuilder = new Notification.Builder(AndroidfileActivity.this);
            mBuilder.setContentTitle("叶良辰")                        //标题
            .setContentText("我有一百种方法让你呆不下去~")      //内容
            .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
            .setWhen(System.currentTimeMillis()+50000)           //设置通知时间
//            .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
            .setAutoCancel(true);                    //设置点击后取消Notification
//            .setContentIntent(pit);                        //设置PendingIntent

            notify1 = mBuilder.getNotification();
            manager.notify(NOTIFYID_1, notify1);
		default:
			break;
		}
		
		
	}
}