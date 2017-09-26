package com.example.shokooh.roomsampleapp.main.data;

/**
 * Created by smostofi on 18/09/2017.
 */

public class ListItem {
    private int color;
    private String date;
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
