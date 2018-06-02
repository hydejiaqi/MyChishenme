package com.chishenme.jjiang.chishenme.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by jjiang on 6/1/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private ReentrantReadWriteLock.ReadLock readLock = null;
    private ReentrantReadWriteLock.WriteLock writeLock = null;
    private List<DBTable> tables = null;

    public DbHelper(Context context, String name, List<DBTable> tables, int version) {
        super(context, name, null, version);
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        this.tables = tables;
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(tables != null){
            Iterator var2 = this.tables.iterator();

            while(var2.hasNext()) {
                DBTable table = (DBTable)var2.next();
                this.createTable(db, table);
            }
        }
    }

    private void createTable(SQLiteDatabase db, DBTable table) {
        if(null != db && null != table) {
            db.execSQL(table.toSQL());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    public void writeLock() {
        this.writeLock.lock();
    }

    public void writeUnlock() {
        this.writeLock.unlock();
    }

    public void readLock() {
        this.readLock.lock();
    }

    public void readUnlock() {
        this.readLock.unlock();
    }
}
