
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>登录注册表单</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Meta-Tags -->

    <!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
    <%
        String username="";
        String password="";
        Cookie[] cookies=request.getCookies();
        for (int i=0;i<cookies.length;i++){
            if ("username".equals(cookies[i].getName())){
                username=cookies[i].getValue();
            }else if ("password".equals(cookies[i].getName())){
                password=cookies[i].getValue();
            }
        }
    %>


</head>
<!-- //Head -->

<!-- Body -->
<body>
<h1>登录注册表单</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <span style="color: crimson">${login_msg}</span>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
            <input type="text" name="username" placeholder="用户名" value="<%= username%>">
            <input type="password" name="password"  placeholder="密码" value="<%= password%>">
            <ul class="tick w3layouts agileits">
                <li>
                    <input type="checkbox" id="brand1" name="remember" checked="checked">
                    <label for="brand1"><span></span>记住我</label>
                </li>
            </ul>
            <div class="send-button w3layouts agileits">
                <input type="submit" value="登 录">
            </div>
        </form>
        <a href="#">忘记密码?</a>
        <div class="social-icons w3layouts agileits">
            <p>- 其他方式登录 -</p>
            <ul>
                <li class="qq"><a href="#">
                    <span class="icons w3layouts agileits"></span>
                    <span class="text w3layouts agileits">QQ</span></a></li>
                <li class="weixin w3ls"><a href="#">
                    <span class="icons w3layouts"></span>
                    <span class="text w3layouts agileits">微信</span></a></li>
                <li class="weibo aits"><a href="#">
                    <span class="icons agileits"></span>
                    <span class="text w3layouts agileits">微博</span></a></li>
                <div class="clear"> </div>
            </ul>
        </div>
        <div class="clear"></div>
    </div>


    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form action="${pageContext.request.contextPath}/registerServlet" method="post">
            <input type="text"  name="username" placeholder="用户名">
            <input type="text" name="email" placeholder="邮箱">
            <input type="password" name="password" placeholder="密码">
            <input type="text" name="telephone" placeholder="手机号码" >
            <div class="send-button w3layouts agileits">
                <input type="submit" value="免费注册">
            </div>
        </form>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>

</div>

<div class="footer w3layouts agileits">
    <p>Copyright &copy; More Templates</p>
</div>
<div style="text-align:center;">

</div>

</body>
</html>