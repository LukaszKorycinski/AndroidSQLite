package com.kalkulator.lukasz.androidsqlite.pojo;

/**
 * Created by Lukasz on 2017-01-02.
 */

public class Note {//reprezentuje pojedyńczy wpis
    private Integer id;
    private String noteText;

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return noteText;
    }
}
