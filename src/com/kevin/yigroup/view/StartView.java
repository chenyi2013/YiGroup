package com.kevin.yigroup.view;

import com.kevin.yigroup.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class StartView extends View {

	private Paint mPaint = new Paint();
	private int mBitmapHeight;
	private int mBitmapWidth;
	private int mWidth;
	private int mHeight;
	private float avgScore;

	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
		invalidate();
	}

	public StartView(Context context) {
		super(context);
		init();
	}

	public StartView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public StartView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init() {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rate_star_medium_half);
		mBitmapHeight = bitmap.getHeight();
		mBitmapWidth = bitmap.getWidth();
		bitmap.recycle();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		int heightMode = MeasureSpec.getMode(widthMeasureSpec);
		int height = MeasureSpec.getSize(widthMeasureSpec);

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int width = MeasureSpec.getSize(widthMeasureSpec);

		int defaultWidth = mBitmapWidth * 5;

		switch (heightMode) {
		case MeasureSpec.EXACTLY:
			mHeight = height > mBitmapHeight ? height : mBitmapHeight;
			break;
		default:
			mHeight = mBitmapHeight;
			break;
		}

		switch (widthMode) {
		case MeasureSpec.EXACTLY:
			mWidth = width > defaultWidth ? width : defaultWidth;
			break;
		default:
			mWidth = defaultWidth;
			break;
		}

		setMeasuredDimension(mWidth, mHeight);

	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		Bitmap startHalf = BitmapFactory.decodeResource(getResources(),
				R.drawable.rate_star_medium_half);
		Bitmap startOff = BitmapFactory.decodeResource(getResources(),
				R.drawable.rate_star_medium_off);
		Bitmap startOn = BitmapFactory.decodeResource(getResources(),
				R.drawable.rate_star_medium_on);

		for (int i = 0; i < 5; i++) {
			if (avgScore >= (i + 1)) {
				canvas.drawBitmap(startOn, i * mBitmapWidth, 0, mPaint);
			} else if (avgScore > i && avgScore < (i + 1)) {
				canvas.drawBitmap(startHalf, i * mBitmapWidth, 0, mPaint);
			} else if (avgScore < (i + 1)) {
				canvas.drawBitmap(startOff, i * mBitmapWidth, 0, mPaint);
			}

		}
		startHalf.recycle();
		startOff.recycle();
		startOn.recycle();

	}

}
