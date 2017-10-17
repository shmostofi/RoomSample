package com.example.shokooh.roomsampleapp.main.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by smostofi on 18/09/2017.
 */

@Entity
public class ListItem {

    @PrimaryKey
    private String date;
    private int drawableColor;
    private String content;

    public ListItem(int drawableColor, String date, String content) {
        this.drawableColor = drawableColor;
        this.date = date;
        this.content = content;
    }

    public int getDrawableColor() {
        return drawableColor;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setDrawableColor(int drawableColor) {
        this.drawableColor = drawableColor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
