
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="carhead.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<table width="605" >
    <c:forEach items="${car}" var="car" varStatus="h">
    <tr style="background-color: chartreuse">
        <td width="148">序号：${h.count}</td>
        <td width="148" height="36">图书名称:${car.key.name}</td>
        <td width="141">图书价格：${car.key.price}</td>
        <td width="158">图书数量：${car.value}</td>
        <td width="148">小计：${car.key.price * car.value}</td>
    </tr>
    </c:forEach>
</table>
<table width="605">
    <tr>
        <td width=</td>
        <td width="148" height="36"></td>
        <td width="141"></td>
        <td width="158"></td>
        <td width="148" style="background-color: chocolate;color: chartreuse" align="center"><a href="#" style="text-decoration: none">提交订单</a></td>
    </tr>
</table>
</center>
</body>
</html>
