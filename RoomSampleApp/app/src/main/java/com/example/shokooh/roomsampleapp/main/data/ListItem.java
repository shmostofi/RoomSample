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
    private int color;
    private String content;

    public ListItem(int color, String date, String content) {
        this.color = color;
        this.date = date;
        this.content = content;
    }

    public int getColor() {
        return color;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
