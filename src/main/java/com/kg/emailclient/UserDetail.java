package com.kg.emailclient;

import java.util.List;

/**
 * UserDetail
 */
public class UserDetail {

    private int userid;
    private List<Inbox> inboxes;
    private List<Contact> contacts;

    UserDetail() {
    }

    UserDetail(int userid, List<Inbox> inboxes, List<Contact> contacts) {
        this.userid = userid;
        this.setInboxes(inboxes);
        this.contacts = contacts;
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
     * @return the inboxes
     */
    public List<Inbox> getInboxes() {
        return inboxes;
    }

    /**
     * @param inboxes the inboxes to set
     */
    public void setInboxes(List<Inbox> inboxes) {
        this.inboxes = inboxes;
    }

    /**
     * @return the contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param contacts the contacts to set
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return userid + inboxes.toString() + contacts;
    }
}