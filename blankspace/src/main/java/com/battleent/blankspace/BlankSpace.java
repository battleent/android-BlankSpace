package com.battleent.blankspace;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * Developed by skydoves on 2017-11-13.
 * Copyright (c) 2017 skydoves rights reserved.
 */

@SuppressWarnings("unchecked")
public class BlankSpace implements LifecycleObserver {

    private PopupWindow blankWindow;
    private View blankView;

    private LayoutInflater layoutInflater;

    private int animation = -1;
    private int animationStyle = -1;

    private LifecycleOwner lifecycleOwner;

    private boolean isShowing = false;

    public BlankSpace(Context context, int layout) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(this.layoutInflater != null) {
            this.blankView = this.layoutInflater.inflate(layout, null);
            this.blankWindow = new PopupWindow(this.blankView, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public void show(View anchor) {
        if(!this.isShowing) {
            this.blankWindow = new PopupWindow(this.blankView, anchor.getMeasuredWidth(), anchor.getMeasuredHeight());
            this.blankWindow.setAnimationStyle(this.animation);
            if(this.animationStyle != -1) this.blankWindow.setAnimationStyle(animationStyle);
            this.blankWindow.showAtLocation(anchor, Gravity.CENTER, 0, anchor.getHeight());
            this.isShowing = true;
        }
    }

    public void show(View anchor, int xOff, int yOff) {
        if(!this.isShowing) {
            this.blankWindow = new PopupWindow(this.blankView, anchor.getMeasuredWidth() - xOff, anchor.getMeasuredHeight() - yOff);
            this.blankWindow.setAnimationStyle(this.animation);
            if(this.animationStyle != -1) this.blankWindow.setAnimationStyle(animationStyle);
            this.blankWindow.showAtLocation(anchor, Gravity.CENTER, 0, anchor.getHeight());
            this.isShowing = true;
        }
    }

    public void dismiss() {
        if(this.isShowing) {
            this.blankWindow.dismiss();
            this.isShowing = false;
        }
    }

    public void setLayout(int layout) {
        if(this.layoutInflater != null)
            this.blankView = this.layoutInflater.inflate(layout, null);
    }

    public void setAnimation(BlankSpaceAnimation animation) {
        if(animation == BlankSpaceAnimation.FADE_IN) {
            this.animation = R.style.BlankAnimationFadeIn;
        }
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setAnimationStyle(int style) {
        this.animationStyle = style;
    }

    public View getParentView() {
        return this.blankView;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        if(isShowing()) {
            blankWindow.dismiss();
        }
    }
}