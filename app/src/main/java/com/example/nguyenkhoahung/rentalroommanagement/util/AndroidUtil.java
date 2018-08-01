package com.example.nguyenkhoahung.rentalroommanagement.util;

import android.content.Context;
import android.util.DisplayMetrics;

public class AndroidUtil {
    /**
     * Get device screen dimen by inch
     * @param context app context
     * @return device screen dimen by inch
     */
    public static double getDeviceInch(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
        float widthDpi = metrics.xdpi;
        float heightDpi = metrics.ydpi;
        float widthInches = widthPixels / widthDpi;
        float heightInches = heightPixels / heightDpi;
        return Math.sqrt(
                (widthInches * widthInches)
                        + (heightInches * heightInches));
    }

    /**
     * Convert pixel unit to dp unit
     * @param context app context
     * @param px pixel
     * @return dp
     */
    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    /**
     * Convert dp unit to pixel unit
     * @param context app context
     * @param dp dp
     * @return pixel
     */
    public static float pixelFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    /**
     * Convert sp unit to pixel init
     * @param ctx app context
     * @param sp sp
     * @return pixel
     */
    public static float pixelFromSp(Context ctx, float sp) {
        return sp * ctx.getResources().getDisplayMetrics().scaledDensity;
    }
}
