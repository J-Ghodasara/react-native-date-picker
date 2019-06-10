package com.henninghall.date_picker;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.henninghall.date_picker.wheelFunctions.TextColor;

import org.w3c.dom.Text;


class Style {
    private final GradientDrawable gradientBottom;
    private final GradientDrawable gradientTop;
    private final PickerView pickerView;

    public Style(PickerView pickerView) {
        this.pickerView = pickerView;
        ImageView overlayTop = (ImageView) pickerView.findViewById(R.id.overlay_top);
        ImageView overlayBottom = (ImageView) pickerView.findViewById(R.id.overlay_bottom);
        this.gradientTop =  (GradientDrawable) overlayTop.getDrawable();
        this.gradientBottom =  (GradientDrawable) overlayBottom.getDrawable();
    }

    public void setFadeToColor(String color) {
        int alpha = validColor(color) ? 255 : 0;
        gradientTop.setAlpha(alpha);
        gradientBottom.setAlpha(alpha);
        if(validColor(color)) {
            int startColor = Color.parseColor("#FF"+ color.substring(1));
            int endColor = Color.parseColor("#00" + color.substring(1));
            gradientTop.setColors(new int[] {startColor, endColor});
            gradientBottom.setColors(new int[] {startColor, endColor});
        }
    }

    public void setTextColor(String color) {
        this.pickerView.applyOnAllWheels(new TextColor(color));
    }

    public void setWidth(int width) {
        View view = pickerView.findViewById(R.id.container);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;

        view.setLayoutParams(layoutParams);
//        this.pickerView.setMinimumWidth(width);
    }

    public void setHeight(int height) {
        this.pickerView.setMinimumHeight(height);
    }

    private boolean validColor(String color){
        return color != null && color.length() == 7;
    }



}
