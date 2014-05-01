package se.antonnyman.kd323b_nyman_a_assignment5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static String		sPackageName;
	private Button 				mButton;
	private String 				mFormattedDate;
	private ArrayList<NewsItem> newsList = new ArrayList<NewsItem>();
	private Calendar 			mCalendar = Calendar.getInstance();
	private SimpleDateFormat 	mSimpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
	private int					mRandom;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		mButton = (Button) findViewById(R.id.button);
		mFormattedDate = mSimpleDateFormat.format(mCalendar.getTime());
		
		createNewsItemList();
		
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mRandom = 0 + (int)(Math.random() * ((9 - 0) + 1));
				showCustomNotification(newsList.get(mRandom));
				Toast.makeText(MainActivity.this, mRandom + "", Toast.LENGTH_SHORT).show();	
			}
		
		});
	
	}
	
	
	public void showCustomNotification(NewsItem newsItem){
		RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.notification_custom_remote);
		remoteViews.setTextViewText(R.id.notification_custom_remote_title, newsItem.getTitle());
		remoteViews.setTextViewText(R.id.notification_custom_remote_content, newsItem.getSummary());
		remoteViews.setTextViewText(R.id.notification_custon_remote_when, mFormattedDate);
		remoteViews.setImageViewResource(R.id.imageView, newsItem.getImage());
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification.Builder(this).setSmallIcon(R.drawable.ic_launcher).build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.bigContentView = remoteViews;
		notificationManager.notify(0, notification);
	}
	
	private ArrayList<NewsItem> createNewsItemList() {
			newsList.add(new NewsItem("Alchemist", getString(R.string.alchemist).substring(0, 150) + "...", R.drawable.alchemist_vert));
			newsList.add(new NewsItem("Bristleback", getString(R.string.bristleback).substring(0, 150) + "...", R.drawable.bristleback_vert));
			newsList.add(new NewsItem("Dazzle", getString(R.string.dazzle).substring(0, 150) + "...", R.drawable.dazzle_vert));
			newsList.add(new NewsItem("Earthshaker", getString(R.string.earthshaker).substring(0, 150) + "...", R.drawable.earthshaker_vert));
			newsList.add(new NewsItem("Ember Spirit", getString(R.string.ember_spirit).substring(0, 150) + "...", R.drawable.ember_spirit_vert));
			newsList.add(new NewsItem("Luna", getString(R.string.luna).substring(0, 150) + "...", R.drawable.luna_vert));
			newsList.add(new NewsItem("Mirana", getString(R.string.mirana).substring(0, 150) + "...", R.drawable.mirana_vert));
			newsList.add(new NewsItem("Omniknight", getString(R.string.omniknight).substring(0, 150) + "...", R.drawable.omniknight_vert));
			newsList.add(new NewsItem("Puck", getString(R.string.puck).substring(0, 150) + "...", R.drawable.puck_vert));
			newsList.add(new NewsItem("Clockwerk", getString(R.string.rattletrap).substring(0, 150) + "...", R.drawable.rattletrap_vert));
		return newsList;
	}


}
