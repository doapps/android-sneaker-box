package me.doapps.validator;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by luis on 16/01/17.
 */
public class AuxToast {

    public static void showAuxToast(Context context, String Message){
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
    }
}
