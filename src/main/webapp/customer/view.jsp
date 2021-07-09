<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Windboy
  Date: 08/07/2021
  Time: 9:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<form action="/customers" method="post">
  <input type="hidden" name="action" value="edit">
 <c:forEach items="${customers}" var="customer">
   <input type="text" name="id" value="${customer.customerID}">
   <input type="text" name="name" value="${customer.customerName}">
   <input type="text" name="age" value="${customer.customerPhone}">
   <input type="text" name="age" value="${customer.customerEmail}">
   <input type="text" name="age" value="${customer.userName}">
   <input type="text" name="age" value="${customer.password}">
 </c:forEach>
  <button>come back</button>
</form>
</form>
</body>
</html>
