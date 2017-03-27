package com.example.healer.englishstorys;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Healer on 20-Feb-17.
 */

public class Story {
    String image;
    String title;
    String linkAudio;
    String contentStory;
    String contentTranslate;
    ArrayList<Vocabulary> vocabulary;
    ArrayList<CheckKnowledge> checkKnowledges;
    public Story(){

    }
    public Story(String image, String title, String linkAudio) {
        this.image = image;
        this.title = title;
        this.linkAudio  = linkAudio;
    }

    public CharSequence getContentStory() {
        return contentStory;
    }

    public void setContentStory(String contentStory) {
        this.contentStory = contentStory;
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

    public String getLinkAudio() {
        return linkAudio;
    }

    public void setLinkAudio(String linkAudio) {
        this.linkAudio = linkAudio;
    }

    public String getContentTranslate() {
        return contentTranslate;
    }

    public void setContentTranslate(String contentTranslate) {
        this.contentTranslate = contentTranslate;
    }

    public ArrayList<Vocabulary> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(ArrayList<Vocabulary> vocabulary) {
        this.vocabulary = vocabulary;
    }

    public ArrayList<CheckKnowledge> getCheckKnowledges() {
        return checkKnowledges;
    }

    public void setCheckKnowledges(ArrayList<CheckKnowledge> checkKnowledges) {
        this.checkKnowledges = checkKnowledges;
    }
}
