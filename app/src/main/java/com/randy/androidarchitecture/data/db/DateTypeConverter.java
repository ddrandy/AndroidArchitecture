package com.randy.androidarchitecture.data.db;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/**
 * @author randy
 * @since 3/28/18 9:58 AM
 */
public class DateTypeConverter {
    @TypeConverter
    public static LocalDateTime toDate(Long timestamp) {
        return timestamp == null ? null :
                LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofTotalSeconds(0));
    }

    @TypeConverter
    public static Long toTimestamp(LocalDateTime dateTime) {
        return dateTime == null ? null : dateTime.toEpochSecond(ZoneOffset.ofTotalSeconds(0));
    }
}
