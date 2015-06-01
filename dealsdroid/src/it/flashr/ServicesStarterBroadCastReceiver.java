package it.flashr;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;

public class ServicesStarterBroadCastReceiver extends BroadcastReceiver {
	/**
	 * @see android.content.BroadcastReceiver#onReceive(Context,Intent)
	 */
	
	
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		//Intent service1Intent = new Intent();
		//service1Intent.setAction(".LocationUpdateService");
		//context.startService(service1Intent);
	
	
	
		//Starts a service (task to be accomplished in the background, without UI)
		//The class employing the snippet code must implement ServiceConnection
		Intent iServ = new Intent();
		System.out.println("**********Brodcast started**********************");
		iServ.setClass(context, LocationUpdateService.class); //TODO Replace 'ServiceName' with the class name for your Service
		context.startService(iServ);
	
	}
	
	
	
	
	
	
}
