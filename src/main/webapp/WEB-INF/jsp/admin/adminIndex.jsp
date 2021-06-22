<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上书店管理系统</title>
</head>
<body>
<div>
    <%--头部--%>
    <div name="top">
        <%@include file="top.jsp" %>
    </div>

    <%--主要内容--%>
    <div name="main">
        <%@include file="main.jsp"%>
    </div>

    <%--尾部--%>
    <div name="footer">
        <%@include file="footer.jsp" %>
    </div>
</div>

</body>
</html>
