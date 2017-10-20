package me.lionelfaber.jfm;

/**
 * Created by lionel on 20/10/17.
 */

public class Event {

    String header, content;

    public Event(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
