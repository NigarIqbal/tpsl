package com.example.admin.signapp;

import android.graphics.Bitmap;

/**
 * Created by admin on i2/22/2018.
 */


public class imageItem {

    private Bitmap image;
    private String title;

    public imageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
