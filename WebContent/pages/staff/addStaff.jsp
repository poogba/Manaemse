<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AddStaff</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function postJson(depId) {
		var url = "staff_changepostId.action";
		var params="crmPost.crmDepartment.depId="+depId;
		$.ajax({
			"url":url,
			"data":params,
			"success":function(jsonData){
				var postSelectObject = document.getElementById("postId");
				postSelectObject.innerHTML = "<option>--choose--</option>";
				//@3 遍历数据，将数据添加到“职务”select
				for(var i = 0 ; i < jsonData.length ; i ++){
					var postObj = jsonData[i];
					// @3.1 编号
					var postId = postObj.postId;
					// @3.2 名称
					var postName = postObj.postName;
					// @3.3 追加
					postSelectObject.innerHTML = postSelectObject.innerHTML + "<option value='"+postId+"'>"+postName+"</option>";
				}
			},"error":function(){
				alert("服务器繁忙！");
			},"datatype":"json"
		});
	}

</script>

</head>
<s:debug/>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form action="staff_addstaff.action" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="" id="staffAction_add_staffName"/> </td>
	    <td>性别：</td>
	    <td><input type="radio" name="gender"  value="男"/>男
	    	<input type="radio" name="gender"  value="女"/>女
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%"><s:select  name="cs.crmPost.crmDepartment.depId" list="cds"  headerKey="" headerValue="---choose---" listKey="depId" listValue="depName" onchange="postJson(this.value)"></s:select></td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<%-- <s:select name="cs.crmPost.postId" list="cps" headerKey="" headerValue="---choose---" listKey="postId" listValue="postName" ></s:select> --%>
	    	<select id="postId" name="cs.crmPost.postId"></select>
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>
</body>
</html>
