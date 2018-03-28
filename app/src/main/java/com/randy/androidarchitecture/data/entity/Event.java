package com.randy.androidarchitecture.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.threeten.bp.LocalDateTime;

import static com.randy.androidarchitecture.data.entity.Event.TABLE_NAME;

/**
 * @author randy
 * @since 3/28/18 9:40 AM
 */
@Entity(tableName = TABLE_NAME)
public class Event {
    public static final String TABLE_NAME = "events";
    public static final String DATE_FIELD = "date";

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    @ColumnInfo(name = DATE_FIELD)
    private LocalDateTime date;

}
