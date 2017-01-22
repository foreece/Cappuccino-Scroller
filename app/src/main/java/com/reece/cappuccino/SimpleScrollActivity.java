package com.reece.cappuccino;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by foreece@gmail.com on 17-1-22.
 * a simple scroll implement.
 */

public class SimpleScrollActivity extends Activity{
    private CustomView mCustomView;
    private Button mButtonStart;
    private int mEndY = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scroll);

        mCustomView = (CustomView) findViewById(R.id.custom_view);
        mButtonStart = (Button) findViewById(R.id.start);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomView.smoothScrollTo(0, mEndY);
            }
        });
    }
}
