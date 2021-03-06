package com.example.myjd.greedaotest.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.myjd.bean.GrennDao_GoodsList;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GRENN_DAO__GOODS_LIST".
*/
public class GrennDao_GoodsListDao extends AbstractDao<GrennDao_GoodsList, Void> {

    public static final String TABLENAME = "GRENN_DAO__GOODS_LIST";

    /**
     * Properties of entity GrennDao_GoodsList.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Cid = new Property(0, int.class, "cid", false, "CID");
        public final static Property Createtime = new Property(1, String.class, "createtime", false, "CREATETIME");
        public final static Property Icon = new Property(2, String.class, "icon", false, "ICON");
        public final static Property Ishome = new Property(3, int.class, "ishome", false, "ISHOME");
        public final static Property Name = new Property(4, String.class, "name", false, "NAME");
    }


    public GrennDao_GoodsListDao(DaoConfig config) {
        super(config);
    }
    
    public GrennDao_GoodsListDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GRENN_DAO__GOODS_LIST\" (" + //
                "\"CID\" INTEGER NOT NULL ," + // 0: cid
                "\"CREATETIME\" TEXT," + // 1: createtime
                "\"ICON\" TEXT," + // 2: icon
                "\"ISHOME\" INTEGER NOT NULL ," + // 3: ishome
                "\"NAME\" TEXT);"); // 4: name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GRENN_DAO__GOODS_LIST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GrennDao_GoodsList entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCid());
 
        String createtime = entity.getCreatetime();
        if (createtime != null) {
            stmt.bindString(2, createtime);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(3, icon);
        }
        stmt.bindLong(4, entity.getIshome());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GrennDao_GoodsList entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCid());
 
        String createtime = entity.getCreatetime();
        if (createtime != null) {
            stmt.bindString(2, createtime);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(3, icon);
        }
        stmt.bindLong(4, entity.getIshome());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public GrennDao_GoodsList readEntity(Cursor cursor, int offset) {
        GrennDao_GoodsList entity = new GrennDao_GoodsList( //
            cursor.getInt(offset + 0), // cid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // createtime
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // icon
            cursor.getInt(offset + 3), // ishome
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GrennDao_GoodsList entity, int offset) {
        entity.setCid(cursor.getInt(offset + 0));
        entity.setCreatetime(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIcon(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIshome(cursor.getInt(offset + 3));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(GrennDao_GoodsList entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(GrennDao_GoodsList entity) {
        return null;
    }

    @Override
    public boolean hasKey(GrennDao_GoodsList entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
