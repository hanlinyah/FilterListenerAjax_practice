<%--JSTL 3.0 引入標籤庫--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登入成功(ajax練習)</title>
</head>
<body>
<%
    System.out.println("登入成功");
%>
<h1>${user.username}，歡迎您</h1>
<hr>
<h3 id="edittypetitle">新增/修改數據</h3>
<input type="button" value="新增" id="newbrand">
<input type="button" value="取消" id="cancleedit">
<br>
<form action="" method="post" id="editdata" style="display: none">
    <input type="hidden" name="id" id="id" value=""><br>
    品牌名稱：<input name="brandName" id="brandName"><br>
    企業名稱：<input name="companyName" id="companyName"><br>
    訂單：<input name="ordered" id="ordered"><br>
    品牌介紹：<textarea name="description" rows="5" cols="20" id="description"></textarea><br>
    狀態：
    <input type="radio" name="status" value="0" >禁用
    <input type="radio" name="status" value="1" >啟用<br>
    <input type="button" value="提交" id="submitBrand"  >
    <input type="reset" class="button" value="清除輸入" id="clearedit">
</form>

<hr>
<table id="brandtable" border="1" cellspacing="0" width="800">


</table>
<hr>
<a href="../index.jsp">回測試首頁</a><br>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="../js/Brand.js"></script>
</body>
</html>
