package me.doapps.validator;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.InetAddress;

public class InternetUtil {


    /**
     * this method checks whether mobile is connected to internet and returns true if connected:
     *
     * @return true : connected / false : not connected
     */
    private boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            return !ipAddr.equals("");
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * this method checks whether mobile is connected to internet and returns true if connected.
     * Sometimes the active connection is not first in the list, or is inactive or in an error state. This is how I would do it
     *
     * @return true : connected / false : not connected
     */
    public static boolean checkConnection(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }
}