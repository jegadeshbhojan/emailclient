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

@WebServlet("/inbox")
public class InboxController extends HttpServlet {
    ArrayList<Inbox> inboxList = new ArrayList<Inbox>();
    private String mode = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String forward = "";
        String action = req.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
            case "delete":
                deleteInbox(req, resp);
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
                listInbox(req, resp);
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

    private void listInbox(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // inboxList.add(new Contact(1, "Apple", "9809884280"));
        // inboxList.add(new Contact(2, "Orange", "6464573496239"));
        // inboxList.add(new Contact(3, "Mango", "876523549326496"));
         System.out.println(inboxList);
        req.setAttribute("inboxList", inboxList);
        RequestDispatcher view = req.getRequestDispatcher("inboxdisp.jsp");
        view.forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showAddForm called");
        RequestDispatcher view = req.getRequestDispatcher("inbox.jsp");
        view.forward(req, resp);

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("showEditForm called");
        mode = "update";
        int id = Integer.parseInt(req.getParameter("userid"));
        System.out.println(id);

        Inbox newInbox = new Inbox();

        for (Inbox inbx1 : inboxList) {
            if (inbx1.getUserid() == id) {
                newInbox = inbx1;
                break;
            }

        }
        req.setAttribute("contact", newInbox);
        RequestDispatcher view = req.getRequestDispatcher("inbox.jsp");
        view.forward(req, resp);
    }

    private void saveorupdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("saveorupdateContact called");

        if (mode != "update") {

            int userid = Integer.parseInt(req.getParameter("userid"));
            String date = req.getParameter("date");
            String from = req.getParameter("from");
            String to = req.getParameter("to");
            String subject = req.getParameter("subject");
            String message = req.getParameter("message");
        
            Inbox newInbox = new Inbox(userid,date,from,to,subject,message);
            inboxList.add(newInbox);

            req.setAttribute("inboxList", inboxList);
           
        } else {
            System.out.println("edit Contact called arraylist to be updated here");

            int userid = Integer.parseInt(req.getParameter("userid"));
            String date = req.getParameter("date");
            String from = req.getParameter("from");
            String to = req.getParameter("to");
            String subject = req.getParameter("subject");
            String message = req.getParameter("message");
        
            Inbox newInbox = new Inbox(userid,date,from,to,subject,message);
            inboxList.add(newInbox);

            for (Inbox inbx2 : inboxList) {
                if (inbx2.getUserid() == userid) {
                    inboxList.set(inboxList.indexOf(inbx2), newInbox);
                    break;
                }

            }

        }

        req.setAttribute("inboxList", inboxList);
        RequestDispatcher view = req.getRequestDispatcher("inboxdisp.jsp");
        view.forward(req, resp);

    }

    private void deleteInbox(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int contactid = Integer.parseInt(req.getParameter("userid"));
        for (Inbox inbx2 : inboxList) {
            if (inbx2.getUserid() == contactid) {

                System.out.println(inbx2);
                inboxList.remove(inboxList.indexOf(inbx2));
                break;
            }

        }

        req.setAttribute("", inboxList);
        RequestDispatcher view = req.getRequestDispatcher("inboxdisp.jsp");
        view.forward(req, resp);
    }

}
