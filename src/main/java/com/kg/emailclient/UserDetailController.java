package com.kg.emailclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserDetailController")
public class UserDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ArrayList<UserDetail> UserDetailsList = new ArrayList<UserDetail>();
    List<Inbox> inboxListuser1 = new ArrayList<Inbox>();
    List<Contact> contactListuser1 = new ArrayList<Contact>();

    List<Inbox> inboxListuser2 = new ArrayList<Inbox>();
    List<Contact> contactListuser2 = new ArrayList<Contact>();

    Inbox inbox1 = new Inbox(1, "date1", "from1", "to1", "subject1", "message1");
    Inbox inbox11 = new Inbox(1, "date11", "from11", "to11", "subject11", "message11");
    Inbox inbox2 = new Inbox(2, "date2", "from2", "to2", "subject2", "message2");

    Contact contact1 = new Contact(1, "email", "phone");
    Contact contact2 = new Contact(2, "email22", "phone22");
    Contact contact22 = new Contact(2, "email22", "phone22");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserController doget called");

        inboxListuser1.add(inbox1);
        inboxListuser1.add(inbox11);
        contactListuser1.add(contact1);

        inboxListuser2.add(inbox2);
        contactListuser2.add(contact2);
        contactListuser2.add(contact22);

        UserDetailsList.add(new UserDetail(1, inboxListuser1, contactListuser1));
        UserDetailsList.add(new UserDetail(2, inboxListuser2, contactListuser2));
        System.out.println(UserDetailsList);

        System.out.println("######################");

        List<UserDetail> userinbox = UserDetailsList.stream().filter(x -> 2 == x.getUserid())
                .collect(Collectors.toList());
        System.out.println(userinbox);

    }

}