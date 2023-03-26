<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Filter & Listener & Ajax practice</h2>
</body>
<%
    System.out.println("過濾器鏈測試");
%>
<a href="./User/login.jsp">練習1:透過Filter過濾未登入用戶之訪問</a><br>
練習2:運用Ajax獲取數據
<input id="ajaxDemo01Text" type="text">
<input type="button" value="取得時間" id="ajaxDemo01Gettime"><br>
<a href="./User/register.jsp">練習3:透過ajax(axios)於註冊階段響應已重複之用戶名</a><br>
<a href="./User/login.jsp">練習4:運用Ajax(JSON格式)發送請求進行資料庫CRUD並回顯數據</a><br>
<hr>
<script src="./js/ajaxDemo01.js"></script>
</html>
