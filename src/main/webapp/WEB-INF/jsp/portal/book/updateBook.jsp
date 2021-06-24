
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateBook</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script>

        function confirmFunc() {
        }

        function allIsNull() {
            const name = document.addForm.name.value;
            const author = document.addForm.author.value;
            const price = document.addForm.price.value;
            const type = document.addForm.type.value;
            const isbn = document.addForm.isbn.value;
            const publisher = document.addForm.publisher.value;
            const intro = document.addForm.intro.value;
            if( name === ""){
                alert("<spring:message code="book.alert.name"/>");
                document.addForm.name.focus();
                return false;
            }
            if( author === ""){
                alert("<spring:message code="book.alert.author"/>");
                document.addForm.author.focus();
                return false;
            }
            if( price === ""){
                alert("<spring:message code="book.alert.price"/>");
                document.addForm.price.focus();
                return false;
            }
            if( type === ""){
                alert("<spring:message code="book.alert.type"/>");
                document.addForm.type.focus();
                return false;
            }
            if( isbn === ""){
                alert("<spring:message code="book.alert.isbn"/>");
                document.addForm.isbn.focus();
                return false;
            }
            if( publisher === ""){
                alert("<spring:message code="book.alert.publisher"/>");
                document.addForm.name.focus();
                return false;
            }
            if( intro === ""){
                alert("<spring:message code="book.alert.intro"/>");
                document.addForm.isbn.focus();
                return false;
            }
            document.addForm.submit();
            return true;
        }
    </script>
</head>
<body>

<div class="container">

    <div class="row clearfix text-center">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small><spring:message code="book.update"/></small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-4 text-left">
            <form class='form-group-sm' action="${pageContext.request.contextPath}/portal/book/updateBook" method="post" enctype="multipart/form-data" name="addForm">
                <input type="text" name="id" value="${book.id}" hidden="hidden">
                <div class="form-group">
                    <label><spring:message code="book.name"/></label>
                    <input type="text" class="form-control" name="name" placeholder="<spring:message code="book.name"/>" value="${book.name}" />
                </div>

                <div class="form-group">
                    <label><spring:message code="book.author"/></label>
                    <input type="text" class="form-control" name="author" placeholder="<spring:message code="book.author"/>" value="${book.author}"/>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.price"/></label>
                    <input type="number" class="form-control" name="price" placeholder="<spring:message code="book.price"/>" value="${book.price}"/>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.type"/></label>
                    <input type="text" class="form-control" name="type" placeholder="<spring:message code="book.type"/>" value="${book.type}"/>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.isbn"/></label>
                    <input type="number" class="form-control" name="isbn" placeholder="<spring:message code="book.isbn"/>" value="${book.isbn}"/>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.publisher"/></label>
                    <input type="text" class="form-control" name="publisher" placeholder="<spring:message code="book.publisher"/>" value="${book.publisher}"/>
                </div>

                <div class="form-group">
                    <label><spring:message code="book.cover"/></label>
                    <input type="file" name="diff_cover" accept=".jpg, .jpeg, .png"/> <!--name不和Book属性名一样-->
                </div>

                <div class="form-group">
                    <label><spring:message code="book.intro"/></label>
                    <textarea class='form-control' name='intro'> ${book.intro}"</textarea>
                </div>

                <div class="form-group">
                    <input class="btn btn-warning btn-sm" type="button" value="<spring:message code="setting.confirm"/>" onclick="allIsNull()">
                    <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/portal/book/listBooks" onclick="confirmFunc()">
                        <spring:message code="setting.cancel"/>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
