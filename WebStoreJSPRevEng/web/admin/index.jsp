<%-- 
    Document   : index
    Created on : Jul 12, 2019, 2:04:08 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
	  
         <%@include file="header.jsp"%>
        <br><br>
        <div align="center">
            Administrative Dashboard
        </div>

        <div align="center">
            <hr width="60%">
            <h2>Quick Actions</h2>
            <hr width="60%">
            <a href="">New Book</a> |
            <a href="">New User</a> |
            <a href="">New Category</a> |
            <a href="">New Customer</a> |
        </div>

        <div align="center">
            <h2>Recent Sales</h2>
            <hr width="60%">
        </div>

        <div align="center">
            <h2>Recent Reviews</h2>
            <hr width="60%">
        </div>

        <div align="center">
            <h2>Statistics</h2>
            <hr width="60%">
        </div> 

         <%@include file="footer.jsp"%>
    </body>
</html>
