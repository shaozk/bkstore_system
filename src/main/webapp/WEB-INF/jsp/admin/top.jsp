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
    <style>
        ul{
            /*无黑圆点*/
            list-style-type:none;
            padding: 0;
            margin: 0;
            overflow: hidden;
        }
        li{
            /*横向排列*/
            float:left;
        }
    </style>
</head>
<body>

<a style="float:right" href="${pageContext.request.contextPath}/user/login">登录</a>
<a style="float:right" href="${pageContext.request.contextPath}/user/register">注册</a><br/>

****网上书店管理系统****<br/>

<ul>
    <li><a href="${pageContext.request.contextPath}/index" >首页</a></li>
    <li><a href="" onclick="userManager()">用户管理</a></li>
    <li><a href="">书籍管理</a></li>
    <li><a href="">订单管理</a></li>
</ul>

</body>
</html>
