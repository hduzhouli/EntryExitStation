<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>显示所有进出基站记录</title>
</head>

<body>
<center><h3>显示所有进出基站记录</h3></center>
<form action="${pageContext.request.contextPath }/ConBatchDelServlet" method="post">
	<table border="1" align="center" width="900px">
		<tr>
	    	<th>编号</th>
	        <th>地市</th>
	        <th>县区</th>
	        <th>基站名称</th>
	        <th>进站时间</th>
	        <th>出站时间</th>
	        <th>进站原因</th>
	        <th>联系方式</th>
	    </tr>
	    <c:forEach items="${recordList}" var="record" varStatus="varSta">
	    <tr>
	    	<td>${varSta.count }</td>
	        <td>${record.city }</td>
	        <td>${record.region }</td>
	        <td>${record.station }</td>
	        <td>${record.entry_time }</td>
	        <td>${record.exit_time }</td>
	        <td>${record.reason }</td>
	        <td>${record.phone }</td>
	        <td><a href="${pageContext.request.contextPath }/searchRecordServlet?id=${record.id}">修改</a>&nbsp;<a href="javascript:void(0)" onclick="delCon('${record.id}')">删除</a></td>
	    </tr>
	    </c:forEach>

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
			var url = "${pageContext.request.contextPath}/delEntityServlet?id="+id;
			window.location.href=url;
		}	
	}
	
	
	
	function myrefresh(){ 
		window.location.reload(); 
	} 
	setTimeout('myrefresh()',20000); //指定20秒刷新一次 
</script>

</body>
</html>

