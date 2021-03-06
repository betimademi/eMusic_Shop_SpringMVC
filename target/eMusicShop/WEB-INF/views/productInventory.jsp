<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>
            <p class="load">This is the product inventory page</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image" style="width: 15%;height: 15%"></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD</td>
                    <td>
                        <a href="<spring:url value="/productListOriginal/viewProduct/${product.productId}" />">
                            <span class="glyphicon glyphicon-info-sign"></span>
                            <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}" />">
                                <span class="glyphicon glyphicon-remove"></span>
                                <a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}" />">
                                    <span class="glyphicon glyphicon-pencil"></span>
                            </a>

                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct" />" class="btn btn-primary">Add product</a>

        <!-- FOOTER -->
        <%@include file="/WEB-INF/views/template/footer.jsp"%>
