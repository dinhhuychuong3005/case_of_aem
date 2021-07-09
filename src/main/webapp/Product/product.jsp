<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Windboy--%>
<%--  Date: 07/07/2021--%>
<%--  Time: 8:34 SA--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Windboy--%>
<%--  Date: 06/07/2021--%>
<%--  Time: 10:50 CH--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--sv--%>
<%--</body>--%>
<%--</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: DEII
  Date: 12/3/2020
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<body>

<center>
    <div class="badge badge-primary text-wrap" style="width: 15rem; font-size: larger; text-align: center">
        PRODUCT MANAGEMENT
    </div><br><br>
    <a href="/admin/admin.jsp" class="btn btn-outline-info">Back to ADMIN</a><br><br>
    <a href="/product?action=create" class="btn btn-outline-info">Create new Product</a><br><br>
</center>
<table class="table table-hover">
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Provide</td>
        <td>Description</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Image</td>
        <td>Category ID</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items='${requestScope["list"]}' var="productDAO">
    <tr>
        <td>${productDAO.productId}</td>
        <td>${productDAO.productName}</td>
        <td>${productDAO.productPrice}</td>
        <td>${productDAO.productColor}</td>
        <td>${productDAO.productQuantity}</td>
        <td>${productDAO.productDescription}</td>
        <td><img src="${productDAO.productImage}"style="max-width: 35%;max-height: 35%;" alt="${productDAO.getProductName()}"></td>
        <td>${productDAO.categoryID}</td>
        <td><a href="/product?action=edit&id=${productDAO.productId}">Edit</a></td>
        <td><a href="/product?action=delete&id=${productDAO.productId}">Delete</a></td>
    </tr>
    </c:forEach>
    </tr>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>

