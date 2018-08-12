package com.icsd.game.thesis.pet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.icsd.game.thesis.R;


public class PopUpWindow {
    private PopupWindow mPopupWindow;
    private final View popupView;
    private View tutorialView;

    public PopupWindow getmPopupWindow() {
        return mPopupWindow;
    }

    private final Context context;
    private final Activity activity;
    private TextView text, tutorialTextView;
    private ImageView cat, bubble;


    public PopUpWindow(final Context context, final Activity activity) {
        this.context = context;
        this.activity = activity;


        popupView = activity.getLayoutInflater().inflate(R.layout.popupwindow1_showasdropdown, null);
        text = popupView.findViewById(R.id.text_view_dropdown);


    }

    public void showPopUp(String str) {

        text.setText(str);

        mPopupWindow = new PopupWindow(popupView, 600, 600, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
        mPopupWindow.showAtLocation(this.activity.findViewById(R.id.layoutID), Gravity.CENTER, 0, 0);


    }


}
