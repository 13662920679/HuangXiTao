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
	<title>Basic ValidateBox - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="学生添加" style="width:400px;padding:10px 60px 20px 60px;">
	<form action="StudentServlet" method="post">
		<input type="hidden" name="oper" value="addStu" />
		<table cellpadding="5">
			<tr>
				<td>学号:</td>
				<td><input name="sid" class="easyui-validatebox textbox" data-options="required:true"  missingMessage="学号必填"></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input name="sname" class="easyui-validatebox textbox" data-options="required:true" missingMessage="姓名必填"></td>
			</tr>
			
			<tr>
				<td>性别:</td>
				<td>
					男: <input type="radio" name="ssex" value="1" checked="checked"/>
					女: <input type="radio" name="ssex" value="0"/>
				</td>
			</tr>
			
			<tr>
				<td>出生年月:</td>
				<td><input name="sbirth" class="easyui-datebox textbox" value=" "></td>
			</tr>
			<tr>
				<td>所在班级:</td>
				<td>
					<select name="sclass"> 
						<option value="1">一班</option> 
						<option value="2">二班</option> 
						<option value="3">三班</option> 
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="添加" />
				</td>
			</tr>
		</table>
	</form>
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