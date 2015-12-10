package com.SelCanbus;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.Const.SPreference;

public class SelCanbusService extends Service {
	protected SPreference spreference;
	private static Context context;
	private static SelCanbusImpl selImpl = null;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		spreference = new SPreference(this, "Canbus", Context.MODE_PRIVATE);
		context = getApplicationContext();
		selImpl = new SelCanbusImpl();
	}

	public static Context getContext() {
		return context;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		// JniNative jniNative = JniNative.getInstance();
		// jniNative.open();
		// int iCarType = jniNative.getval();

		int iCarType = android.provider.Settings.System.getInt(
				context.getContentResolver(), "canbus_version", 0);
		if (iCarType != 0) {
			selImpl.setSelCanbus(iCarType);
		}
		flags = START_STICKY;
		return super.onStartCommand(intent, flags, startId);
	}

}
