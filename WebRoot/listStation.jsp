<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基站列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center><h3>显示所有进出基站记录</h3></center>
	<form action="${pageContext.request.contextPath }/ConBatchDelServlet" method="post">
		<table border="1" align="center" width="700px">
			<tr>
		    	<th>编号</th>
		        <th>地市</th>
		        <th>县区</th>
		        <th>基站名称</th>
		    </tr>
		    <c:forEach items="${stationList}" var="station" varStatus="varSta">
			<tr>
			    <td>${varSta.count }</td>
			    <td>${station.city }</td>
			    <td>${station.region }</td>
			    <td>${station.station }</td>
			    <td><a href="${pageContext.request.contextPath }/searchStation?id=${station.id}">修改</a>&nbsp;<a href="javascript:void(0)" onclick="delCon('${station.id}')">删除</a></td>
			</tr>
		    </c:forEach>
		    <tr>
	    		<td colspan="8" align="center"><a href="${pageContext.request.contextPath }/addStation.jsp">添加基站站点</a></td>
	    	</tr>
		</table>
		<a href="${pageContext.request.contextPath }/manager.jsp">返回首页</a>
	</form>
		
	<script type="text/javascript">
	//删除联系人的函数
	function delCon(id){
		//1）提示用户是否继续删除
		if(window.confirm("是否继续删除，一旦删除不能恢复！")){
			//按了“确定”
			//发出删除请求
			var url = "${pageContext.request.contextPath}/delStation?id="+id;
			window.location.href=url;
		}	
	}
	</script>
	</body>
</html>
