package com.Const;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SPreference {
	private SharedPreferences sPreferences;
	private Editor mEditor;

	public SPreference(Context context, String name, int mode) {
		if (context != null) {
			sPreferences = context.getSharedPreferences(name, mode);
		}
	}

	public int putInt(String key, int value) {
		if (sPreferences == null)
			return -1;
		mEditor = sPreferences.edit();
		mEditor.putInt(key, value);
		mEditor.commit();
		return 0;
	}

	public int putBoolean(String key, boolean value) {
		if (sPreferences == null)
			return -1;
		mEditor = sPreferences.edit();
		mEditor.putBoolean(key, value);
		mEditor.commit();
		return 0;
	}

	public int putFloat(String key, float value) {
		if (sPreferences == null)
			return -1;
		mEditor = sPreferences.edit();
		mEditor.putFloat(key, value);
		mEditor.commit();
		return 0;
	}

	public int putLong(String key, long value) {
		if (sPreferences == null)
			return -1;
		mEditor = sPreferences.edit();
		mEditor.putLong(key, value);
		mEditor.commit();
		return 0;
	}

	public int putString(String key, String value) {
		if (sPreferences == null)
			return -1;
		mEditor = sPreferences.edit();
		mEditor.putString(key, value);
		mEditor.commit();
		return 0;
	}

/*	public int putStringSet(String key, Set<String> values) {
		if (sPreferences == null)
			return -1;
		mEditor = sPreferences.edit();
		mEditor.putStringSet(key, values);
		mEditor.commit();
		return 0;
	}*/

	public int remove(String key) {
		if (sPreferences == null)
			return -1;
		mEditor = sPreferences.edit();
		mEditor.remove(key);
		mEditor.commit();
		return 0;
	}

	public Map<String, ?> getAll() {
		if (sPreferences != null)
			return sPreferences.getAll();
		return null;
	}

	public boolean getBoolean(String key, boolean defValue) {
		if (sPreferences != null)
			return sPreferences.getBoolean(key, defValue);
		return defValue;
	}

	public float getFloat(String key, float defValue) {
		if (sPreferences != null)
			return sPreferences.getFloat(key, defValue);
		return defValue;
	}

	public int getInt(String key, int defValue) {
		if (sPreferences != null)
			return sPreferences.getInt(key, defValue);
		return defValue;
	}

	public long getLong(String key, long defValue) {
		if (sPreferences != null)
			return sPreferences.getLong(key, defValue);
		return defValue;
	}

	public String getString(String key, String defValue) {
		if (sPreferences != null)
			return sPreferences.getString(key, defValue);
		return defValue;
	}

/*	public Set<String> getStringSet(String key, Set<String> defValues) {
		if (sPreferences != null)
			return sPreferences.getStringSet(key, defValues);
		return defValues;
	}*/
}
