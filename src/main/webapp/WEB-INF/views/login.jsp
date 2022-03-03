<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">

    <div class="container">

        <div class="login-box">

            <h2>Login with username and password</h2>

            <c:if test = "${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="POST">

                <c:if test="${not empty error}">
                    <div class="error" style="color: #c9302c">${error}</div>
                </c:if>

                <div class="form-group">

                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" class="form-control" />

                </div>

                <div class="form-group">

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" />

                </div>

                <input type="submit" value="Submit" class="btn btn-default">

                <input type="hidden" name="${_crsf.parameterName}" value="${_crsf.token}"/>

            </form>

        </div>

    </div>


</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>