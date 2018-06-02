package com.chishenme.jjiang.chishenme.db.config;


import com.chishenme.jjiang.chishenme.MyApp;
import com.chishenme.jjiang.chishenme.db.DBTable;
import com.chishenme.jjiang.chishenme.db.DatabaseType;
import com.chishenme.jjiang.chishenme.db.DbHelper;
import com.chishenme.jjiang.chishenme.util.DataBaseUtil;

import java.util.List;

/**
 * Created by A16343 on 2016/8/19.
 * 数据库相关配置信息
 */
public abstract class DbConfig {
    private final DatabaseType databaseType;
    private DbHelper dbHelper;

    DbConfig(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    private String getFileName() {
        return databaseType.getDb_name();
    }

    void copyAsset2File() {
        DataBaseUtil.copyAsset2File(databaseType.getDb_name());
    }

    public DbHelper getDbHelper() {
        if (null == dbHelper) {
            synchronized (this) {
                if (null == dbHelper) {
                    beforeCreateDbHelper();
                    dbHelper = new DbHelper(
                            MyApp.applicationContext(),
                            getFileName(),
                            initTables(),
                            databaseType.getDb_version());
                    afterCreateDbHelper(dbHelper);
                }
            }
        }

        return dbHelper;
    }

    protected abstract List<DBTable> initTables();

    protected abstract void beforeCreateDbHelper();

    protected abstract void afterCreateDbHelper(DbHelper dbHelper);
}
