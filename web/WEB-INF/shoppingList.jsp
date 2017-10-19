<%-- 
    Document   : shoppingList
    Created on : Oct 19, 2017, 9:59:09 AM
    Author     : 677571
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List!</h1>
        Hello, ${username}
        <a href='shoppingList?action=logout'>Logout</a><br>
        <h2>List</h2>
        <form action='shoppingList?action=add' method='POST'>
            Add item:<input type='text' name='newItem'>
            <input type='submit' name='submit'>
        </form>
        <form action='shoppingList?action=delete' method='POST'>
            <table>
                <c:forEach var="item" items="${shoppingList}">
                    <tr>
                        <td><input type='checkbox' name='listItems' value='${item.value}'</td>
                        <td>${item.value}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type='submit' value='Delete'>
        </form>
    </body>
</html>
