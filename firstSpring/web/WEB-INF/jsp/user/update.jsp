<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/2/8
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<!-- 没有action，则代表该页面提交给自身-->
<sf:form method="post" modelAttribute="user">
    Username:<sf:input path="username"/><sf:errors path="username"/> <br>
    Password:<sf:input path="password"/><sf:errors path="password"/><br>
    Email:<sf:input path="email"/><sf:errors path="email"/> <br>
    Nickname:<sf:input path="nickname"/><br>
    <input type="submit" value="提交">
</sf:form>

</body>
</html>
