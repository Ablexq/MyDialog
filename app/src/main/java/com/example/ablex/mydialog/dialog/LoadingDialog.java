package com.example.ablex.mydialog.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.ablex.mydialog.R;


public class LoadingDialog {
    private TextView tvPrompts;
    private Dialog dialog;
    private Activity activity;

    public LoadingDialog(Activity activity) {
        this.activity = activity;
        dialog = new Dialog(activity, R.style.CustomerDialogTheme);
        Window window = dialog.getWindow();
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_loading, null);
        tvPrompts = (TextView) view.findViewById(R.id.tv_prompt);
        window.setContentView(view);
    }

    public LoadingDialog setCancelable(boolean cancelable) {
        if (dialog != null) {
            dialog.setCancelable(cancelable);
        }
        return this;
    }

    public boolean isShowing() {
        return dialog != null && dialog.isShowing();
    }

    public void show() {
        if (dialog != null && !dialog.isShowing() && activity != null && !activity.isFinishing()) {
            dialog.show();
        }
    }

    public void show(int id) {
        setPrompts(id);
        show();
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing() && activity != null && !activity.isFinishing()) {
            dialog.dismiss();
        }
    }

    public LoadingDialog setPrompts(int id) {
        tvPrompts.setText(id);
        return this;
    }

    public LoadingDialog setPrompts(CharSequence s) {
        tvPrompts.setText(s);
        if (s == null || TextUtils.isEmpty(s.toString())) {
            tvPrompts.setVisibility(View.GONE);
        }
        return this;
    }

}
