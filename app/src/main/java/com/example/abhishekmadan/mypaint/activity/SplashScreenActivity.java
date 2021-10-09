package com.example.abhishekmadan.mypaint.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhishekmadan.mypaint.R;

/**
 * Simple Splash screen Activity
 */
public class SplashScreenActivity extends AppCompatActivity {

    private Animation mLinearAnim;

    private Animation mSweepAnim;

    private ImageView mBrushImageView;

    private TextView mLineTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        init();
    }

    public void init() {
        mBrushImageView =   findViewById(R.id.brush_imageview);
        mLineTextView =   findViewById(R.id.line_textview);
        mLinearAnim = AnimationUtils.loadAnimation(this, R.anim.linear_move);
        mSweepAnim = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        mLineTextView.setAnimation(mSweepAnim);
        mBrushImageView.setAnimation(mLinearAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, DrawingBoard.class);
                startActivity(intent);
                finish();
            }
        }, 8000);
    }
}
