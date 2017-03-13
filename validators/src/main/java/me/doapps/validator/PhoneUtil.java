package me.doapps.validator;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jonathannolasco on 2/3/17.
 */

public class PhoneUtil {
    private static final String TAG = PhoneUtil.class.getSimpleName();

    public static void dialPhone() {

    }

    public static void CallPhone(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        if (ActivityCompat.
                checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "  need calling permissions");
            Toast.makeText(context, "Se necesita permisos de llamada", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Log.d(TAG, "Calling to : " + phoneNumber);
            context.startActivity(intent);
        }
    }
}
