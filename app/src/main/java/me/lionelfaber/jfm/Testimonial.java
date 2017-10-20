package me.lionelfaber.jfm;

/**
 * Created by lionel on 20/10/17.
 */

public class Testimonial {

    String name, city, story, gender;


    public Testimonial(String name, String city, String story, String gender) {
        this.name = name;
        this.city = city;
        this.story = story;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTestimonial() {
        return story;
    }

    public void setTestimonial(String story) {
        this.story = story;
    }
}
