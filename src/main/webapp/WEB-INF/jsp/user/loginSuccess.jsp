<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginSuccess</title>
</head>
<body>
<spring:message code="setting.success"/>
<a href="${pageContext.request.contextPath}/user/login"><spring:message code="setting.back"/></a>
</body>
</html>
