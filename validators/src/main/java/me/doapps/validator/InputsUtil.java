package me.doapps.validator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win10.validator.R;

/**
 * Created by Luis alberto on 23/09/2016.
 */
public class InputsUtil {

    /**
     * method to get a string text from edittext
     *
     * @param editText
     * @return null - no text : string - text
     */
    public static String getStringText(EditText editText) {
        if (!editText.getText().toString().trim().isEmpty()) {
            return editText.getText().toString().trim();
        } else {
            return null;
        }
    }

    /**
     * method to check is editext has text inside
     *
     * @param input
     * @return
     */
    public static boolean isEditextEmpty(EditText input) {
        boolean isEmpty = true;
        try {
            if (input.getText().toString().trim().equals("")) {
                isEmpty = true;
            } else {
                isEmpty = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isEmpty;
    }

    /**
     * method to check if isValidDouble is valid number
     *
     * @param input
     * @return
     */
    public static boolean isValidNumber(EditText input) {
        boolean isValid = false;
        try {
            Integer.parseInt(input.getText().toString().trim());
            isValid = true;
        } catch (Exception e) {
            e.printStackTrace();
            isValid = false;
        } finally {
            return isValid;
        }
    }

    /**
     * String validation for minimun lenght and max lenght
     **/
    public static boolean isInRange(EditText input, int min, int max) {
        boolean valida = false;
        try {
            String data = input.getText().toString().trim();
            if (data.length() > min && data.length() < max) {
                valida = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valida;
    }

    /**
     * show the text lenght
     * @param context
     * @param editText
     */
    public static void showTextLenght(Context context, EditText editText) {
        Toast.makeText(context, "text lenght : " + editText.getText().length(), Toast.LENGTH_SHORT).show();
    }

    /**
     * method toe clear the current Input
     *
     * @param input
     */
    public static void clearEdit(EditText input) {
        try {
            input.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * hide allways keyboard
     * @param context
     */
    public static void removeFocus(Context context) {
        ((AppCompatActivity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * method to compare text from edittext and an string pattern
     *
     * @param input
     * @param pattern
     * @return
     */
    public static boolean isDifferent(EditText input, String pattern) {
        try {
            String value = input.getText().toString().trim();
            if (!value.equals(pattern)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * method to verify is mail is valid
     * @param email
     * @return
     */
    public static boolean isValidEmailAddress(EditText email) {
        if (!email.getText().toString().trim().isEmpty()) {
            String eml = email.getText().toString().trim();
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(eml);
            return m.matches();
        }

        return false;
    }

    /**
     * method to validate if an string is not so long than param
     * @param editText
     * @param min quantity of chars
     * @return
     */
    public static boolean isMinusThanLenght(EditText editText, int min) {
        boolean val = false;
        if (editText != null)
            if (editText.getText().toString().length() < min)
                val = true;
        return val;
    }

    /**
     * method to check is a checkbox is selected
     *
     * @param box
     * @return true - selected : false - unselected
     */
    public static boolean isSelected(CheckBox box) {
        boolean bol = false;
        if (box.isChecked()) {
            bol = true;
        }
        return bol;
    }

    /**
     * method to show the keyboard
     *
     * @param context
     * @param editText
     * @param param    0
     */
    public static void showKeyBoard(Context context, EditText editText, int param) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.showSoftInput(editText, InputMethodManager.RESULT_UNCHANGED_HIDDEN);
        imm.showSoftInput(editText, param);
    }

    /**
     * method to hide the keyboard
     *
     * @param context
     * @param param   0
     */
    public static void hideKeyBoard(Context context, int param) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, param);
    }


}
