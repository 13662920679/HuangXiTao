<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	 <base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>注册</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<div align="center">
		<div style="margin:20px 0;" ></div>
		<div class="easyui-panel" title="注册" style="width:400px;padding:10px 60px 20px 60px;" >
		<form action="UserServlet" method="post" >
			<input type="hidden" name="oper" value="reg" />
			<table cellpadding="5">
				<tr>
					<td>账号:</td>
					<td><input name="uid" class="easyui-validatebox textbox" data-options="required:true"  missingMessage="账号必填"></td>
				</tr>
				
				<tr>
					<td>用户名:</td>
					<td><input name="uname" class="easyui-validatebox textbox" data-options="required:true"  missingMessage="用户名必填"></td>
				</tr>
				
				<tr>
					<td>密码:</td>
					<td><input name="upwd" type="password" class="easyui-validatebox textbox" data-options="required:true" missingMessage="密码必填"></td>
				</tr>
				
				
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="注册" /><label><a href="login.jsp">已有账号，去登录</a></label>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
		
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>

</body>
</html>