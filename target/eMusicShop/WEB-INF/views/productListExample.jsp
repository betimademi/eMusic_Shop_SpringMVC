<%--
  Created by IntelliJ IDEA.
  User: Betim
  Date: 2/17/2022
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>

        <thead>
        <tr>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Product Category</th>
        <th>Product Price</th>
        <th>Product Condition</th>
        <th>Product Status</th>
        <th>Product InStock</th>
        <th>Product Manufacturer</th>
        </tr>
        </thead>
        <tr>
            <td>${product.productName}</td>
            <td>${product.productDescription}</td>
            <td>${product.productCategory}</td>
            <td>${product.productPrice}</td>
            <td>${product.productCondition}</td>
            <td>${product.productStatus}</td>
            <td>${product.unitInStock}</td>
            <td>${product.productManufacturer}</td>
        </tr>

    </table>
</body>
</html>
