package it.flashr;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

public class LocationUpdateService extends Service {
	
	private Handler mHandler = new Handler();
    public static final int POLLING_PERIOD = 10000;
    public double latitude = 0;
    public double longitude = 0;
    
    private final LocationListener locationListener = new LocationListener() {
    	public void onLocationChanged(Location location) {
    	    latitude = location.getLatitude();
    	    longitude = location.getLongitude();
    	    System.out.println("latitude="+latitude+"longitude="+longitude);
    	}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
    };	
    
    public void showCurrentLocation() {
    	LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    	Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    	lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, locationListener);
    }  
    
    private Runnable periodicTask = new Runnable() {
        public void run() {
        	launchNotification();
        	showCurrentLocation();
            System.out.println("PeriodicTimerService**********************");
            mHandler.postDelayed(periodicTask, POLLING_PERIOD);
        }
    };
	
 
    
    private void launchNotification() {
		 int notificationID = 10;
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// Create the notification
		Notification notification = new Notification(R.drawable.notif, "Test Notification", System.currentTimeMillis());
		// Create the notification's expanded message
		// When the user clicks on it, it opens your activity
		Intent intent = new Intent(this, ActivationActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "Test2", "Test3", pendingIntent);
		// Show notification
		notificationManager.notify(notificationID, notification);
    }
	
	
	
	/**
	 * @see android.app.Service#onBind(Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Put your code here
		return null;
	}

	/**
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		mHandler.postDelayed(periodicTask, POLLING_PERIOD);
		System.out.println("**********Service Created**********************");
	}

	/**
	 * @see android.app.Service#onStart(Intent,int)
	 */
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Put your code here
		System.out.println("**********Service Started**********************");
	}
	
    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(periodicTask);
    }
}
