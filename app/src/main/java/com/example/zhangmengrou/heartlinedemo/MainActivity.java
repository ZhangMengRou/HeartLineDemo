package com.example.zhangmengrou.heartlinedemo;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    float width, height;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.bt);
        final ImageView ic = (ImageView) findViewById(R.id.icon);
        final HeartView h = (HeartView) findViewById(R.id.heart);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取背景轨迹
                width = h.getWidth();
                height = h.getHeight();
                Log.d("mView", width + "  " + height);
                // 获取运动图片的宽高
                float lWith = ic.getWidth() / 2;
                float lHeight = ic.getHeight() / 2;
                // 修正运动中心
                float startW = width / 2 - lWith;
                float startH = height / 4 - lHeight;
                float endW = width / 2 - lWith;
                float endH = (height * 7) / 12 - lHeight;
                Path path = new Path();
                // 心形右边
                path.moveTo(endW, endH);
                path.cubicTo((width * 12) / 13, (height * 2) / 5, (width * 6) / 7, height / 9, startW, startH);

                // 心形左边
                Path path2 = new Path();
                path2.moveTo(width / 2 - lWith, height / 4 - lHeight);
                path2.cubicTo(width / 7, height / 9, width / 13, (height * 2) / 5, width / 2 - lWith, (height * 7) / 12 - lHeight);

                // 直线左边
                Path p1 = new Path();
                p1.moveTo(0 - lWith, (height * 7) / 12 - lHeight);
                p1.lineTo(width / 2 - lWith, (height * 7) / 12 - lHeight);
                // 直线右边
                Path p3 = new Path();
                p3.moveTo(width / 2 - lWith, (height * 7) / 12 - lHeight);
                p3.lineTo(width - lWith, (height * 7) / 12 - lHeight);
                Path myPath = new Path();
                // 轨迹组合
                myPath.addPath(p1);
                myPath.addPath(path);
                myPath.addPath(path2);
                myPath.addPath(p3);
                ObjectAnimator mAnimator;
                mAnimator = ObjectAnimator.ofFloat(ic, View.X, View.Y, myPath);
                mAnimator.setDuration(5000);
                // 重复运动50次
                mAnimator.setRepeatCount(50);
                mAnimator.start();


            }
        });
    }


}

