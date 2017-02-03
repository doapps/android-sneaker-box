package com.example.win10.validator;

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

/**
 * Created by Luis alberto on 23/09/2016.
 */
public class InputsUtil {

    public static final float scaleX = 0.7f;
    public static final float scaleY = 0.7f;

    public static String getText(EditText editText) {
        if (!editText.getText().toString().trim().isEmpty()) {
            return editText.getText().toString().trim();
        } else {
            return null;
        }
    }

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

    public static boolean isValidInteger(EditText input) {
        int value = Integer.parseInt(input.getText().toString().trim());
        if (value > 0)
            return true;
        else
            return false;
    }

    public static boolean isPhoneNumberComplete(EditText input) {
        boolean valida = false;
        try {
            if (input.getText().toString().trim().length() > 6 &&
                    input.getText().toString().trim().length() < 12) {
                valida = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valida;
    }

    public static boolean isInRange(EditText input, int min, int max) {
        boolean valida = false;
        try {
            if (input.getText().toString().trim().length() > min &&
                    input.getText().toString().trim().length() < max) {
                valida = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valida;
    }

    public static boolean isInRange(EditText input, int max) {
        boolean b = false;
        try {
            if (input.getText().toString().trim().length() == max) {
                b = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean isInAnyRangeTil(EditText input, int max, int min) {
        boolean b = false;
        try {
            if (input.getText().toString().trim().length() >= min &&
                    input.getText().toString().trim().length() <= max) {
                b = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean isContained(EditText input, int max) {
        boolean b = false;
        try {
            if (input.getText().toString().trim().length() <= max) {
                b = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static void showTextLenght(Context context, EditText editText) {
        Toast.makeText(context, "text lenght : " + editText.getText().length(), Toast.LENGTH_SHORT).show();

    }

    public static boolean isDocumentsComplete(EditText input) {
        boolean valida = false;
        try {
            if (input.getText().toString().trim().length() > 6 && input.getText().toString().trim().length() < 12) {
                valida = true;
            } else {
                valida = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valida;
    }

    public static boolean isMail(EditText input) {
        boolean valida = false;
        try {
            if (input.getText().toString().trim().equals("")) {
                valida = false;
            } else {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(input.getText().toString().trim()).matches()) {
                    valida = true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valida;
    }

    public static void clearIpnut(EditText input) {
        try {
            input.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static void selectedEditext(Context context, EditText input, TextView text_holder, int dimenId) {
        input.setOnTouchListener((View v, MotionEvent event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    input.requestFocus();
                    showKeyBoard(context, input, InputMethodManager.SHOW_IMPLICIT);
                    input.setCursorVisible(true);
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:

                    break;
            }
            return true;
        });

    }

    public static void releasedEditext(Context context, EditText input, TextView text_holder, int dimenId) {
        float dim = ((0) * context.getResources().getDimension(dimenId));
        float scaleX = 1;
        float scaleY = 1;

        animateDownLabel(context, text_holder, scaleX, scaleY, dim);
    }

    public static void animateUpLabel(Context context, TextView textView, float scaleX, float scaleY, float dimY) {
        textView.setText(textView.getText().toString().toUpperCase());
        textView.animate().scaleY(scaleY);
        textView.animate().scaleX(scaleX);
        textView.animate().translationY(dimY).start();
    }

    public static void animateDownLabel(Context context, TextView textView, float scaleX, float scaleY, float dimY) {
        textView.setText(textView.getText().toString().toUpperCase());
        textView.animate().scaleY(scaleY);
        textView.animate().scaleX(scaleX);
        textView.animate().translationY(dimY).start();
    }

    public static void HandleEditTextEffect(Context context, EditText input, TextView text_holder, int dimen) {
        //selectedEditext(context, input, text_holder, dimen);
        float dim = context.getResources().getDimension(dimen);

        if (!isEditextEmpty(input)) {
            animateUpLabel(context, text_holder, scaleX, scaleY, dim);
        }

        input.setOnFocusChangeListener((View v, boolean hasFocus) -> {

            if (hasFocus) {
                if (text_holder != null) {
                    animateUpLabel(context, text_holder, scaleX, scaleY, dim);
                }
                showKeyBoard(context, input, InputMethodManager.SHOW_IMPLICIT);
            } else {
                if (isEditextEmpty(input)) {
                    if (text_holder != null) {
                        releasedEditext(context, input, text_holder, dimen);
                    }
                    showKeyBoard(context, input, 0);
                    input.setCursorVisible(false);
                }
            }

        });

        input.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                if (isEditextEmpty(input)) {
                    releasedEditext(context, input, text_holder, dimen);
                    showKeyBoard(context, input, InputMethodManager.SHOW_IMPLICIT);
                    input.setCursorVisible(false);
                    input.clearFocus();
                }
            }
            return false;
        });

    }

    public static void showKeyBoard(Context context, EditText editText, int param) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, param);
    }

    public static void removeFocus(Context context) {
        ((AppCompatActivity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static boolean isValidEmailAddress(String email) {

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

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

    public static boolean isMin(EditText editText, int min) {
        boolean val = false;
        if (editText != null)
            if (editText.getText().toString().length() < min)
                val = true;
        return val;
    }

    public static void onErrorEditext(Context context, EditText editText) {
        try {
            ObjectAnimator anim = ObjectAnimator.ofFloat(editText, "alpha", 0.3f);
            anim.setDuration(500);
            anim.start();

            ObjectAnimator anim1 = ObjectAnimator.ofFloat(editText, "alpha", 1f);
            anim1.setDuration(500);

            ObjectAnimator anim2 = ObjectAnimator.ofFloat(editText, "alpha", 0.3f);
            anim2.setDuration(500);

            ObjectAnimator anim3 = ObjectAnimator.ofFloat(editText, "alpha", 1f);
            anim3.setDuration(500);

            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    editText.setBackgroundResource((R.drawable.edit_error2));

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    anim1.start();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            anim1.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    editText.setBackgroundResource((R.drawable.edit_error1));

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    anim2.start();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            anim2.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    editText.setBackgroundResource((R.drawable.edit_error2));

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    anim3.start();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            anim3.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    editText.setBackgroundResource((R.drawable.edit_error1));

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.toString().length() > 0) {
                        InputsUtil.okEditext(context, editText, null);
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void okEditext(Context context, EditText editText, String holder) {
        try {
            editText.setBackgroundResource(R.drawable.edit_silverclear);
            if (!holder.equals(null)) {
                editText.setHint(holder);
                editText.setHintTextColor(context.getResources().getColor(R.color.gray));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSelected(CheckBox box) {
        boolean bol = false;
        if (box.isChecked()) {
            bol = true;
        }
        return bol;
    }

    public static Object getItemSpinner(Spinner spinner) {
        if (spinner != null) {
            return spinner.getSelectedItem();
        }
        return null;
    }


}
