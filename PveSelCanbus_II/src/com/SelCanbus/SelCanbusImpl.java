package com.SelCanbus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

import com.Const.CanbusInfo;

public class SelCanbusImpl {

	private static  Context context;
	
	public SelCanbusImpl(){
		context=SelCanbusService.getContext();
	}
	
	public  void setSelCanbus(int iCarType){

		String canbusPkg = selCanbus(iCarType);
		Intent canbusIntent = new Intent();
		ComponentName componentName = new ComponentName(canbusPkg, canbusPkg
				+ CanbusInfo.SERVICE);
		canbusIntent.setComponent(componentName);
		Log.d("Selimpl**sbm", "canbusPkg=="+canbusPkg);
		context.startService(canbusIntent);
	}
	
	private String selCanbus(int iCarType) {
		String canbusPkg = CanbusInfo.STR_VOLKSWAGEN_PQ;
		switch (iCarType) {
		case CanbusInfo.I_TOYOTA:
			canbusPkg = CanbusInfo.STR_TOYOTA;
			break;
		case CanbusInfo.I_VOLKSWAGEN_PQ:
			canbusPkg = CanbusInfo.STR_VOLKSWAGEN_PQ;
			break;
		case CanbusInfo.I_VOLKSWAGEN_MQB:
			canbusPkg = CanbusInfo.STR_VOLKSWAGEN_MQB;
			break;
		case CanbusInfo.I_HONDA_CRV:
			canbusPkg = CanbusInfo.STR_HONDA_CRV;
			break;
		case CanbusInfo.I_NISSAN:
			canbusPkg = CanbusInfo.STR_NISSAN;
			break;
		case CanbusInfo.I_HONDA:
			canbusPkg = CanbusInfo.STR_HONDA;
			break;
		case CanbusInfo.I_RAISE_CITROEN:
			canbusPkg = CanbusInfo.STR_RAISE_CITROEN;
			break;
		case CanbusInfo.I_RAISE_HYUNDAI:
			canbusPkg = CanbusInfo.STR_RAISE_HYUNDAI;
			break;
		case CanbusInfo.I_RAISE_ZOTYE:
			canbusPkg = CanbusInfo.STR_RAISE_ZOTYE;
			break;
		case CanbusInfo.I_RAISE_GAC:
			canbusPkg = CanbusInfo.STR_RAISE_GAC;
			break;
		// ----------2015-07-03-----------
		case CanbusInfo.I_GM:
			canbusPkg = CanbusInfo.STR_GM;
			break;
		case CanbusInfo.I_FAW:
			canbusPkg = CanbusInfo.STR_FAW;
			break;
		case CanbusInfo.I_FIAT:
			canbusPkg = CanbusInfo.STR_FIAT;
			break;
		// ------------------
		case CanbusInfo.I_KIA:
			canbusPkg = CanbusInfo.STR_KIA;
			break;
		case CanbusInfo.I_SGMW:
			canbusPkg = CanbusInfo.STR_SGMW;
			break;
		case CanbusInfo.I_JEEP:
			canbusPkg = CanbusInfo.STR_JEEP;
			break;

		case CanbusInfo.I_MAZDA:
			canbusPkg = CanbusInfo.STR_MAZDA;
			break;
		// ------------------
		default:
			iCarType = CanbusInfo.I_VOLKSWAGEN_PQ;
			canbusPkg = CanbusInfo.STR_VOLKSWAGEN_PQ;
			break;
		}
		uninstall(iCarType);
		install(iCarType);
		return canbusPkg;
	}

