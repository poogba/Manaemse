<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ListStaff</title>
<link href="${pageContext.request.contextPath}/css/sys.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function changepostid(depId) {
		var url = "staff_changepostId.action";
		var params = "cs.crmPost.crmDepartment.depId=" + depId;

		$.ajax({
			"url" : url,
			"data" : params,
			"success" : function(jsonData) {
				var postSelectObject = document.getElementById("postId");
				postSelectObject.innerHTML = "<option value=''>--choose--</option>";
				for (var i = 0; i < jsonData.length; i++) {
					var postObj = jsonData[i];
					var postId = postObj.postId;
					var postName = postObj.postName;
					postSelectObject.innerHTML = postSelectObject.innerHTML
							+ "<option value='"+postId+"'>" + postName
							+ "</option>";
				}
			},
			"error" : function() {
				alert("服务器繁忙！");
			},
			"datatype" : "json"
		});
	}
</script>
</head>

<s:debug />

<body>
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td class="topg"></td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="0" class="wukuang"
		width="100%">
		<tr>
			<td width="1%"><img
				src="${pageContext.request.contextPath}/images/tleft.gif" /></td>
			<td width="39%" align="left">[员工管理]</td>

			<td width="57%" align="right">
				<%--高级查询 --%> <a href="javascript:void(0)"
				onclick="document.forms[0].submit()"><img
					src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
				<%--员工注入 --%> <s:a action="staff_preaddstaff.action">
					<img
						src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
				</s:a>

			</td>
			<td width="3%" align="right"><img
				src="${pageContext.request.contextPath}/images/tright.gif" /></td>
		</tr>
	</table>

	<!-- 查询条件：马上查询 -->
	<s:form id="conditionFormId" action="staff_findall.action" method="post">
	<s:hidden name="isSearch" value="true"></s:hidden>
		<table width="88%" border="0" style="margin: 20px;">
			<tr>
				<td width="80px">部门：</td>
				<td width="200px"><s:select name="crmPost.crmDepartment.depId"
						list="cds" headerKey="" headerValue="--choose--" listKey="depId"
						listValue="depName" onchange="changepostid(this.value)" /></td>
				<td width="80px">职务：</td>
				<td width="200px"><select id="postId" name="crmPost.postId"></select>
				</td>
				<td width="80px">姓名：</td>
				<td width="200px"><input type="text" name="staffName" size="12" /></td>
				<td></td>
			</tr>
		</table>
	</s:form>


	<table border="0" cellspacing="0" cellpadding="0"
		style="margin-top: 5px;">
		<tr>
			<td><img
				src="${pageContext.request.contextPath}/images/result.gif" /></td>
		</tr>
	</table>

	<table width="100%" border="1">
		<tr class="henglan" style="font-weight: bold;">
			<td width="10%" align="center">员工姓名</td>
			<td width="6%" align="center">性别</td>
			<td width="12%" align="center">入职时间</td>
			<td width="15%" align="center">所属部门</td>
			<td width="10%" align="center">职务</td>
			<td width="10%" align="center">编辑</td>
		</tr>

		<s:iterator value="css">
			<tr class="tabtd2">
				<td align="center"><s:property value="staffName" /></td>
				<td align="center"><s:property value="gender" /></td>
				<td align="center"><s:date name="onDutyDate" format="yyyy-MM-dd" /></td>
				<td align="center"><s:property
						value="crmPost.crmDepartment.depName" /></td>
				<td align="center"><s:property value="crmPost.postName" /></td>
				<td width="7%" align="center"><s:a action="staff_predit.action">
						<s:param name="staffId" value="staffId"></s:param>
						<img
							src="${pageContext.request.contextPath}/images/button/modify.gif"
							class="img" />
					</s:a></td>
			</tr>
		</s:iterator>

	</table>


	<table border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td align="right">
			<span>第<s:property value="pb.currpage" />/<s:property value="pb.totalpage" />页</span>
			<span> 
			<s:if test="pb.currpage!=1">						
				<s:a action="staff_findall.action">
					<s:param name="currpage" value="1"></s:param>
					首页
				</s:a>
				<s:a action="staff_findall.action">
					<s:param name="currpage" value="pb.currpage-1"></s:param>
						  [上一页]
				</s:a>						  
			</s:if>&nbsp;&nbsp;
			<%-- <s:a action="staff_findall.action">
				<s:param name="pb.currpage" value="pb.currpage-1" />
				[上一页]
			</s:a>&nbsp;&nbsp;  --%>
			<s:if test="pb.currpage!=pb.totalpage">
				<s:a action="staff_findall.action">
					<s:param name="currpage" value="pb.currpage+1"   />
					[下一页]
				</s:a>&nbsp;&nbsp;
				<s:a action="staff_findall.action">
					<s:param name="currpage" value="pb.totalpage" />	
					[尾页]
				</s:a>
			</s:if>
			</span></td>
		</tr>
	</table>
</body>
</html>
