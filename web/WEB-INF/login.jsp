<%-- 
    Document   : login
    Created on : Oct 7, 2020, 8:24:53 AM
    Author     : Birdd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <p>Username: </p><input type="text" name="username">
            <p>Password: </p><input type="text" name="password">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
