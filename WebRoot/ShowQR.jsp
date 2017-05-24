<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>二维码页面</title>

  </head>
  
  <body>
    <img src="${pageContext.request.contextPath}/img/${filename}",width="500px" height="500px"/>
    <a href="${pageContext.request.contextPath }/manager.jsp">返回首页</a>
  </body>
</html>
