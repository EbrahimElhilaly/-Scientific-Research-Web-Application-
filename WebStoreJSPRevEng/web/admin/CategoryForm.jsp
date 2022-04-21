<%-- 
    Document   : CategoryForm
    Created on : Aug 23, 2019, 8:35:51 AM
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

        <div align="center">
            <hr width="60%">
            
            <%
                if(request.getAttribute("CATEGORY") != null){  // update
                    %>
                       <form  method="post" action="u-c">
                           <input type="hidden" name="CategoryId" value="${requestScope.CATEGORY.getCategoryId()}"/>
                    <%         
                }else{ // insert
                    %>
                     <form  method="post" action="c-c">
                    <%
                }
             %>
                
                        
                
                <table>

                    <tbody>
                        <tr>
                            <td>Category Name</td>
                            <td><input type="text" name="CategoryName" 
                                       required="" title="Name is required" size="20"
                                       value="${requestScope.CATEGORY.getCategoryName()}"    
                                       /></td>
                        </tr>

                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save"/>
                                <a href="l-c">Cancel</a>
                        </tr>

                    </tbody>
                </table>
            </form>

        </div>
        <%@include file="footer.jsp"%>
        
    </body>
</html>
