package com.example.handleapiresponse.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtility {
	public static boolean isNetworkAvailable(Context context) {
		boolean isNetworlAvailable = false;

		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		if (networkInfo != null) {
			isNetworlAvailable = networkInfo.getState() == NetworkInfo.State.CONNECTED;
		}
		return isNetworlAvailable;
	}
}
