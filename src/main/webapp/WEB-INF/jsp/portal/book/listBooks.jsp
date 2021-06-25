<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="book.manage"/></title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script>
        // 搜索时检查
        function searchIsNull(){
            const name = document.searchForm.type.value;
            if( name === ""){
                alert("<spring:message code="search.alert"/>");
                document.searchForm.type.focus();
                return false;
            }
            document.searchForm.submit();
            return true;
        }
    </script>
</head>
<body>

<div class="container"><%--栅格系统--%>
    <div class="row clearfix">
        <div class="col-md-12 column"><%--将屏幕分为12份--%>
            <div class="page-header">
                <h1>
                    <small><spring:message code="book.manage"/></small>
                </h1>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/portal/book/toAddBook">
                <spring:message code="setting.add"/>
            </a>
            <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/portal/book/listBooks">
                <spring:message code="setting.all"/>
            </a>
            <div class="btn btn-group mr-2" role="group">
                <a class="btn-default" href="${pageContext.request.contextPath}/i18nTest?locale=zh_CN">
                    <spring:message code="language.cn" />
                </a  >
                <a class="btn-default" href="${pageContext.request.contextPath}/i18nTest?locale=en_US">
                    <spring:message code="language.en" />
                </a>
            </div>

        </div>
        <div class="col-md-8 column">
            <form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/portal/book/search"  method="post" name="searchForm">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" name="type">
                </div>
                <button type="button" class="btn btn-success btn-sm" onclick="searchIsNull()">
                    <spring:message code="setting.search"/>
                </button>
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th ><spring:message code="book.cover"/></th>
                    <th><spring:message code="book.name"/></th>
                    <th><spring:message code="book.author"/></th>
                    <th data-sortable="true"><spring:message code="book.price"/></th>
                    <th><spring:message code="book.type"/></th>
                    <th><spring:message code="book.isbn"/></th>
                    <th><spring:message code="book.publisher"/></th>
                    <%--                    <th><spring:message code="book.intro"/></th>--%>
                    <th><spring:message code="setting.operate"/></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>
                            <!-- 封面显示 -->
                            <img class="cover img-rounded" src="${pageContext.request.contextPath}/portal/book/showCover/${book.cover}" style="width:100px; height: 100px;"/>
                        </td>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.type}</td>
                        <td>${book.isbn}</td>
                        <td>${book.publisher}</td>
                            <%--                        <td>${book.intro}</td>--%>
                        <td>
                            <a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/portal/book/toUpdateBook?id=${book.id}">
                                <spring:message code="setting.update"/>
                            </a>
                            <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/portal/book/deleteBook/${book.id}" onclick="confirm()">
                                <spring:message code="setting.delete"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <span style="color: red;font-weight: bold;margin: 100px auto;text-align: center" >${error}</span>
        </div>
    </div>
</div>


</body>
</html>
