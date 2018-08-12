package com.example.myjd.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author user
 * @version 1.0
 * @date 2018/8/11$ 17:28$
 */
@Entity
public class GrennDao_GoodsList {
    /**
     * cid : 1
     * createtime : 2017-10-10T19:41:39
     * icon : http://120.27.23.105/images/category/shop.png
     * ishome : 1
     * name : 京东超市
     */

    private int cid;
    private String createtime;
    private String icon;
    private int ishome;
    private String name;
    @Generated(hash = 689428199)
    public GrennDao_GoodsList(int cid, String createtime, String icon, int ishome,
            String name) {
        this.cid = cid;
        this.createtime = createtime;
        this.icon = icon;
        this.ishome = ishome;
        this.name = name;
    }
    @Generated(hash = 1957074928)
    public GrennDao_GoodsList() {
    }
    public int getCid() {
        return this.cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getCreatetime() {
        return this.createtime;
    }
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public int getIshome() {
        return this.ishome;
    }
    public void setIshome(int ishome) {
        this.ishome = ishome;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
