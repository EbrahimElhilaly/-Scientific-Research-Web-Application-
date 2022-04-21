<%-- 
    Document   : UserForm
    Created on : Jul 12, 2019, 2:36:38 PM
    Author     : Administrator
--%>

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
            <hr width="60%">
            
            <%
                if(request.getAttribute("USER") != null){  // update
                    %>
                       <form  method="post" action="u-u">
                           <input type="hidden" name="UserId" value="${requestScope.USER.getUserId()}"/>
                    <%         
                }else{ // insert
                    %>
                     <form  method="post" action="c-u">
                    <%
                }
             %>
                
                        
                
                <table>

                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td><input type="text" name="UserName" 
                                       required="" title="Name is required" size="20"
                                       value="${requestScope.USER.getUserName()}"    
                                       /></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="UserEmail"
                                       required="" title="Email is required" size="20" 
                                        value="${requestScope.USER.getUserEmail()}"   
                                       /></td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input type="password" name="UserPassword"  
                                       required="" title="Pass is required"  size="20" 
                                        value="${requestScope.USER.getUserPassword()}"   
                                       /></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td></td>
                        </tr>

                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save"/>
                                <a href="l-u">Cancel</a>
                        </tr>

                    </tbody>
                </table>
            </form>

        </div>
        <%@include file="footer.jsp"%>


    </body>
</html>
