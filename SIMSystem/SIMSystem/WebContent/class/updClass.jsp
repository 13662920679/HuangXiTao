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
    <li><a >班级信息</a></li>
    <li><a >所有班级信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    
    <table class="tablelist">
    	<thead>
	    	<tr>
		        <th>编号</th>
		        <th>班级</th>
		        <th>Java老师</th>
		        <th>Python老师</th>
		        <th>C老师</th>
		        <th>班级人数</th>
		        <th>操作</th>
	        </tr>
        </thead>
        <form action="ClassServlet" method="get">
        <% 
        		Cclass c = (Cclass)request.getAttribute("class");	
        	%>
        <input type="hidden" name="oper" value="updClass" />
        <input type="hidden" name="cid" value="<%=c.getCid() %>" />
        <tbody>
        	
	        <tr>
	        <td><%=c.getCid() %></td>
	        <td><%=c.getCname() %></td>
	        <td>
	        	<select name="ctJava"> 
					<%	
						String a = "";
						String b = "";
						
						int ctJ = Integer.parseInt(c.getCtJava());
						switch (ctJ) { 
						case 99001:
							a = "selected";
							break;
						case 99004:
							b = "selected";
							break;
						default:
							break;
						}
						
					%>
						<option value="99001" <%=a %>>苍老师</option> 
					
						<option value="99004" <%=b %>>王老师</option> 
			
				</select>
	        </td>
	        <td>
	        	<select name="ctPython"> 
					<%	
						String cc = "";
						String d = "";
						
						int ctP = Integer.parseInt(c.getCtPython());
						switch (ctP) { 
						case 99003:
							cc = "selected";
							break;
						case 99006:
							d = "selected";
							break;
						default:
							break;
						}
						
					%>
						<option value="99003" <%=cc %>>李老师</option> 
					
						<option value="99006" <%=d %>>胡老师</option> 
			
				</select>
	        </td>
	        <td>
	        	<select name="ctC"> 
					<%	
						String e = "";
						String f = "";
						
						int ctC = Integer.parseInt(c.getCtC());
						switch (ctC) { 
						case 99002:
							e = "selected";
							break;
						case 99005:
							f = "selected";
							break;
						default:
							break;
						}
						
					%>
						<option value="99002" <%=e %>>黄老师</option> 
					
						<option value="99005" <%=f %>>周老师</option> 
			
				</select>
	        </td>
	       
	        <td><%=c.getNum() %></td>
	        <td><input type="submit" value="保存" /></td>
	        </tr>        
        </tbody>
        </form>
        
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
