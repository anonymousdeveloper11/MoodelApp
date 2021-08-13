package com.anonymousdevloper.moodelapp;

import android.graphics.drawable.Drawable;

public class SliderModel {

    private String title, subtitle;
    private int color;

    public SliderModel(String title, String subtitle, int color) {
        this.title = title;
        this.subtitle = subtitle;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
