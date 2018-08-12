package com.example.myjd.greedaotest.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.myjd.bean.GrennDao_GoodsList;

import com.example.myjd.greedaotest.dao.GrennDao_GoodsListDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig grennDao_GoodsListDaoConfig;

    private final GrennDao_GoodsListDao grennDao_GoodsListDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        grennDao_GoodsListDaoConfig = daoConfigMap.get(GrennDao_GoodsListDao.class).clone();
        grennDao_GoodsListDaoConfig.initIdentityScope(type);

        grennDao_GoodsListDao = new GrennDao_GoodsListDao(grennDao_GoodsListDaoConfig, this);

        registerDao(GrennDao_GoodsList.class, grennDao_GoodsListDao);
    }
    
    public void clear() {
        grennDao_GoodsListDaoConfig.clearIdentityScope();
    }

    public GrennDao_GoodsListDao getGrennDao_GoodsListDao() {
        return grennDao_GoodsListDao;
    }

}