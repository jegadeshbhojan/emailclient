package com.kg.emailclient;

/**
 * User
 */
public class User {

    private int userid;
    private String email;
    private String password;

    User(){}
    User(int userid,String email,String password){
        this.userid=userid;
        this.email=email;
        this.password=password;
    }
    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }
    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return userid+email+password;
    }
}