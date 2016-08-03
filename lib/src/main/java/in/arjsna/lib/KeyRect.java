package in.arjsna.lib;

import android.graphics.Rect;

/**
 * Created by arjun on 8/3/16.
 */
public class KeyRect {
    Rect rect;
    String value;

    public KeyRect(Rect rect, String value) {
        this.rect = rect;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
