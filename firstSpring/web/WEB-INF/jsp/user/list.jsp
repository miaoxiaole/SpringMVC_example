<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/2/8
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<c:forEach items="${users}" var="um">
    <a href="/user/${um.value.username}">${um.value.username}</a>----${um.value.password}
    <a href="/user/${um.value.username}/update">修改</a>----
    <a href="/user/${um.value.username}/delete">删除</a>
    <br/>
</c:forEach>
<br>
<a href="/user/add">跳转到添加用户界面</a>
</body>
</html>
