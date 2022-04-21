<%-- 
    Document   : CategoryList
    Created on : Aug 23, 2019, 8:31:43 AM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="javaee.webstore.jdbc.category.Category"%>
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
                 String message = (String)request.getAttribute("MESSAGE");
                %>
              
                <label style="color: red">  <%= message %>  </label>
                
                <%
                 
            }
        %>
        
        
        </div>
        
         <div align="center">
            <h2>Categories Management</h2>
            <a href="CategoryForm.jsp">Create New Category</a>
        </div>
        
         <br>
        <div align="center">
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>

                <tbody>

                    <%
                        ArrayList<Category> categoriesList = (ArrayList<Category>) request.getAttribute("CATEGORIES_LIST");
                        int serial = 0;
                        for (Category category : categoriesList) {
                            serial++;
                    %> 
                    <tr>
                        <td><%= serial%></td>
                        <td><%= category.getCategoryId()%></td>
                        <td><%= category.getCategoryName()%> </td>
                        <td> <a href="e-c?id=<%= category.getCategoryId()%>">Edit</a>
                             <a href="javascript:confirmDelete(<%=category.getCategoryId()%>)">Delete</a>
                        </td>
                    </tr>


                    <%
                        }
                    %> 








                </tbody>
            </table>


        </div>

        
        <script>
            function confirmDelete(categoryId) {
                if (confirm('Are you sure you want to delete the category with ID ' + categoryId + ' ?'))
                    window.location = 'd-c?id=' + categoryId;
            }
        </script>
        
    </body>
</html>
