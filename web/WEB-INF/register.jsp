<%-- 
    Document   : register.jsp
    Created on : Oct 19, 2017, 9:58:56 AM
    Author     : 677571
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List!</h1>
        <form action='shoppingList?action=register' method='POST'>
            Username:<input type='text' name='username'>
            <input type='submit' name='submit'>
        </form>
        ${errorMessage}
    </body>
</html>
