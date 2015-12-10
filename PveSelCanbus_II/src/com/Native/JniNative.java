package com.Native;

public class JniNative {
	static {
		System.loadLibrary("GtxServiceJni");
	}

	private static native boolean init_native();

	private static native int getval_native();

	private static JniNative jniNative;

	private JniNative() {
	}

	public static JniNative getInstance() {
		if (jniNative == null)
			jniNative = new JniNative();
		return jniNative;
	}

	public void open() {
		init_native();
	}

	public int getval() {
		return getval_native();
	}
}
