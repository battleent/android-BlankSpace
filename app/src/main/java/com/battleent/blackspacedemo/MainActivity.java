package com.battleent.blackspacedemo;

import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.battleent.blankspace.BlankSpace;
import com.battleent.blankspace.BlankSpaceAnimation;
import com.battleent.blankspace.BlankSpacePopup;

/**
 * Developed by skydoves on 2017-11-13.
 * Copyright (c) 2017 skydoves rights reserved.
 */

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private BlankSpace blankSpace;
    private BlankSpacePopup blankSpacePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBlankSpacePopup(R.layout.layout_not_found);
                View layout = findViewById(R.id.mainlayout);
                blankSpacePopup.show(layout, 0, 20);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBlankSpacePopup(R.layout.layout_connect_fail);
                View layout = findViewById(R.id.mainlayout);
                blankSpacePopup.show(layout, 0, 20);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blankSpace = new BlankSpace(getBaseContext(), R.layout.layout_no_comment);
                RelativeLayout layout = findViewById(R.id.mainlayout);
                blankSpace.show(layout);
            }
        });
    }

    private void setBlankSpacePopup(int layout) {
        blankSpacePopup = new BlankSpacePopup(getBaseContext(), layout);
        blankSpacePopup.setLifecycleOwner(this);
        blankSpacePopup.setAnimation(BlankSpaceAnimation.FADE_IN);
    }

    public void dismissPopup(View view) {
        if(blankSpacePopup != null && blankSpacePopup.isShowing())
            blankSpacePopup.dismiss();
    }

    public void dismiss(View view) {
        if(blankSpace.isShowing())
            blankSpace.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(blankSpacePopup != null && blankSpacePopup.isShowing())
            blankSpacePopup.dismiss();
    }
}
