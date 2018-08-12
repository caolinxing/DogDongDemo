package com.example.myjd.bean;

public class RegisterBean {
    private String msg;
    private String code;
    private String data;

    public RegisterBean(String msg, String code, String data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public RegisterBean() {
        super();
    }

    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
