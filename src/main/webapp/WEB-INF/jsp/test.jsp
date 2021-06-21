<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/18
  Time: 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/testHello" method="post">
    <input type="submit" value="测试">
</form>
    ${responseResult.message}
</body>
</html>
