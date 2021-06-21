<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/18
  Time: 7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>

    <form action="${pageContext.request.contextPath }/admin/addBook" method="post">
        书籍名：<input type="text" name="name"/><br/>
        价格：<input type="text" name="price"/><br/>
        作者：<input type="text" name="author"/><br/>
        isbn：<input type="text" name="isbn"/><br/>
        出版社：<input type="text" name="publisher"/><br/>
        介绍：<input type="text" name="intro"/><br/>
        封面：<input type="text" name="cover"/><br/>
        <input type="submit" value="确定"/>
    </form>

    ${responseResult}

</body>
</html>
