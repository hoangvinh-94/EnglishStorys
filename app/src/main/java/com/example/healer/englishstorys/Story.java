package com.example.healer.englishstorys;

/**
 * Created by Healer on 20-Feb-17.
 */

public class Story {
    String image;
    String title;

    public Story(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
