package com.Receiver;

import com.SelCanbus.SelCanbusService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
	private static final String action_boot = "android.intent.action.BOOT_COMPLETED";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("Canbus", intent.getAction());
		if (intent.getAction().equals(action_boot)) {
			Log.d("Canbus startService", action_boot);
			Intent mBootIntent = new Intent(context, SelCanbusService.class);
			mBootIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startService(mBootIntent);
		}
	}
}
