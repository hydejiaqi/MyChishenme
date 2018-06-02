package com.chishenme.jjiang.chishenme.db;

import org.jetbrains.annotations.TestOnly;

import java.util.List;

/**
 * Created by jjiang on 6/1/2018.
 */

public class DBTable {
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
    private static final String COMMA_SEP = ",";
    private static final String PROPERTY_BEGIN = " (";
    private static final String PROPERTY_END = ")";
    public static final String PRIMARY_KEY = " PRIMARY KEY";
    public static final String TEXT_TYPE = " TEXT";
    public static final String INTEGER_TYPE = " INTEGER";
    public static final String VCHAR_TYPE = " VCHAR";
    public static final String DOUBLE_TYPE = " DOUBLE";
    private static final String LONG_TYPE = " LONG";
    public static final String TINYINT_TYPE = " TINYINT(%d)";
    private String tableName;
    private String primaryKey = "";
    private StringBuffer keys = new StringBuffer();


    public String toSQL() {
        StringBuffer sb = new StringBuffer();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(this.tableName);
        sb.append(" (");
        sb.append(this.primaryKey);
        sb.append(this.keys);
        sb.append(")");
        return sb.toString().replace(",)", ")");
    }
    public DBTable(String tableName) throws Exception {
        if(null != tableName && !"".equals(tableName)) {
            this.tableName = tableName;
        } else {
            throw new Exception("need a not empty table name");
        }
    }

    public void addTextKey(String key) {
        this.keys.append(key);
        this.keys.append(" TEXT");
        this.keys.append(",");
    }

    public void addTextKey(String key, boolean primary) {
        if(primary) {
            this.primaryKey = key + " TEXT" + " PRIMARY KEY" + ",";
        } else {
            this.addTextKey(key);
        }

    }

    public void addIntegerKey(String key) {
        this.keys.append(key);
        this.keys.append(" INTEGER");
        this.keys.append(",");
    }

    public void addIntegerKey(String key, boolean primary) {
        if(primary) {
            this.primaryKey = key + " INTEGER" + " PRIMARY KEY" + ",";
        } else {
            this.addTextKey(key);
        }

    }

    public void addVCharKey(String key) {
        this.keys.append(key);
        this.keys.append(" VCHAR");
        this.keys.append(",");
    }

    public void addVCharKey(String key, boolean primary) {
        if(primary) {
            this.primaryKey = key + " VCHAR" + " PRIMARY KEY" + ",";
        } else {
            this.addTextKey(key);
        }

    }

    public void addBooleanKey(String key) {
        this.keys.append(key);
        this.keys.append(" INTEGER");
        this.keys.append(",");
    }

    public void addDoubleKey(String key) {
        this.keys.append(key);
        this.keys.append(" DOUBLE");
        this.keys.append(",");
    }

    public void addDoubleKey(String key, boolean primary) {
        if(primary) {
            this.primaryKey = key + " DOUBLE" + " PRIMARY KEY" + ",";
        } else {
            this.addTextKey(key);
        }

    }

    public void addLongKey(String key) {
        this.keys.append(key);
        this.keys.append(" LONG");
        this.keys.append(",");
    }

    public void addLongKey(String key, boolean primary) {
        if(primary) {
            this.primaryKey = key + " LONG" + " PRIMARY KEY" + ",";
        } else {
            this.addTextKey(key);
        }

    }

    public void addTinyIntKey(String key, int max) {
        this.keys.append(key);
        this.keys.append(String.format(" TINYINT(%d)", new Object[]{Integer.valueOf(max)}));
        this.keys.append(",");
    }

    public void join2List(List<DBTable> list) {
        if(null != list) {
            list.add(this);
        }

    }

   /* @TestOnly
    public void tableTest() {
        try {
            DBTable dbTable = new DBTable("TestTable");
            dbTable.addIntegerKey("aaa");
            dbTable.addIntegerKey("bbbb", true);
            dbTable.addTextKey("ccc");
            dbTable.addTinyIntKey("ttt", 5);
            System.out.println(dbTable.toString());
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }*/
}
