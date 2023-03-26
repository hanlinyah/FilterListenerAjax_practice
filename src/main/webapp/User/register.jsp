<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>註冊頁面(cookie & session練習)</title>
    <link href="../css/register.css" rel="stylesheet">
</head>

<body>
<div class="form-div">
  <div class="reg-content">
    <h1>歡迎註冊</h1>
    <span>已有帳號？</span> <a href="./login.jsp">登入</a>
  </div>
  <form id="reg-form" action="./register" method="post">
    <table>
      <tr>
        <td>帳號</td>
        <td class="inputs">
          <input name="username" type="text" id="username">
          <br>
          <span id="username_repeat" class="err_msg" >${registermessage}</span><br>
          <span id="username_err" class="err_msg" style="display: none">帳戶名稱格式不正確</span>
        </td>
      </tr>

      <tr>
        <td>密碼</td>
        <td class="inputs">
          <input name="password" type="password" id="password">
          <br>
          <span id="password_err" class="err_msg" style="display: none">密碼格式不正確</span>
        </td>
      </tr>

      <tr>
        <td>驗證碼</td>
        <td class="inputs">
          <input name="verifyCode" type="text" id="verifyCode">
          <img id="verifyCodeImg" src="./verifyCode" >
          <a href="#" id="changeVerifyCodeImg">換圖片</a>
          <br>
          <span id="velify_err" class="err_msg" >${velifymessage}</span>

        </td>
      </tr>

    </table>
    <div class="buttons">
      <input value="確認註冊" type="submit" id="reg_btn">
    </div>
    <br class="clear">
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="../js/register.js"></script>

</body>
</html>