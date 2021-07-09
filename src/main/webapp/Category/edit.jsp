<%--
  Created by IntelliJ IDEA.
  User: Windboy
  Date: 07/07/2021
  Time: 8:34 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category Management Application</title>
</head>
<body>
<center>
    <h1>Category Management</h1>
    <h2>
        <a href="/category">List All Category</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Category
                </h2>
            </caption>
            <c:if test="${category != null}">
                <input type="hidden" name="id" value="<c:out value='${category.categoryId}' />"/>
            </c:if>
            <tr>
                <th>Category Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${category.categoryName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category Description:</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${category.categoryDescription}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

