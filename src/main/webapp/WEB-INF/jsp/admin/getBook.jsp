<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/18
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getBook</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/admin/getBook">
    书籍id：<input type="text" name="bookId">
    <input type="submit" value="搜索">
</form>
${responseResult}

</body>
</html>
