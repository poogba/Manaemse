<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ListCourse</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>
<s:debug/>


<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[课程类别]</td>
   
    <td width="57%"align="right">
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
			<img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" />
		</a>      
    	<%--编辑前：添加类别 --%>
    	<a href="${pageContext.request.contextPath}/pages/coursetype/addOrEditCourse.jsp">
	       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>


<%--条件查询 start --%>

<s:form action="course_findall.action" method="post">
	<s:hidden name="isSearch" value="true"></s:hidden>
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">课程类别：</td>
	    <td><input type="text" name="courseName" size="30" value="" /></td>
	  </tr>
	  <tr>
	    <td >课程简介：</td>
	    <td > <input type="text" name="remark" size="30" value="" /></td>
	  </tr>
	  <tr>  
	    <td >总学时：</td>
	    <td ><input type="text" name="TS" size="12" value="" />  至  <input type="text" name="TE" size="12" value="" /></td>
	  </tr>
	  <tr>
	    <td>课程费用：</td>
	    <td ><input type="text" name="LCS" size="12" value="" /> 至 <input type="text" name="LCE" size="12" value="" /></td>
	  </tr>
	</table>
</s:form>

<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="97%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="14%" align="center">名称</td>
    <td width="33%" align="center">简介</td>
    <td width="13%" align="center">总学时</td>
    <td width="18%" align="center">收费标准</td>
	<td width="11%" align="center">编辑</td>
  </tr>
  <%--数据展示，单行：tabtd1；双行：tabtd2 --%>
  
 	<s:iterator value="ccts">
	  <tr class="tabtd2">
	    <td align="center"><s:property value="courseName" /></td>
	    <td align="center"><s:property value="remark" /></td>
	    <td align="center"><s:property value="total" /></td>
	    <td align="center"><s:property value="courseCost" /></td>
	  	<td width="11%" align="center">
	  		<s:a action="course_predit.action">
	  			<s:param name="courseTypeId"  value="courseTypeId" />
	  			<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" />
	  		</s:a>
	  	</td>
	  </tr>
	</s:iterator>
 
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    <span>第<s:property value="pb.currpage" />/<s:property value="pb.totalpage" />页</span>
    <span><s:if test="pb.currpage!=1">						
				<s:a action="course_findall.action">
					<s:param name="currpage" value="1"></s:param>
					首页
				</s:a>
				<s:a action="course_findall.action">
					<s:param name="currpage" value="pb.currpage-1"></s:param>
						  [上一页]
				</s:a>						  
			</s:if>&nbsp;&nbsp;
			<%-- <s:a action="course_findall.action">
				<s:param name="pb.currpage" value="pb.currpage-1" />
				[上一页]
			</s:a>&nbsp;&nbsp;  --%>
			<s:if test="pb.currpage!=pb.totalpage">
				<s:a action="course_findall.action">
					<s:param name="currpage" value="pb.currpage+1"   />
					[下一页]
				</s:a>&nbsp;&nbsp;
				<s:a action="course_findall.action">
					<s:param name="currpage" value="pb.totalpage" />	
					[尾页]
				</s:a>
			</s:if></span>
    </td>
  </tr>
</table>
</body>
</html>
