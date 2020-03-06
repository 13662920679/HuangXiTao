
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理系统</title>
</head>
<body>
<table align="center" width="1600" height="80"cellpadding="1" cellspacing="1">
    <tr>
        <td height="80" width="1600" style="background-repeat:no-repeat; background-image:url(image/head.jpg)">

        </td>
    </tr>
</table>
<table align="center" width="1600"  cellspacing="1" cellpadding="1" style="background-color: darkorange">
    <tr>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/index.jsp" style="text-decoration:none">首页</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/bookListServlet?category=yq" style="text-decoration:none">言情类</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/bookListServlet?category=wx" style="text-decoration:none">文学类</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/bookListServlet?category=xy" style="text-decoration:none">悬疑类</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/bookListServlet?category=<%=""%>" style="text-decoration:none">书籍浏览</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/loginregister.jsp" style="text-decoration:none">登录</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/loginregister.jsp" style="text-decoration:none">注册</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/bookcar.jsp" style="text-decoration:none">我的书籍</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/myAccountServlet" style="text-decoration:none">我的账户</a></td>
        <td width="160" align="center"><a href="${pageContext.request.contextPath}/myaccountOutServlet" style="text-decoration:none">用户退出</a></td>
    </tr>
</table>
</body>
</html>
