package com.kg.emailclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact")
public class ContactController extends HttpServlet {
    ArrayList<Contact> contactList = new ArrayList<Contact>();
    private String mode = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String forward = "";
        String action = req.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
            case "delete":
                deleteContact(req, resp);
                break;

            case "edit":
                // System.out.println("case= edit");
                showEditForm(req, resp);
                break;

            case "insert":
                showAddForm(req, resp);
                break;

            case "saveorupdate":
                saveorupdate(req, resp);
                break;

            default:
                listContact(req, resp);
                break;
            }
        } catch (ServletException | IOException e) {

            e.printStackTrace();
        }   
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void listContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
         req.setAttribute("contactList", contactList);
        RequestDispatcher view = req.getRequestDispatcher("contact.jsp");
        view.forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showAddForm called");
        RequestDispatcher view = req.getRequestDispatcher("contactuser.jsp");
        view.forward(req, resp);

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showEditForm called");
        mode = "update";
        int id = Integer.parseInt(req.getParameter("userid"));
        System.out.println(id);

        Contact updateContact = new Contact();

        for (Contact contact1 : contactList) {
            if (contact1.getUserid() == id) {
                updateContact = contact1;
                break;
            }

        }
        req.setAttribute("contact", updateContact);
        RequestDispatcher view = req.getRequestDispatcher("contactuser.jsp");
        view.forward(req, resp);
    }

    private void saveorupdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("saveorupdateContact called");

        if (mode != "update") {

            int userid = Integer.parseInt(req.getParameter("userid"));
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            Contact newContact = new Contact(userid, email, phone);
            contactList.add(newContact);

            req.setAttribute("contactList", contactList);
           
        } else {
            System.out.println("edit Contact called arraylist to be updated here");

            int userid = Integer.parseInt(req.getParameter("userid"));
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            Contact updateContact = new Contact(userid, email,phone);

            for (Contact contact2 : contactList) {
                if (contact2.getUserid() == userid) {
                    contactList.set(contactList.indexOf(contact2), updateContact);
                    mode="";
                    break;
                }

            }

        }

        req.setAttribute("contactList", contactList);
        RequestDispatcher view = req.getRequestDispatcher("contact.jsp");
        view.forward(req, resp);

    }

    private void deleteContact(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int contactid = Integer.parseInt(req.getParameter("userid"));
        for (Contact contact2 : contactList) {
            if (contact2.getUserid() == contactid) {

                System.out.println(contact2);
                contactList.remove(contactList.indexOf(contact2));
                break;
            }

        }

        req.setAttribute("contactList", contactList);
        RequestDispatcher view = req.getRequestDispatcher("contact.jsp");
        view.forward(req, resp);
    }

}
