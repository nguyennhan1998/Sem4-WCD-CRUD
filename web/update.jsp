<%--
  Created by IntelliJ IDEA.
  User: nguyenthinhan2410
  Date: 3/16/21
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</head>
<body>
<h1>Update Product</h1>
<span class="alert alert-danger" style="color: red; margin: 20px 0">
              <c:out value="${param.msgError}"/>
          </span>
<form action="product" method="post">
    <input type="hidden" value="${requestScope.product.id}" name="productID"/>
    <div class="form-group">
        <label for="">Product Name</label>
        <input type="text" class="form-control" value="${requestScope.product.name}" placeholder="Product Name" name="name"/>
    </div>
    <div class="form-group">
        <label for="">Produc Desc</label>
        <input type="text" class="form-control" value="${requestScope.product.desc}" placeholder="Product Desc" name="desc"/>

    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-primary" value="SubmitUpdate" name="action">
    </div>
    </div>
</form>
</body>
</html>
