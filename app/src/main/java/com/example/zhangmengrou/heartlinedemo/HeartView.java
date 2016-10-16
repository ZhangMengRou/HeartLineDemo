package com.example.zhangmengrou.heartlinedemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


public class HeartView extends View {

    private int mMeasureWidth;//界面宽度
    private int mMeasureHeight;//界面高度
    private int mWidthMode;
    private int mHeightMode;
    private Paint paint;
    private int heartColor;


    public HeartView(Context context) {
        super(context);

    }

    public HeartView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public HeartView(Context context, AttributeSet attrs, int defStyleAttrs) {
        super(context, attrs, defStyleAttrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //测量规范
        mWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        mHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        //测量值
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        //设置view的大小
        if (mWidthMode == MeasureSpec.AT_MOST && mHeightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, 200);
        } else if (mWidthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, mMeasureHeight);
        } else if (mHeightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mMeasureWidth, 200);
        } else {
            setMeasuredDimension(mMeasureWidth, mMeasureHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setStrokeWidth(6);
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        int width = getWidth();
        int height = getHeight();

        Path path1 = new Path();
        // 起点
        float startW = width / 2;
        float startH = height / 4;
        // 终点
        float endW = width / 2;
        float endH = (height * 7) / 12;

        path1.moveTo(endW, endH);
        // 贝塞尔曲线
        path1.cubicTo((width * 12) / 13, (height * 2) / 5, (width * 6) / 7, height / 9, startW, startH);
        canvas.drawPath(path1, paint);

        Path path2 = new Path();
        path2.moveTo(width / 2, height / 4);
        path2.cubicTo(width / 7, height / 9, width / 13, (height * 2) / 5, width / 2, (height * 7) / 12);

        canvas.drawPath(path2, paint);
        // 画线 辅助线
        // canvas.drawLine(width/2,height/4,width / 7, height / 9,paint);
        //    canvas.drawLine( width / 2, (height * 7) / 12,  width / 13, (height * 2) / 5,paint);
        //   canvas.drawLine(width / 7, height / 9, width / 13, (height * 2) / 5,paint);
        canvas.drawLine(0, (height * 7) / 12, width, (height * 7) / 12, paint); //直线

    }


    public int getmMeasureWidth() {
        return mMeasureWidth;
    }

    public int getmMeasureHeight() {
        return mMeasureHeight;
    }


}
