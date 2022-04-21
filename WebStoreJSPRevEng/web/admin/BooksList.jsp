<%-- 
    Document   : BooksList
    Created on : Aug 23, 2019, 3:55:02 PM
    Author     : Administrator
--%>

<%@page import="javaee.webstore.jdbc.books.Book"%>
<%@page import="java.util.ArrayList"%>
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
                        <th>Index</th>
                        <th>Id</th>
                        <th>Book Image</th>
                        <th>Book Title</th>
                        <th>Book Author</th>
                        <th>Book Category</th>
                        <th>Book Price</th>
                        <th>Last Updated</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Book> booksList = (ArrayList<Book>) request.getAttribute("BOOKS_LIST");
                            int serial = 0;
                        for (Book book : booksList) {
                            serial++;
                    %>
                     <tr>
                        <td><%= serial%></td>
                        <td><%= book.getBookId()%></td>
                        <td><img width="64px" height="64px" src="data:image/jpg;base64,<%= book.getBase64Image()%>"</td>
                        <td><%= book.getBookTitle()%></td>
                        <td><%= book.getBookAuthor()%></td>
                        <td><%= book.getCategory().getCategoryName()%></td>
                        <td><%= book.getBookPrice()%></td>
                        <td><%= book.getLastUpdateTime()%></td>
                        <td>
                            <a href="e-b?id=<%=book.getBookId()%>">Edit</a> &nbsp;
                            <a href="javascript:confirmDelete(<%=book.getBookId()%>)">Delete</a>
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
            function confDelete(bookId) {
                if (confirm('Are you sure you want to delete the book with ID ' + bookId + ' ?'))
                    window.location = 'd-b?id=' + bookId;
            }
        </script>


        
        
    </body>
</html>
