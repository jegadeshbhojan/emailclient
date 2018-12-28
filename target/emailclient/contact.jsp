
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WELCOME TO kGISL REGISTRATION SECTION</title>
</head>
<style>
        body {background-color: navajowhite;}
        thead   {color: blue;}
        tbody  {color: red;}
        </style>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Email</th>
                <th>Phone number</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${contactList}" var="user">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.phone}" /></td>
                    <td><a href="contact?action=edit&userid=<c:out value="${user.userid}"/>">Update</a></td>
                    
                    <td><a href="contact?action=delete&userid=<c:out value="${user.userid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="/contact?action=insert">Add User</a></p>
</body>
</html>