<%--
  Created by IntelliJ IDEA.
  User: nguyenthinhan2410
  Date: 3/17/21
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
    <h1>Product Detail</h1>
    <p>Product Name : ${requestScope.product.name}</p>
    <p>Product Description : ${requestScope.product.desc}</p>
</body>
</html>
