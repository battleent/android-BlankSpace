package com.battleent.blackspacedemo;

import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.battleent.blankspace.BlankSpace;
import com.battleent.blankspace.BlankSpaceAnimation;

/**
 * Developed by skydoves on 2017-11-13.
 * Copyright (c) 2017 skydoves rights reserved.
 */

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private BlankSpace blankSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBlankSpace(R.layout.layout_not_found);
                View layout = findViewById(R.id.mainlayout);
                blankSpace.show(layout, 0, 20);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBlankSpace(R.layout.layout_connect_fail);
                View layout = findViewById(R.id.mainlayout);
                blankSpace.show(layout, 0, 20);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBlankSpace(R.layout.layout_no_comment);
                View layout = findViewById(R.id.mainlayout);
                blankSpace.show(layout, 0, 20);
            }
        });
    }

    private void setBlankSpace(int layout) {
        blankSpace = new BlankSpace(getBaseContext(), layout);
        blankSpace.setLifecycleOwner(this);
        blankSpace.setAnimation(BlankSpaceAnimation.FADE_IN);
    }

    public void dismiss(View view) {
        if(blankSpace != null && blankSpace.isShowing())
            blankSpace.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(blankSpace != null && blankSpace.isShowing())
            blankSpace.dismiss();
    }
}
