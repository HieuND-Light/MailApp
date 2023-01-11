package com.hieund.mailapp;

public class ItemModel {
    private String textThumb;
    private String textTitle;
    private String content;
    private String datetime;

    public ItemModel(String textThumb, String textTitle, String content, String datetime) {
        this.textThumb = textThumb;
        this.textTitle = textTitle;
        this.content = content;
        this.datetime = datetime;
    }

    public String getTextThumb() {
        return String.valueOf(getTextTitle().toUpperCase().charAt(0));
    }

    public void setTextThumb(String textThumb) {
        this.textThumb = textThumb;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getContent() { return content; }

    public void setContent(String phone) { this.content = content; }

    public String getDatetime() { return datetime; }

    public void setDatetime(String mail) { this.datetime = datetime; }

}