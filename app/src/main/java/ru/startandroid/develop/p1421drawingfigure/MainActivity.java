package ru.startandroid.develop.p1421drawingfigure;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint p;
        Rect rect;
        StringBuilder sb;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect(100, 200, 200, 300);
            sb = new StringBuilder();
        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.BLUE);
            p.setStrokeWidth(10);

            p.setTextSize(30);

            sb.setLength(0);
            sb.append("Width = ").append(canvas.getWidth())
                    .append(", Height = ").append(canvas.getHeight());
            canvas.drawText(sb.toString(), 100, 100, p);

            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect, p);

            p.setStyle(Paint.Style.STROKE);
            rect.offset(150, 0);
            canvas.drawRect(rect, p);

            p.setStyle(Paint.Style.FILL_AND_STROKE);
            rect.offset(150, 0);
            canvas.drawRect(rect, p);

        }

    }
}
