<%@ page language="java" import="com.huang.pojo.*,java.util.List" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a >首页</a></li>
    <li><a >学生信息</a></li>
    <li><a >所有学生信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    
    
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th>学号<i class="sort"><a href="StudentServlet?oper=showAllStu&showType=sid"><img src="images/px.gif" /></a></i></th>
		        <th>姓名<i class="sort"><a href="StudentServlet?oper=showAllStu&showType=sname"><img src="images/px.gif" /></a></i></th>
		        <th>性别<i class="sort"><a href="StudentServlet?oper=showAllStu&showType=ssex"><img src="images/px.gif" /></a></i></th>
		        <th>生日<i class="sort"><a href="StudentServlet?oper=showAllStu&showType=sbirth"><img src="images/px.gif" /></a></i></th>
		        <th>班级<i class="sort"><a href="StudentServlet?oper=showAllStu&showType=sclass"><img src="images/px.gif" /></a></i></th>
		        <th>操作</th>
	        </tr>
        </thead>
        <tbody>
        	<% 
        		List<Student> ls = (List<Student>)request.getAttribute("ls"); 
        		for(Student s:ls){
        	%>
	        <tr>
	        <td><%=s.getSid() %></td>
	        <td><%=s.getSname() %></td>
	        <%
	        	if("1".equals(s.getSsex())){
	        %>
	        <td>男</td>
	        <%}else{ %>
	         <td>女</td>
	        <%} %>
	        <td><%=s.getSbirth() %></td>
	        
	        <% int sc = Integer.parseInt(s.getSclass());
	        	String abc = null;
						switch (sc) { 
						case 1:
							abc = "一班";
							break;
						case 2:
							abc = "二班";
							break;
						case 3:
							abc = "三班";
						default:
							break;
						}%>
			<td><a><%=abc %></a></td>
	        <td><a href="StudentServlet?oper=selOneStu&sid=<%=s.getSid() %>" target="rightFrame">修改</a >/<a href="StudentServlet?oper=del&sid=<%=s.getSid() %>" target="rightFrame">删除</a></td>
	        </tr>     
	        <%} %>   
        </tbody>
    </table>
    
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
