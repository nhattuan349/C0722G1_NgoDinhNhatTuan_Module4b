package com.ss8_develop_feature_to_validate_song_information.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String performing;
    private String songType;

    public Song() {
    }

    public Song(int id, String name, String performing, String songType) {
        this.id = id;
        this.name = name;
        this.performing = performing;
        this.songType = songType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerforming() {
        return performing;
    }

    public void setPerforming(String performing) {
        this.performing = performing;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }
}
