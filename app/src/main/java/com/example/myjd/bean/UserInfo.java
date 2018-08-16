package com.example.myjd.bean;

/**
 * 用户实体类
 */
public class UserInfo {
    private String userName;//用户名
    private String pwd;//密码
    private String address;//地址
    private String phone;//手机号
    private String uid;//手机号
    private String token;//手机号


    public UserInfo() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public UserInfo(String userName, String pwd, String address, String phone) {
        this.userName = userName;
        this.pwd = pwd;
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
