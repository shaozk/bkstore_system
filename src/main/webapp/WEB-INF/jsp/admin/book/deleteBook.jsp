<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/20
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteBook</title>
</head>
<body>
请输入你要删除的书籍id
<form action="${pageContext.request.contextPath}/admin/deleteBook" method="post">
    <input type="text" name="delete">
    <input type="submit" value="确定"/>
</form>

${responseeResult.data}
</body>
</html>
