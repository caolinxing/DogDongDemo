package com.example.myjd.bean;

/**
 * @author user$
 * @version 1.0
 * @date 2018/8/17$ 19:40$
 */
public class EventBusBean {
    private String uid;
    private String pid;
    private String url;
    private String sellerid;
    private String num;
    private String selected;

    public EventBusBean(String uid, String pid, String url, String sellerid, String num, String selected) {
        this.uid = uid;
        this.pid = pid;
        this.url = url;
        this.sellerid = sellerid;
        this.num = num;
        this.selected = selected;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
