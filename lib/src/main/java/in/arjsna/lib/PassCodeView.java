package in.arjsna.lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by arjun on 8/2/16.
 */
public class PassCodeView extends View {
    private int digits;
    private int filledCount;
    private Bitmap filledDrawable;
    private Bitmap emptyDrawable;
    private Paint paint;
    private int DEFAULT_DRAWABLE_DIM = 80;
    private int DEFAULT_VIEW_HEIGHT = 200;
    private int drawableWidth;
    private int drawableHeight;
    private int startX;
    private int startY;
    private static final int DIGIT_PADDING = 40;

    public PassCodeView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public PassCodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public PassCodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public PassCodeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray values = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.PassCodeView, defStyleAttr, defStyleRes);
        try {
            digits = values.getInteger(R.styleable.PassCodeView_digits, 4);
            filledCount = values.getInteger(R.styleable.PassCodeView_filled_count, 0);
            filledDrawable = getBitmap(values.getResourceId(R.styleable.PassCodeView_filled_drawable, -1));
            emptyDrawable = getBitmap(values.getResourceId(R.styleable.PassCodeView_empty_drawable, -1));
            drawableWidth = DEFAULT_DRAWABLE_DIM;
            drawableHeight = DEFAULT_DRAWABLE_DIM;
        } catch (Exception e) {
            e.printStackTrace();
        }
        paint = new Paint();
        values.recycle();
    }

    private void computeStartXY() {
        int totalDrawableWidth = digits * drawableWidth;
        int totalPaddingWidth = DIGIT_PADDING * (digits - 1);
        int totalReqWidth = totalDrawableWidth + totalPaddingWidth;
        startX = getMeasuredWidth() / 2 - totalReqWidth / 2;
        startY = getMeasuredHeight() / 2 - drawableHeight / 2;
    }

    private Bitmap getBitmap(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(DEFAULT_DRAWABLE_DIM, DEFAULT_DRAWABLE_DIM, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, DEFAULT_DRAWABLE_DIM, DEFAULT_DRAWABLE_DIM);
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.argb(255, 0, 0, 255));
        int x = startX, y = startY;
        for (int i = 1 ; i <= filledCount ; i ++) {
            canvas.drawBitmap(filledDrawable, x, y, paint);
            x = x + (drawableWidth + DIGIT_PADDING);
        }
        for (int i = 1 ; i <= (digits - filledCount) ; i ++) {
            canvas.drawBitmap(emptyDrawable, x, y, paint);
            x = x + (drawableWidth + DIGIT_PADDING);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO: 8/3/16 take care of padding
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int measuredWidth = 0, measuredHeight = 0;
        if (widthMode == MeasureSpec.EXACTLY) {
            measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            measuredHeight = MeasureSpec.getSize(heightMeasureSpec);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            measuredHeight = drawableHeight + paddingTop + paddingBottom;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        computeStartXY();
    }

    public void setFilledCount(int count) {
        filledCount = count > digits ? digits : count;
        invalidate();
    }
}
