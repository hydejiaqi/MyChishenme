package com.chishenme.jjiang.chishenme.db;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/**
 * Created by jjiang on 6/1/2018.
 */

public class DbHelperTable {
    protected SQLiteDatabase writableDb;
    protected SQLiteDatabase readableDb;
    protected final DbHelper dbHelper;

    public DbHelperTable(@NonNull DbHelper dbHelper) {
        this.dbHelper = dbHelper;
        this.writableDb = dbHelper.getWritableDatabase();
        this.readableDb = dbHelper.getReadableDatabase();
    }

    public void closeDb() {
        try {
            dbHelper.writeLock();
            if (null != writableDb && writableDb.isOpen()) {
                writableDb.close();
            }
            if (null != readableDb && readableDb.isOpen()) {
                readableDb.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbHelper.writeUnlock();
        }

    }

    protected SQLiteDatabase checkWriteOpened() {
        if (null == writableDb || !writableDb.isOpen()) {
            this.writableDb = dbHelper.getWritableDatabase();
        }
        return writableDb;
    }

    protected SQLiteDatabase checkReadOpened() {
        if (null == readableDb || !readableDb.isOpen()) {
            this.readableDb = dbHelper.getReadableDatabase();
        }
        return readableDb;
    }

}
