package com.mapmyindia.ceinfo.silvassa.utils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;

/**
 * Created by ceinfo on 28-02-2017.
 */

public class ViewUtils {

    public static void setColorToView(String color, View view) {
        Drawable background = view.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(Color.parseColor(color));
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(Color.parseColor(color));
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(Color.parseColor(color));
        }
    }
}
