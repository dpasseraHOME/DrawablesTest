package com.dogwoodraleigh.www.drawablestests;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startAnimation();
    }

    private void startAnimation() {
        View view = findViewById(R.id.circle_large);
        view.setPivotX(90f);
        view.setPivotY(90f);

        int dur = 500;

        ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(view, "scaleX", 3f);
        ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(view, "scaleY", 3f);
        scaleUpX.setDuration(dur);
        scaleUpY.setDuration(dur);

        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 1f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 1f);
        scaleDownX.setDuration(dur);
        scaleDownY.setDuration(dur);

        AnimatorSet as = new AnimatorSet();
        as.play(scaleUpX).with(scaleUpY);
        as.play(scaleDownX).with(scaleDownY);
        as.play(scaleDownX).after(scaleUpX);
        as.play(scaleUpX).after(500);
        as.start();
    }
}
