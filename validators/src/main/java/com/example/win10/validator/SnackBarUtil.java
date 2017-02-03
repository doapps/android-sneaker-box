package com.example.win10.validator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;

/**
 * Created by luis on 25/01/17.
 */
public class SnackBarUtil {

    public Snackbar snackbar;
    private CoordinatorLayout cl;
    private Context cx;
    private String message;
    private IHandler ihandler;

    public SnackBarUtil(CoordinatorLayout cl, Context cx, String message) {
        this.cl = cl;
        this.cx = cx;
        this.message = message;
    }

    public void showSnackbar(int Rcolor) {
        snackbar = Snackbar.make(cl, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setActionTextColor(cx.getResources().getColor(R.color.colorPrimary));
        snackbar.setAction("Ok", v -> ihandler.action()).show();
        if (Rcolor != -1) {
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(cx, Rcolor));
            snackbar.setActionTextColor(cx.getResources().getColor(R.color.white));
        }
    }

    public interface IHandler {
        void action();
    }

    public void initSnackBarInterface(IHandler ihandler) {
        this.ihandler = ihandler;
    }


}
