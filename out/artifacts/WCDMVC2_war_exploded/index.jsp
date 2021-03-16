<%--
  Created by IntelliJ IDEA.
  User: nguyenthinhan2410
  Date: 3/16/21
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  </head>
  <body>
  <jsp:useBean id="finder" class="model.ProductDP"/>
    <section>
      <div class="container">
          <h1 class="product_title" style="margin: 20px 0">PRODUCT LIST</h1>
        <span class="alert alert-danger" style="color: red">
              <c:out value="${param.msgSuccess}"/>
          </span>
        <div class="product_content">
          <a href="create.jsp" class="btn btn-primary">Thêm mới sản phẩm</a>
          <table class="table table-stripper">
            <thead>
            <tr>
              <td>ID</td>
              <td>Product Name</td>
              <td>Description</td>
              <td></td>
              <td></td>
              <td></td>

            </tr>
            </thead>
            <tbody>
              <c:forEach var="product" items="${finder.allProduct}">
                <tr>
                  <td><c:out value="${product.id}"/></td>
                  <td><c:out value="${product.name}"/></td>
                  <td><c:out value="${product.desc}"/></td>
                  <td>
                    <form action="product" method="post">
                      <input type="hidden" name="productID" value="${product.id}"/>
                      <input type="submit" onclick="return confirm('Are you sure want to delete : '+${product.name})" class="btn btn-danger" value="Delete" name="action"/>
                    </form>
                  </td>
                  <td>
                    <form action="product" method="post">
                      <input type="hidden" name="productID" value="${product.id}"/>
                      <input type="submit" class="btn btn-danger" value="Update" name="action"/>
                    </form>
                  </td>
                  <td><a class="btn btn-warning" href="product?productID=${product.id}&action=Detail">Chi Tiết</a></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </section>
  </body>

</html>
