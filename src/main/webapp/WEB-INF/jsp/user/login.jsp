<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script type="text/javascript">
        // 登录时检查输入项
        function allIsNull(){
            const name = document.loginForm.name.value;
            const pwd = document.loginForm.password.value;
            if( name === ""){
                alert("<spring:message code="alert.username"/>");
                document.loginForm.name.focus();
                return false;
            }
            if(pwd === ""){
                alert("<spring:message code="alert.password"/>");
                document.loginForm.password.focus();
                return false;
            }
            document.loginForm.submit();
            return true;
        }
    </script>
</head>

<body>

<spring:message code="login.name"/><br/>
<a href="${pageContext.request.contextPath}/i18nTest?locale=zh_CN"><spring:message code="language.cn" /></a> --
<a href="${pageContext.request.contextPath}/i18nTest?locale=en_US"><spring:message code="language.en" /></a>
Locale: ${pageContext.response.locale }

<form action="${pageContext.request.contextPath}/user/doLogin" method="post" name="loginForm">
    <spring:message code="login.username"/> <input type="text" name="name"><br/>
    <spring:message code="login.password"/><input type="password" name="password"><br/>
    <input type="button" value="<spring:message code="login.login"/>" onclick="allIsNull()"/>
    <input type="reset" value="<spring:message code="login.reset"/>"/>
</form>

<spring:message code="hello"/>

</body>

</html>
