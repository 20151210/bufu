package com.Const;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;

import com.SelCanbus.R;

public class Canbus {

	private String[] companyList;
	private String[][] carTypeList;

	public Canbus(Context context) {
		initData(context);
	}

	private void initData(Context context) {

		try {
			Resources res = context.getResources();
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
	}
	
	
	public String[] getCompanyList(){
		return this.companyList;
	}
	
	public String[] getCarTypeList(int position){
		return this.carTypeList[position];
	}
	
	public int getCarCode(int position1,int position2){
		int carId=0;
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
}
