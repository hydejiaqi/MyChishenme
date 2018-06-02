package com.chishenme.jjiang.chishenme.db;

/**
 * Created by A16343 on 2016/8/22.
 */
@SuppressWarnings("DefaultFileTemplate")
public enum DatabaseType {
    RESTAURANT("restaurant.db", 1);


    DatabaseType(String name, int version) {
        this.db_name = name;
        this.db_version = version;
    }

    private final String db_name;
    private final int db_version;

    public String getDb_name() {
        return db_name;
    }

    public int getDb_version() {
        return db_version;
    }
}
