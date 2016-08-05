package in.arjsna.lib;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/**
 * Created by arjun on 8/3/16.
 */
public class KeyRect {
    public Rect rect;
    public String value;
    public int rippleRadius = 0;
    public int requiredRadius;
    public int circleAlpha;
    public boolean hasRippleEffect = false;
    public ValueAnimator animator;

    public KeyRect(Rect rect, String value) {
        this.rect = rect;
        this.value = value;
        requiredRadius = (this.rect.right - this.rect.left) / 4;
        animator = ValueAnimator.ofFloat(0, requiredRadius);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
