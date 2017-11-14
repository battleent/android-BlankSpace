package com.battleent.blankspace;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by skydoves on 2017. 11. 14.
 * Copyright (c) 2017 battleent rights reserved.
 */

@SuppressWarnings("unchecked")
public class BlankSpace {

    private LayoutInflater layoutInflater;

    private RelativeLayout parentView;
    private View blankView;

    private boolean isShowing = false;

    public BlankSpace(Context context, int layout) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(this.layoutInflater != null) {
            this.blankView = this.layoutInflater.inflate(layout, null);
            this.blankView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        }
    }

    public void show(RelativeLayout parentView) {
        if(!isShowing && parentView != null) {
            this.parentView = parentView;
            this.parentView.addView(blankView, 0);
            this.blankView.bringToFront();
            this.parentView.requestLayout();
            this.parentView.invalidate();
            ViewCompat.setTranslationZ(blankView, 99);
            this.isShowing = true;
        }
    }

    public void dismiss() {
        if(this.isShowing) {
            this.parentView.removeView(blankView);
            this.isShowing = false;
        }
    }

    public boolean isShowing() {
        return isShowing;
    }

    public View getBlankView() {
        return this.blankView;
    }
}
