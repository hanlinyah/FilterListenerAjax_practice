<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登入頁面(cookie & session練習)</title>
    <link href="../css/login.css" rel="stylesheet">
</head>
<body>
<div id="loginDiv">
    <form action="./login" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="registermessage">${registermessage}</div>
        <div id="loginmessage">${loginmessage}</div>
        <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>
        <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
        <p>記住我:<input id="rememberme" name="rememberme" value="1" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="登入">
            <input type="reset" class="button" value="清除輸入">&nbsp;&nbsp;&nbsp;
            <a href="./register.jsp">註冊帳號</a>
        </div>
    </form>
</div>

</body>
</html>