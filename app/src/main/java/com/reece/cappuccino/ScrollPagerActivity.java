package com.reece.cappuccino;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by foreece@gmail.com on 17-1-22.
 *
 */

public class ScrollPagerActivity extends Activity {
    private View mFirstPage;
    private View mSecondPage;
    private View mThirdPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_pager);
        mFirstPage = findViewById(R.id.page1);
        mSecondPage = findViewById(R.id.page2);
        mThirdPage = findViewById(R.id.page3);

    }
}
