package me.lionelfaber.jfm;

/**
 * Created by lionel on 4/12/17.
 */

public class Photo {

    Album album;
    String link;

    public Photo(Album album, String link) {
        this.album = album;
        this.link = link;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
