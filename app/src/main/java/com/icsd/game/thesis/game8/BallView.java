package com.icsd.game.thesis.game8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BallView extends View {
    private static final int DEFAULT_CIRCLE_COLOR = Color.RED;
    private Paint paint ;
    private int color= Color.GREEN;



    public BallView(Context context, AttributeSet attrs) {
        super(context,attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        int pl = getPaddingLeft();
        int pr = getPaddingRight();
        int pt = getPaddingTop();
        int pb = getPaddingBottom();

        int usableWidth = w - (pl + pr);
        int usableHeight = h - (pt + pb);

        int radius = Math.min(usableWidth, usableHeight) / 2;
        int cx = pl + (usableWidth / 2);
        int cy = pt + (usableHeight / 2);

        paint.setColor(this.getColor());
        this.color=paint.getColor();

        canvas.drawCircle(cx, cy, radius, paint);
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }

    public Paint getPaint() {
        return paint;
    }

}
