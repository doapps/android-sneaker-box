package me.doapps.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by jonathannolasco on 2/3/17.
 */

public class loadingDialog extends AlertDialog {
    private Context context;
    private  String title, message;

    private void onCreate(String title, String message) {
        this.title = title;
        this.message = message;
    }
    public loadingDialog(@NonNull Context context, String title, String message) {
        super(context);
        onCreate(title, message);
        init();
    }

    protected loadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        init();
    }

    protected loadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
        setView(view);
    }
}