	private void uninstall(int iCarType) {
		if (iCarType != CanbusInfo.I_TOYOTA) {
			if (isApkInstalled(CanbusInfo.STR_TOYOTA)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_TOYOTA };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_VOLKSWAGEN_PQ) {
			if (isApkInstalled(CanbusInfo.STR_VOLKSWAGEN_PQ)) {
				String[] args = { "pm", "uninstall",
						CanbusInfo.STR_VOLKSWAGEN_PQ };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_VOLKSWAGEN_MQB) {
			if (isApkInstalled(CanbusInfo.STR_VOLKSWAGEN_MQB)) {
				String[] args = { "pm", "uninstall",
						CanbusInfo.STR_VOLKSWAGEN_MQB };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_HONDA) {
			if (isApkInstalled(CanbusInfo.STR_HONDA)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_HONDA };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_NISSAN) {
			if (isApkInstalled(CanbusInfo.STR_NISSAN)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_NISSAN };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_HONDA_CRV) {
			if (isApkInstalled(CanbusInfo.STR_HONDA_CRV)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_HONDA_CRV };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_RAISE_CITROEN) {
			if (isApkInstalled(CanbusInfo.STR_RAISE_CITROEN)) {
				String[] args = { "pm", "uninstall",
						CanbusInfo.STR_RAISE_CITROEN };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_RAISE_HYUNDAI) {
			if (isApkInstalled(CanbusInfo.STR_RAISE_HYUNDAI)) {
				String[] args = { "pm", "uninstall",
						CanbusInfo.STR_RAISE_HYUNDAI };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_RAISE_GAC) {
			if (isApkInstalled(CanbusInfo.STR_RAISE_GAC)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_RAISE_GAC };
				silentExec(args);
			}
		}

		if (iCarType != CanbusInfo.I_RAISE_ZOTYE) {
			if (isApkInstalled(CanbusInfo.STR_RAISE_ZOTYE)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_RAISE_ZOTYE };
				silentExec(args);
			}
		}

		// -------------------------------
		if (iCarType != CanbusInfo.I_GM) {
			if (isApkInstalled(CanbusInfo.STR_GM)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_GM };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_FAW) {
			if (isApkInstalled(CanbusInfo.STR_FAW)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_FAW };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_FIAT) {
			if (isApkInstalled(CanbusInfo.STR_FIAT)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_FIAT };
				silentExec(args);
			}
		}
		// -----------------------------------------------------
		if (iCarType != CanbusInfo.I_KIA) {
			if (isApkInstalled(CanbusInfo.STR_KIA)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_KIA };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_SGMW) {
			if (isApkInstalled(CanbusInfo.STR_SGMW)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_SGMW };
				silentExec(args);
			}
		}
		if (iCarType != CanbusInfo.I_JEEP) {
			if (isApkInstalled(CanbusInfo.STR_JEEP)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_JEEP };
				silentExec(args);
			}
		}

