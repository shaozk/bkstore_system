<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上书店管理系统</title>
    <style>
        body
        {
            margin: 0;
            padding: 0;
            border: 0;
            overflow: hidden;
            height: 100%;
            max-height: 100%;
        }

        #frameTop
        {
            position: absolute;
            top: 0;
            left: 0;
            height: 100px;
            width: 100%;
            overflow: hidden;
            vertical-align: middle;
        }

        #frameContentLeft
        {
            position: fixed;
            top: 100px;
            left: 0;
            height: 100%;
            width: 150px;
            overflow: hidden;
            vertical-align: top;
            background-color: #D2E6FA;
        }

        #frameContentRight
        {
            position: absolute;
            left: 150px;
            top: 100px;
            height: 100%;
            width: 100%;
            right: 0;
            bottom: 0;
            overflow: hidden;
            background: #fff;
        }
    </style>
</head>
<body>
<div>
    <div>
        <iframe id="frameTop" src="${pageContext.request.contextPath}/admin/book/top"></iframe>
    </div>

    <div>
        <iframe id="frameContentLeft" src="${pageContext.request.contextPath}/admin/book/left"></iframe>
        <iframe id="frameContentRight" src="${pageContext.request.contextPath}/admin/book/main"></iframe>
    </div>
</div>

</body>
</html>
