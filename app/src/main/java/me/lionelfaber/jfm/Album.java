package me.lionelfaber.jfm;

/**
 * Created by lionel on 4/12/17.
 */

public class Album {

    String title;
    String date;
    String location;
    String cover;

    public Album(String title, String date, String location, String cover) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
