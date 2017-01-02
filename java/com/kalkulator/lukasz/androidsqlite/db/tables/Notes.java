package com.kalkulator.lukasz.androidsqlite.db.tables;

/**
 * Created by Lukasz on 2017-01-02.
 */

public interface Notes {
    String TABLE_NAME = "notes";

    interface Columns {
        String NOTE_ID = "_id";
        String NOTE_TEXT = "note_text";
    }
}
