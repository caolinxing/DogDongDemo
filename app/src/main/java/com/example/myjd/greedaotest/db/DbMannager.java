package com.example.myjd.greedaotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myjd.greedaotest.dao.DaoMaster;
import com.example.myjd.greedaotest.dao.DaoSession;

public class DbMannager {
    public static final boolean ENCRYPTED = true;
    private static final String DB_NAME = "baway.db";
    private static DbMannager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private Context mContext;

    private DbMannager(Context context) {
        this.mContext = context;
        // 初始化数据库信息
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }

    public static DbMannager getInstance(Context context) {
        if (null == mDbManager) {
            synchronized (DbMannager.class) {
                if (null == mDbManager) {
                    mDbManager = new DbMannager(context);
                }
            }
        }
        return mDbManager;
    }

    /**
     * 获取可读数据库
     */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     */
    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }

        return mDevOpenHelper.getWritableDatabase();
    }

    /**
     * 获取DaoMaster
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DbMannager.class) {
                if (null == mDaoMaster) {
                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
                }
            }
        }
        return mDaoMaster;
    }


    /**
     * 获取DaoSession
     */
    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DbMannager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }

}
