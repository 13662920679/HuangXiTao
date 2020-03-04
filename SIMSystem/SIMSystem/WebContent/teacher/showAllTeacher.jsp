<%@page import="com.huang.pojo.Cclass"%>
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
    <li><a >教师信息</a></li>
    <li><a >所有教师信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th>工号</th>
		        <th>名字</th>
		        <th>性别</th>
		        <th>任教科目</th>
		        <th>联系方式</th>
		       
	        </tr>
        </thead>
        <tbody>
        	<%
        		List<Teacher> lt = (List<Teacher>)request.getAttribute("lt"); 
        	        		for(Teacher t:lt){
        	%>
	        <tr>
	        <td><%=t.getTid() %></td>
	        <td><%=t.getTname() %></td>
	        <%
	        	if("1".equals(t.getTsex())){
	        %>
	        <td>男</td>
	        <%}else{ %>
	         <td>女</td>
	        <%} %>
	        <% //int ctJ = Integer.parseInt(t.getTtype());
	        	String abc = null;
						switch (t.getTtype()) { 
						case 1:
							abc = "Java";
							break;
						case 2:
							abc = "Python";
							break;
						case 3:
							abc = "C";
							break;
						default:
							break;
						}%>
	        <td><%=abc %></td>
	         <td><%=t.getTphone() %></td>
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
