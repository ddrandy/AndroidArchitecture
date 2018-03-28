package com.randy.androidarchitecture.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.randy.androidarchitecture.data.dao.EventDao;
import com.randy.androidarchitecture.data.entity.Event;

/**
 * @author randy
 * @since 3/28/18 9:53 AM
 */
@Database(entities = {Event.class}, version = 1)
@TypeConverters(value = DateTypeConverter.class)
public abstract class EventDatabase extends RoomDatabase {
    public abstract EventDao eventDao();
}
