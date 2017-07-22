<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
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
    <td width="44%" align="left">[编辑班级]</td>
   
    <td width="52%"align="right">
    	<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
    		<img src="${pageContext.request.contextPath}/images/button/save.gif" />
    	</a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:if test="classId==null">
<form action="clazz_add.action" method="post">
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">班级名称：</td>
	    <td width="20%"><input type="text" name="name" value=""/> </td>
	    <td width="8%">所属类别：</td>
	    <td width="62%">
			<s:select name="crmCourseType.courseTypeId" list="ccts" headerKey="" headerValue="--choose--" listKey="courseTypeId" listValue="courseName"></s:select>
		</td>
	  </tr>
	  <tr>
	    <td>开课时间：</td> 
	    <td>
	    	<input type="text" name="beginTime" value="" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td>结业时间：</td>
	    <td>
	    	<input type="text" name="endTime" value="" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	  </tr>
	  <tr>
	    <td>其他说明：</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="4"><textarea name="remark" cols="60" rows="10" ></textarea></td>
	  </tr>
	</table>
</form>
</s:if>

<s:else>
<s:form action="clazz_update.action" method="post">
	<s:hidden name="classId" />
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">班级名称：</td>
	    <td width="20%"><s:textfield name="cc.name" /></td>
	    <td width="8%">所属类别：</td>
	    <td width="62%">
			<s:select name="crmCourseType.courseTypeId" list="ccts" headerKey="" headerValue="--choose--" listKey="courseTypeId" listValue="courseName" value="cc.crmCourseType.courseName"></s:select>
		</td>
	  </tr>
	  <tr>
	    <td>开课时间：</td> 
	    <td>
	    	<s:textfield name="cc.beginTime" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    	<!-- <input type="text" name="beginTime" value="" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/> -->
	    </td>
	    <td>结业时间：</td>
	    <td>
	    	<s:textfield  name="cc.endTime"  readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);" />
	    	<!-- <input type="text" name="endTime" value="" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/> -->
	    </td>
	  </tr>
	  <tr>
	    <td>其他说明：</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td colspan="4"><s:textarea name="cc.remark" cols="60" rows="10" /></td>
	  </tr>
	</table>
</s:form>
</s:else>
</body>
</html>
