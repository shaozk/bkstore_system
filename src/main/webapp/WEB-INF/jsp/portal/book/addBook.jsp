<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix text-center">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small><spring:message code="book.add"/></small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-left">
            <form:form class='form-group-sm' action="${pageContext.request.contextPath}/portal/book/addBook" method="post" enctype="multipart/form-data" modelAttribute="book">
                <div class="form-group">
                    <label><spring:message code="book.name"/></label>
                    <form:input path="name" type="text" class="form-control" name="name"/>
                    <span style="color: #ff0000;font-weight: bold;margin: 100px auto;text-align: center">${nameMsg }</span>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.author"/></label>
                    <form:input path="author" type="text" class="form-control" name="author"/>
                    <span style="color: red;font-weight: bold;margin: 100px auto;text-align: center">${authorMsg }</span>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.price"/></label>
                    <form:input path="price" type="text" class="form-control" name="price"/>
                    <span style="color: #ff0000;font-weight: bold;margin: 100px auto;text-align: center">${priceMsg }</span>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.type"/></label>
                    <form:input path="type" type="text" class="form-control" name="type" />
                    <span style="color: #ff0000;font-weight: bold;margin: 100px auto;text-align: center">${typeMsg }</span>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.isbn"/></label>
                    <form:input path="isbn" type="text" class="form-control" name="isbn"/>
                    <span style="color: #ff0000;font-weight: bold;margin: 100px auto;text-align: center">${isbnMsg }</span>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.publisher"/></label>
                    <form:input path="publisher" type="text" class="form-control" name="publisher" />
                    <span style="color: #ff0000;font-weight: bold;margin: 100px auto;text-align: center">${pubMsg }</span>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.cover"/></label>
                    <input type="file" name="diff_cover" accept=".jpg, .jpeg, .png"/> <!--name不和Book属性名一样-->
                </div>

                <div class="form-group">
                    <label><spring:message code="book.intro"/></label>
                    <form:textarea path="intro" class='form-control' name='intro'></form:textarea>
                    <span style="color: #ff0000;font-weight: bold;margin: 100px auto;text-align: center">${introMsg }</span>
                </div>

                <div class="form-group">
                    <input class="btn btn-primary btn-sm" type="submit" value="<spring:message code="setting.confirm"/>">
                    <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/portal/book/listBooks" onclick="confirmFunc()">
                        <spring:message code="setting.back"/>
                    </a>
                </div>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>
