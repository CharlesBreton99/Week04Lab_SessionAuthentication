<%-- 
    Document   : home
    Created on : Oct 7, 2020, 9:24:50 AM
    Author     : Birdd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Hello ${user.getUsername()}</h2> 
        <form action="home" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
