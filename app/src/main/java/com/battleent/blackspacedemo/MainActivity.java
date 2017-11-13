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

        blankSpace = new BlankSpace(getBaseContext(), R.layout.layout_not_found);
        blankSpace.setLifecycleOwner(this);
        blankSpace.setAnimation(BlankSpaceAnimation.FADE_IN);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View layout = findViewById(R.id.mainlayout);
                blankSpace.show(layout, 0, 20);
            }
        });

        Button button2 = blankSpace.getParentView().findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blankSpace.dismiss();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(blankSpace.isShowing())
            blankSpace.dismiss();
    }
}
