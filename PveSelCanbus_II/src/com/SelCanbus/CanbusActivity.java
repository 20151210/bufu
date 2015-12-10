package com.SelCanbus;

import java.util.List;

import com.Const.Canbus;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CanbusActivity extends Activity {

	private Spinner companySpin, carTypeSpin;
	private Button btnSub;
	ArrayAdapter<String> companyAdapter = null;
	ArrayAdapter<String> carAdapter = null;

	static int companyPosition = 0;
	static int carTypePosition = 0;
	private static int COMPANY_COUNT = 7;

	private  Canbus mCanbus=null;
	
	private String[] companyList = new String[COMPANY_COUNT];
	private String[][] carTypeList = new String[COMPANY_COUNT][];

	private SharedPreferences sp = null;
	private Editor editor = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

		setContentView(R.layout.activity_main);
		Intent intent = new Intent(getApplicationContext(),
				SelCanbusService.class);
		startService(intent);
		
		mCanbus=new Canbus(CanbusActivity.this);

		sp = getSharedPreferences("PVE_CANBUS_SEL", Context.MODE_PRIVATE);
		editor = sp.edit();
		initView();
	}

	@Override
	protected void onStart() {

		companyPosition = sp.getInt("SEL_COMPANY", 0);
		carTypePosition = sp.getInt("SEL_CAR", 0);

		super.onStart();
	}

	private void initView() {

		try {
			Resources res = this.getResources();
			companyList = res.getStringArray(R.array.company_list);
			carTypeList = new String[][] { res.getStringArray(R.array.toyota),
					res.getStringArray(R.array.volkswagen),
					res.getStringArray(R.array.honda),
					res.getStringArray(R.array.nissan),
					res.getStringArray(R.array.hyundai),
					res.getStringArray(R.array.zotye),
					res.getStringArray(R.array.gac),
					res.getStringArray(R.array.citroen),
					res.getStringArray(R.array.sgmw),
					res.getStringArray(R.array.jeep),
					res.getStringArray(R.array.mazda),
					res.getStringArray(R.array.faw) };

		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		btnSub = (Button) findViewById(R.id.button1);

		companySpin = (Spinner) findViewById(R.id.spinner1);
		carTypeSpin = (Spinner) findViewById(R.id.spinner2);

		companyAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mCanbus.getCompanyList());
		companyAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		companySpin.setAdapter(companyAdapter);
		companySpin.setSelection(companyPosition, true);

		carAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item,
				mCanbus.getCarTypeList(companyPosition));
		carAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		carTypeSpin.setAdapter(carAdapter);
		carTypeSpin.setSelection(carTypePosition, true);

		companySpin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				carAdapter = new ArrayAdapter<String>(CanbusActivity.this,
						android.R.layout.simple_spinner_item, carTypeList[arg2]);
				carAdapter
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				carTypeSpin.setAdapter(carAdapter);
				carTypeSpin.setSelection(0, true);
				companyPosition = arg2;

				// Editor editor = sp.edit();
				editor.putInt("SEL_COMPANY", companyPosition);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		carTypeSpin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				carTypePosition = arg2;
				editor.putInt("SEL_CAR", carTypePosition);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

		btnSub.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				int carId = getCarId(companyPosition, carTypePosition);
				// if(isServiceRunning(CanbusActivity.this,"SelCanbusService")){
				//
				// };
				
				int carId=mCanbus.getCarCode(companyPosition, carTypePosition);

				new SelCanbusImpl().setSelCanbus(carId);

				Log.d("CanbusActivity**sbm", "carId==" + carId);
				android.provider.Settings.System.putInt(getContentResolver(),
						"canbus_version", carId);

			}
		});
	}

	private int getCarId(int position1, int position2) {
		int carId = 0;
		switch (position1) {
		case 0:
			carId = 49;
			break;
		case 1:
			if (position2 <= 2)
				carId = 50;
			else
				carId = 51;
			break;
		case 2:
			if (position2 <= 3)
				carId = 56;
			else
				carId = 52;
			break;
		case 3:
			if (position2 < 1)
				carId = 0;// qijun
			else
				carId = 53;
			break;
		case 4:
			if (position2 <= 1)
				carId = 54;
			else
				carId = 70;
			break;
		case 5:
			carId = 65;
			break;
		case 7:
			if (position1 < 1)
				carId = 66;
			else
				carId = 69;
			break;
		case 8:
			carId = 55;
			break;
		case 9:
			carId = 65;
			break;
		case 10:
			if (position1 <= 2)
				carId = 67;
			else
				carId = 71;
			break;
		case 11:
			carId = 72;
			break;
		case 12:
			carId = 73;
			break;
		case 13:
			carId = 68;
			break;

		default:
			break;
		}

		return carId;
	}

	public static boolean isServiceRunning(Context mContext, String className) {

		boolean isRunning = false;
		ActivityManager activityManager = (ActivityManager) mContext
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> serviceList = activityManager
				.getRunningServices(30);

		if (!(serviceList.size() > 0)) {
			return false;
		}

		for (int i = 0; i < serviceList.size(); i++) {
			if (serviceList.get(i).service.getClassName().equals(className) == true) {
				isRunning = true;
				break;
			}
		}
		return isRunning;
	}
}
