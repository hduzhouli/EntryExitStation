<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加站点</title>
    
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
  	<form action="${pageContext.request.contextPath}/addStationServlet" method="post">
    	地市：<select id="selid" type="text" name="city" onchange="selcity()">
				<option>--选择城市--</option>
			    <option>南宁</option>
			    <option>柳州</option>
			    <option>桂林</option>
			    <option>梧州</option>				
				<option>北海</option>
				<option>钦州</option>
				<option>防城</option>
				<option>贵港</option>
				<option>玉林</option>
				<option>贺州</option>
				<option>河池</option>
				<option>百色</option>				
				<option>来宾</option>
				<option>崇左</option>
			</select><br/>
    	区县：<select id="subselid" type="text" name="region">
				<option>--选择县区--</option>
			</select><br/>
    	基站名称：<input type="text" name="station"/><br/>
    	<input type="submit" value="添加站点"/>
    </form>
    
    <script type="text/javascript">
	function selcity()
	{
		
		var arr = [['--选择县区--'],['兴宁区','青秀区','良庆区','西乡塘区','江南区','邕宁区','武鸣县','隆安县','马山县','宾阳县','上林县','横县']
					,['城中区','鱼峰区','柳南区','柳北区','柳江区','柳城区','鹿寨县','融安县','融水县','三江县']
					,['七星区','象山区','秀峰区','叠彩区','雁山区','资源县','临桂县','恭城县','灵川县','阳朔县','永福县','荔浦县','灌阳县','全州县','平乐县','龙胜县','兴安县']
					,['蝶山区','长洲区','龙圩区','万秀区','岑溪市','苍梧县','蒙山县','藤县']
					,['海城区','银海区','铁山港区','港口区','合浦县']
					,['钦南区','钦北区','灵山县','浦北县']
					,['防城区','港口区','东兴市','上思县']
					,['港南区','港北区','覃塘区','桂平市','平南县']
					,['玉州区','福绵区','北流市','博白县','陆川县','容县','兴业县']
					,['八步区','钟山县','富川县','昭平县']
					,['金城江区','宜州市','天峨县','都安县','大化县','环江县','南丹县','凤山县','巴马县','罗城县','东兰县']
					,['右江区','田林县','平果县','那坡县','德保县','凌云县','西林县','田东县','隆林县','乐业县','靖西县','田阳县']
					,['兴宾区','合山市','金秀县','武宣县','象州县','忻城县']
					,['江州区','凭祥市','龙州县','扶绥县','大新县','天等县','宁明县']];
					
		//获取选择的省的角标。
		var selNode = document.getElementById("selid");
		var index = selNode.selectedIndex;
		
		var regions = arr[index];
		
		var subSelNode = document.getElementById("subselid");
		
		//有更简单清除方式，只要改变下拉菜单的长度即可。
		subSelNode.options.length = 0;				
		
		for(var x=0; x<regions.length; x++)
		{
			var optNode = document.createElement("option");
			
			optNode.innerHTML = regions[x];
			
			subselid.appendChild(optNode);
		}
	}
	</script>
    
  </body>
</html>
