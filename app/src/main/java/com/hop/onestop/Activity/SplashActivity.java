package com.hop.onestop.Activity;

import android.view.View;
import android.view.ViewGroup;

import com.hop.onestop.R;

/**
 * Created by ARPaul on 29-05-2016.
 */
public class SplashActivity extends BaseActivity {

    private View llSplashActivity;
    @Override
    public void initialize() {
        llSplashActivity    = inflater.inflate(R.layout.activity_splash,null);
        llBodyBase.addView(llSplashActivity, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    }
}
