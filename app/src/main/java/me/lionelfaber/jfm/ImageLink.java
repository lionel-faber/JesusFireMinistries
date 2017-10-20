package me.lionelfaber.jfm;

/**
 * Created by lionel on 18/10/17.
 */

public class ImageLink {

    String link, url;

    public ImageLink(String link, String url) {
        this.link = link;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public ImageLink(String link) {
        this.link = link;
        this.url = null;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
