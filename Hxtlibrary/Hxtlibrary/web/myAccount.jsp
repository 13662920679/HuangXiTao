
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<html>
<head>
    <title>我的账户</title>
</head>
<body>
<center>
    <div style="width:933px; height:726px; background-image: url(image/myAccountBg.jpg); background-repeat: no-repeat; padding-left:80px">
        <div style="padding-top:118px;padding-right: 140px">
            <table width="544" height="399"  cellpadding="1" cellspacing="1" align="center" >
                <tr>
                    <td height="28" colspan="2" align="center"><h2>我的账户信息</h2></td>
                </tr>
                <tr>
                    <td width="199" height="60">用户名</td>
                    <td width="248">${user.username}</td>
                </tr>
                <tr>
                    <td height="57">邮箱</td>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td height="64">密码</td>
                    <td>${user.password}</td>
                </tr>
                <tr>
                    <td height="70">手机号码</td>
                    <td>${user.telephone}</td>
                </tr>
            </table>
        </div>
    </div>
</center>
</body>
</html>
