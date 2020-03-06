
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>
<html>
<head>
    <title>图书管理系统</title>
</head>
<body>
<table width="1600"  height="545" align="center">
    <tr>
        <c:forEach var="b" items="${book}" varStatus="status">
            <td width="395" height="462"><a href="${pageContext.request.contextPath}/bookCarServlet?id=${b.id}"><span><input type="image" src="${b.image}"></span></a>
           <div><a href="${pageContext.request.contextPath}/bookCarServlet?id=${b.id}"><span style="color: red">书籍名称：${b.name}</span></a></div>
            <div><a href="${pageContext.request.contextPath}/bookCarServlet?id=${b.id}"><span style="color: red">书籍价格：${b.price}￥</span></a></div>
        </td>
            <c:if test="${status.count % 3 == 0}">
           </tr>
        <tr>
        </c:if>
        </c:forEach>
        </tr>
</table>
</body>
</html>
