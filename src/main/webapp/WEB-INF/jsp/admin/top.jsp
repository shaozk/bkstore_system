<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/22
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>top</title>
</head>
<body>

<a style="float:right" href="${pageContext.request.contextPath}/user/login" target="frameContentRight">登录</a>
<a style="float:right" href="${pageContext.request.contextPath}/user/register" target="frameContentRight">注册</a><br/>

****网上书店管理系统****<br/>


<ul>
    <li><a href="${pageContext.request.contextPath}/index" >首页</a></li>
    <li><a href="" onclick="userManager()">用户管理</a></li>
    <li><a href="">书籍管理</a></li>
    <li><a href="">订单管理</a></li>
</ul>

</body>
</html>
