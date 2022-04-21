<%-- 
    Document   : UsersList
    Created on : Jul 12, 2019, 2:29:35 PM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="javaee.webstore.jdbc.users.User"%>
<%@page import="javaee.webstore.jdbc.users.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        
        
        
        
        
        <%@include file="header.jsp"%>

        <div align="center">
            <%
                if (request.getAttribute("MESSAGE") != null) {
                    String message = (String) request.getAttribute("MESSAGE");
            %>

            <label style="color: red">  <%= message%>  </label>

            <%

                }
            %>

        </div>

        <div align="center">
            <h2>Users Management</h2>
            <a href="UserForm.jsp">Create New User</a>
        </div>

        <br>
        <div align="center">
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>

                <tbody>

                    <%
                        ArrayList<User> usersList = (ArrayList<User>) request.getAttribute("USERS_LIST");
                        int serial = 0;
                        for (User user : usersList) {
                            serial++;
                    %> 
                    <tr>
                        <td><%= serial%></td>
                        <td><%= user.getUserId()%></td>
                        <td><%= user.getUserName()%> </td>
                        <td><%= user.getUserEmail()%></td>
                        <td> <a href="e-u?id=<%= user.getUserId()%>">Edit</a>
                            <a href="javascript:confDelete(<%= user.getUserId()%>)">Delete</a>
                        </td>
                    </tr>


                    <%
                        }
                    %> 








                </tbody>
            </table>


        </div>

        <br><br><br><br>
        <%@include file="footer.jsp"%>


        <script>
            function confDelete(userId) {
                if (confirm('Are you sure you want to delete the user with ID ' + userId + ' ?'))
                    window.location = 'd-u?id=' + userId;
            }
        </script>


    </body>
</html>
