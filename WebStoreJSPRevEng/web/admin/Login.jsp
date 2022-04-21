<%-- 
    Document   : Login
    Created on : Aug 23, 2019, 2:05:27 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>



        <title>Login V17</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/resources/login/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/css/util.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/login/css/main.css">
        <!--===============================================================================================-->




    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" method="post" action="login?ac=login">


                        <%
                            if (request.getAttribute("INVALID_MESSAGE") != null) {%>
                        <script> alert("Invalid User Name or Password");
                            window.location.href = '<%=request.getContextPath()%>/admin/Login.jsp';</script>

                        <%   }
                        %>

                        <span class="login100-form-title p-b-34">
                            Administration Login
                        </span>

                        <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                            <input id="first-name" class="input100" type="text" value="ahmed" name="UserName" required="" title="Please Enter User Name" placeholder="User name">
                            <span class="focus-input100"></span>
                        </div>
                        <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
                            <input class="input100" type="password" name="Password" value="ahmed123" required="" title="Please Enter Password" placeholder="Password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="container-login100-form-btn">
                            <input type="submit" value="Login" class="login100-form-btn"/>


                        </div>

                        <div class="w-full text-center p-t-27 p-b-239">
                            <span class="txt1">

                            </span>

                            <a href="#" class="txt2">

                            </a>
                        </div>


                    </form>

                    <div class="login100-more" style="background-image: url('<%= request.getContextPath()%>/resources/login/images/bg-01.jpg');"></div>
                </div>
            </div>
        </div>



        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="<%= request.getContextPath()%>/resources/login/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="<%= request.getContextPath()%>/resources/login/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="<%= request.getContextPath()%>/resources/login/vendor/bootstrap/js/popper.js"></script>
        <script src="<%= request.getContextPath()%>/resources/login/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="<%= request.getContextPath()%>/resources/login/vendor/select2/select2.min.js"></script>
        <script>
            $(".selection-2").select2({
                minimumResultsForSearch: 20,
                dropdownParent: $('#dropDownSelect1')
            });
        </script>
        <!--===============================================================================================-->
        <script src="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/moment.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/login/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="<%=request.getContextPath()%>/resources/login/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="<%=request.getContextPath()%>/resources/login/js/main.js"></script>


    </body>
</html>