		if (iCarType != CanbusInfo.I_MAZDA) {
			if (isApkInstalled(CanbusInfo.STR_MAZDA)) {
				String[] args = { "pm", "uninstall", CanbusInfo.STR_MAZDA };
				silentExec(args);
			}
		}

	}

	private void install(int iCarType) {
		if (iCarType == CanbusInfo.I_TOYOTA) {
			if (!isApkInstalled(CanbusInfo.STR_TOYOTA)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_TOYOTA_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_TOYOTA);
			}
		} else if (iCarType == CanbusInfo.I_VOLKSWAGEN_PQ) {
			if (!isApkInstalled(CanbusInfo.STR_VOLKSWAGEN_PQ)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_VOLKSWAGEN_PQ_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_VOLKSWAGEN_PQ);
			}
		} else if (iCarType == CanbusInfo.I_VOLKSWAGEN_MQB) {
			if (!isApkInstalled(CanbusInfo.STR_VOLKSWAGEN_MQB)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_VOLKSWAGEN_MQB_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_VOLKSWAGEN_MQB);
			}
		} else if (iCarType == CanbusInfo.I_HONDA) {
			if (!isApkInstalled(CanbusInfo.STR_HONDA)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_HONDA_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_HONDA);
			}
		} else if (iCarType == CanbusInfo.I_NISSAN) {
			if (!isApkInstalled(CanbusInfo.STR_NISSAN)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_NISSAN_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_NISSAN);
			}
		} else if (iCarType == CanbusInfo.I_HONDA_CRV) {
			if (!isApkInstalled(CanbusInfo.STR_HONDA_CRV)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_HONDA_CRV_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_HONDA_CRV);
			}
		} else if (iCarType == CanbusInfo.I_RAISE_CITROEN) {
			if (!isApkInstalled(CanbusInfo.STR_RAISE_CITROEN)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_RAISE_CITROEN_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_RAISE_CITROEN);
			}
		} else if (iCarType == CanbusInfo.I_RAISE_HYUNDAI) {
			if (!isApkInstalled(CanbusInfo.STR_RAISE_HYUNDAI)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_RAISE_HYUNDAI_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_RAISE_HYUNDAI);
			}
		} else if (iCarType == CanbusInfo.I_RAISE_GAC) {
			if (!isApkInstalled(CanbusInfo.STR_RAISE_GAC)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_RAISE_GAC_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_RAISE_GAC);
			}
		} else if (iCarType == CanbusInfo.I_RAISE_ZOTYE) {
			if (!isApkInstalled(CanbusInfo.STR_RAISE_ZOTYE)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_RAISE_ZOTYE_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_RAISE_ZOTYE);
			}
		} else if (iCarType == CanbusInfo.I_GM) {
			if (!isApkInstalled(CanbusInfo.STR_GM)) {
				String[] args = { "pm", "install", "-f", CanbusInfo.STR_GM_PAHT };
				silentExec(args);
				runApk(CanbusInfo.STR_GM);
			}
		} else if (iCarType == CanbusInfo.I_FAW) {
			if (!isApkInstalled(CanbusInfo.STR_FAW)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_FAW_PAHT };
				silentExec(args);
				runApk(CanbusInfo.STR_FAW);
			}

		} else if (iCarType == CanbusInfo.I_FIAT) {
			if (!isApkInstalled(CanbusInfo.STR_FIAT)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_FIAT_PAHT };
				silentExec(args);
				runApk(CanbusInfo.STR_FIAT);
			}
		} else if (iCarType == CanbusInfo.I_KIA) {
			if (!isApkInstalled(CanbusInfo.STR_KIA)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_KIA_PAHT };
				silentExec(args);
				runApk(CanbusInfo.STR_KIA);
			}

		} else if (iCarType == CanbusInfo.I_SGMW) {
			if (!isApkInstalled(CanbusInfo.STR_SGMW)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_SGMW_PAHT };
				silentExec(args);
				runApk(CanbusInfo.STR_SGMW);
			}

		} else if (iCarType == CanbusInfo.I_JEEP) {
			if (!isApkInstalled(CanbusInfo.STR_JEEP)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_JEEP_PAHT };
				silentExec(args);
				runApk(CanbusInfo.STR_JEEP);
			}
		} else if (iCarType == CanbusInfo.I_MAZDA) {

			if (!isApkInstalled(CanbusInfo.STR_MAZDA)) {
				String[] args = { "pm", "install", "-f",
						CanbusInfo.STR_MAZDA_PATH };
				silentExec(args);
				runApk(CanbusInfo.STR_MAZDA);
			}
		}
	}

	private void runApk(String strPackage) {
		List<ResolveInfo> matches = findActivitiesForPackage(context, strPackage);
		if ((matches != null) && (matches.size() > 0)) {
			ResolveInfo resolveInfo = matches.get(0);
			ActivityInfo activityInfo = resolveInfo.activityInfo;
			startApk(activityInfo.packageName, activityInfo.name);
		}
		
	}

	public static boolean startApk(String packageName, String activityName) {
		boolean isSuccess = false;

		String cmd = "am start -n " + packageName + "/" + activityName + " \n";
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			isSuccess = waitForProcess(process);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	private static boolean waitForProcess(Process p) {
		boolean isSuccess = false;
		int returnCode;
		try {
			returnCode = p.waitFor();
			switch (returnCode) {
			case 0:
				isSuccess = true;
				break;

			case 1:
				break;

			default:
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public static List<ResolveInfo> findActivitiesForPackage(Context context,
			String packageName) {
		final PackageManager pm = context.getPackageManager();

		final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		mainIntent.setPackage(packageName);

		final List<ResolveInfo> apps = pm.queryIntentActivities(mainIntent, 0);
		return apps != null ? apps : new ArrayList<ResolveInfo>();
	}

	public static String silentExec(String[] args) {
		String result = "";
		ProcessBuilder processBuilder = new ProcessBuilder(args);
		Process process = null;
		InputStream errIs = null;
		InputStream inIs = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int read = -1;
			process = processBuilder.start();
			errIs = process.getErrorStream();
			while ((read = errIs.read()) != -1) {
				baos.write(read);
			}
			baos.write((int) ('\n'));
			inIs = process.getInputStream();
			while ((read = inIs.read()) != -1) {
				baos.write(read);
			}
			byte[] data = baos.toByteArray();
			result = new String(data);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (errIs != null) {
					errIs.close();
				}
				if (inIs != null) {
					inIs.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (process != null) {
				process.destroy();
			}
		}
		return result;
	}

	private boolean isApkInstalled(String pkgName) {
		PackageManager pm = context.getPackageManager();
		boolean installed = false;
		try {
			pm.getPackageInfo(pkgName, PackageManager.GET_ACTIVITIES);
			installed = true;
		} catch (PackageManager.NameNotFoundException e) {
			installed = false;
		}
		return installed;
	}
	
	
}
