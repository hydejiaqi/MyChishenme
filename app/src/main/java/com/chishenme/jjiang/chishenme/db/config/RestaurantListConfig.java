package com.chishenme.jjiang.chishenme.db.config;

import com.chishenme.jjiang.chishenme.db.DBTable;
import com.chishenme.jjiang.chishenme.db.DatabaseType;
import com.chishenme.jjiang.chishenme.db.DbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjiang on 6/1/2018.
 */

public class RestaurantListConfig extends DbConfig{
    private DbHelper dbHelper;

    public static final String TABLE_NAME = "restaurant_list_table";
    public static final String ID = "id";
    public static final String LIST_NAME = "listname";
    public static final String RESTAURANT_ID = "res_id";

    RestaurantListConfig(DatabaseType databaseType) {
        super(DatabaseType.RESTAURANT);
    }

    @Override
    protected List<DBTable> initTables() {
        List<DBTable> tables = new ArrayList<>();
        try {
            DBTable list = new DBTable(TABLE_NAME);
            list.addIntegerKey(ID, true);
            list.addTextKey(LIST_NAME);
            list.addIntegerKey(RESTAURANT_ID);
            list.join2List(tables);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tables;
    }

    @Override
    protected void beforeCreateDbHelper() {

    }

    @Override
    protected void afterCreateDbHelper(DbHelper dbHelper) {

    }




}
