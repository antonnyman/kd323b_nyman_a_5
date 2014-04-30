package se.antonnyman.kd323b_nyman_a_assignment5;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

	Button button;
	String formattedDate;
	private long[] vibration = {1000}; 
	Calendar c = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		button = (Button) findViewById(R.id.button);
		final EditText titleEditText = (EditText) findViewById(R.id.editTextTitle);
		final EditText contentEditText = (EditText) findViewById(R.id.editTextContent);
		formattedDate = sdf.format(c.getTime());
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(titleEditText.getText().length() != 0 && contentEditText.getText().length() != 0) {
					showCustomNotification(titleEditText.getText().toString(), contentEditText.getText().toString());
					Toast.makeText(MainActivity.this, "Showing notification!", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(MainActivity.this, "Fill out both fields!", Toast.LENGTH_SHORT).show();
				}

			
			}
		});
	
	}
	
	
	public void showCustomNotification(String title, String content){
		RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.notification_custom_remote);
		remoteViews.setTextViewText(R.id.notification_custom_remote_title, title);
		remoteViews.setTextViewText(R.id.notification_custom_remote_content, content);
		remoteViews.setTextViewText(R.id.notification_custon_remote_when, formattedDate);
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification.Builder(this).setVibrate(vibration).setSmallIcon(R.drawable.ic_launcher).build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.bigContentView = remoteViews;
		notificationManager.notify(0, notification);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
