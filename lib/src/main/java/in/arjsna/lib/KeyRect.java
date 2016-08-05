package in.arjsna.lib;

import android.graphics.Rect;

/**
 * Created by arjun on 8/3/16.
 */
public class KeyRect {
    public Rect rect;
    public String value;
    public int rippleRadius;
    public int requiredRadius;
    public int circleAlpha;
    public boolean hasRippleEffect = false;

    public KeyRect(Rect rect, String value) {
        this.rect = rect;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
