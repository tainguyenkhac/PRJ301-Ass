<%-- 
    Document   : Login
    Created on : Jun 14, 2022, 11:51:09 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/logincss.css" rel="stylesheet" type="text/css"/>
        <script src="../js/loginjs.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="/PRJ-Ass/login" method ="POST">
            <h2><span class="entypo-login"><i class="fa fa-sign-in"></i></span> Login</h2>
            <button class="submit"><span class="entypo-lock"><i class="fa fa-lock"></i></span></button>
            <span class="entypo-user inputUserIcon">
                <i class="fa fa-user"></i>
            </span>
            <input type="text" class="username" name="username" placeholder="ursername"/>
            <span class="entypo-key inputPassIcon">
                <i class="fa fa-key"></i>
            </span>
            <input type="password" class="password" name="password" placeholder="password"/>
        </form>
    </body>
</html>
