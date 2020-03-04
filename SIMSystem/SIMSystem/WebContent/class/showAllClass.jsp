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
    
    <%
        	String tf = (String)request.getAttribute("del"); 
            	if("false".equals(tf)){
        %>
    <div style="text-align: center;">
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">班级存在学生,不能被删除</span>
	</div>
    <%
    	}else if("true".equals(tf)){
    %>
    <div style="text-align: center;">
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">班级删除成功</span>
	</div>
	<%
		}
	%>
    
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
        <tbody>
        	<%
        		List<Cclass> lc = (List<Cclass>)request.getAttribute("lc"); 
        	        		for(Cclass c:lc){
        	%>
	        <tr>
	        <td><%=c.getCid() %></td>
	        <td><%=c.getCname() %></td>
	        <% int ctJ = Integer.parseInt(c.getCtJava());
	        	String abcJ = null;
						switch (ctJ) { 
						case 99001:
							abcJ = "苍老师";
							break;
						case 99002:
							abcJ = "黄老师";
							break;
						case 99003:
							abcJ = "李老师";
							break;
						case 99004:
							abcJ = "王老师";
							break;
						case 99005:
							abcJ = "周老师";
							break;
						case 99006:
							abcJ = "胡老师";
							break;
						default:
							break;
						}%>
	        <td><%=abcJ %></td>
	        <% int ctP = Integer.parseInt(c.getCtPython());
	        	String abcP = null;
						switch (ctP) { 
						case 99001:
							abcP = "苍老师";
							break;
						case 99002:
							abcP = "黄老师";
							break;
						case 99003:
							abcP = "李老师";
							break;
						case 99004:
							abcP = "王老师";
							break;
						case 99005:
							abcP = "周老师";
							break;
						case 99006:
							abcP = "胡老师";
							break;
						default:
							break;
						}%>
	        <td><%=abcP %></td>
	        <% int ctC = Integer.parseInt(c.getCtC());
	        	String abcC = null;
						switch (ctC) { 
						case 99001:
							abcC = "苍老师";
							break;
						case 99002:
							abcC = "黄老师";
							break;
						case 99003:
							abcP = "李老师";
							break;
						case 99004:
							abcC = "王老师";
							break;
						case 99005:
							abcC = "周老师";
							break;
						case 99006:
							abcC = "胡老师";
							break;
						default:
							break;
						}%>
	        <td><%=abcC %></td>
	        <td><%=c.getNum() %></td>
	        <td><a href="ClassServlet?oper=selOneClass&cid=<%=c.getCid() %>" target="rightFrame">修改</a >/<a href="ClassServlet?oper=delClass&cid=<%=c.getCid() %>" target="rightFrame">删除</a></td>
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
