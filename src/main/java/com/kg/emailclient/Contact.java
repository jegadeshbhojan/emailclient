package com.kg.emailclient;

/**
 * Contact
 */
public class Contact {

    private int userid;
    private String email;
    private String phone;

    Contact() {
    }

    Contact(int userid, String email, String phone) {
        this.userid = userid;
        this.email = email;
        this.phone = phone;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "userid:"+userid + ", email:"+email + ", phone:"+phone;
    }

	public int getContactid() {
		return 0;
	}
}
