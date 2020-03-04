<%@ page language="java" import="java.util.*,com.huang.pojo.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
	<div class="easyui-panel" title="修改学生" style="width:400px;padding:10px 60px 20px 60px;">
	<form action="StudentServlet" method="get">
	<%	
		Student s = new Student(); 
		s = (Student)request.getAttribute("stu");
	
	%>
		<input type="hidden" name="oper" value="updStu" />
		<input type="hidden" name="oldSid" value="<%=request.getAttribute("oldSid") %>" />
		<table cellpadding="5">
			<tr>
				<td>学号:</td>
				<td><input name="sid" class="easyui-validatebox textbox" data-options="required:true"  missingMessage="学号必填" value="<%=s.getSid() %>"></td>
			</tr>
			<tr>
				<td>姓名:</td>
				<td><input name="sname" class="easyui-validatebox textbox" data-options="required:true" missingMessage="姓名必填" value="<%=s.getSname() %>"></td>
			</tr>
			
			<tr>
				<td>性别:</td>
				<%
					if("1".equals(s.getSsex())){
				%>
				<td>
					男: <input type="radio" name="ssex" value="1" checked="checked"/>
					女: <input type="radio" name="ssex" value="0"/>
				</td>
				<%
					}else{
				%>
				<td>
					男: <input type="radio" name="ssex" value="1" />
					女: <input type="radio" name="ssex" value="0" checked="checked"/>
				</td>
				<%
					}
				%>
			</tr>
			
			<tr>
				<td>出生年月:</td>
				<td><input name="sbirth" class="easyui-datebox textbox" value="<%=s.getSbirth() %>"></td>
			</tr>
			<tr>
				<td>所在班级:</td>
				<td>
					<select name="sclass"> 
					<%	
						String a = "";
						String b = "";
						String c = "";
						int sc = Integer.parseInt(s.getSclass());
						switch (sc) { 
						case 1:
							a = "selected";
							break;
						case 2:
							b = "selected";
							break;
						case 3:
							c = "selected";
						default:
							break;
						}
						System.out.println(a+b+c);
					%>
						<option value="1" <%=a %>>一班</option> 
					
						<option value="2" <%=b %>>二班</option> 
					
						<option value="3" <%=c %>>三班</option> 
					
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="保存" />
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