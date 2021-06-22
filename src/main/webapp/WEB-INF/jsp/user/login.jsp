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
                alert("请输入姓名！");
                document.loginForm.name.focus();
                return false;
            }
            if(pwd === ""){
                alert("请输入密码！");
                document.loginForm.password.focus();
                return false;
            }
            document.loginForm.submit();
            return true;
        }
    </script>
</head>

<body>
****用户登录****<br/>
<form action="${pageContext.request.contextPath}/user/doLogin" method="post" name="loginForm">
    用户：<input type="text" name="name"><br/>
    密码：<input type="password" name="password"><br/>
    身份：<select>
            <option value="admin">管理员</option>
            <option value="user">用户</option>
        </select>
    <input type="button" value="登录" onclick="allIsNull()"/>
    <input type="reset" value="重置"/>
</form>


</body>

</html>
