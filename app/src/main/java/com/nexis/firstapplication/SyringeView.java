package com.example.yourpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SyringeView extends View {
    private Paint paint;

    public SyringeView(Context context) {
        super(context);
        init();
    }

    public SyringeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SyringeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        // Diğer boyut, renk veya özellik ayarlamalarını burada yapabilirsiniz.
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Şırınga göstergesini çizme kodunu buraya ekleyin.
        // Örneğin, bir daire çizelim:
        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;
        float radius = Math.min(centerX, centerY) * 0.8f;
        canvas.drawCircle(centerX, centerY, radius, paint);
    }
}

