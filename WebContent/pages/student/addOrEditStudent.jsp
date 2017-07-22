<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AddOrEdit</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
	function changeclassid(courseTypeId) {

		if (courseTypeId != null) {

			var url = "stud_changecourse.action";
			var params = "student.crmClass.crmCourseType.courseTypeId="
					+ courseTypeId;

			$
					.ajax({
						"url" : url,
						"data" : params,
						"success" : function(jsonData) {
							var classObj = document
									.getElementById("classSelectId");
							classObj.innerHTML = "<option value=''>--choose--</option>";
							for (var i = 0; i < jsonData.length; i++) {
								var cObj = jsonData[i];
								var classId = cObj.classId;
								var name = cObj.name;
								classObj.innerHTML = classObj.innerHTML
										+ "<option value='"+classId+"'>" + name
										+ "</option>";
							}
						},
						"dataType" : "json"
					})
		}
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
    <td width="44%" align="left">[添加/编辑正式学员]</td>
   
    <td width="52%"align="right">
       <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
       <a href="#"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="stud_add.action" method="post">
	<table width="88%" class="emp_table">
	  <tr>
	    <td width="100px" align="left">姓名：</td>
	    <td width="200px" align="left"><input type="text" name="stuName" value="张三"/> </td>
	    <td width="80px" align="left">性别：</td>
	    <td align="left">
	    	<input type="radio" name="gender" value="男"/>男
	    	<input type="radio" name="gender" value="女"/>女
	    </td>
	  </tr>
	  <tr>
	    <td align="left">应付学费：</td>
	    <td align="left"><input type="text" name="totalpay" value=""/></td>
	    <td align="left">实付学费：</td>
	    <td align="left"><input type="text" name="payd" value=""/></td>
	  </tr>
	  <tr>
	    <td align="left">身份证号：</td>
	    <td align="left"><input type="text" name="idCard" value="" /></td>
	    <td align="left">手机号：</td>
	    <td align="left"><input type="text" name="phoneNum" value="13812341234"/></td>
	  </tr>
	  <tr>
	    <td align="left">QQ号：</td>
	    <td align="left"><input type="text" name="qq" value="2342424"/></td>
	    <td align="left">邮箱：</td>
	    <td align="left"><input type="text" name="email" value=""/></td>
	  </tr>
	  <tr>
	    <td align="left">就读班级：</td>
	    <td align="left" colspan="3">
	    	类别<s:select name="crmClass.crmCourseType.courseTypeId" list="ccts" 
	    	headerKey="" headerValue="--choose--" listKey="courseTypeId" listValue="courseName"
	    	onchange="changeclassid(this.value)" />

	    	班级<select name="crmClass.classId" id="classSelectId">
			</select>
	    </td>
	  </tr>
	  <tr>
	    <td align="left">毕业学校：</td>
	    <td align="left"><input type="text" name="school" value=""/></td>
	    <td align="left">学历：</td>
	    <td align="left">
	    	<select name="degere">
			    <option value="">--选择学历--</option>
			    <option value="1.博士">1.博士</option>
			    <option value="2.研究生">2.研究生</option>
			    <option value="3.本科">3.本科</option>
			    <option value="4.大专">4.大专</option>
			    <option value="5.高中">5.高中</option>
			    <option value="6.初中">6.初中</option>
			    <option value="7.其他">7.其他</option>
			</select>

	    	专业<input type="text" name="major" size="17" value="" />
	    </td>
	  </tr>
	  <tr>
	    <td align="left">身份证地址：</td>
	    <td align="left" colspan="3"><input type="text" name="idCardAddr" size="60" value=""/></td>
	  </tr>
	  <tr>
	    <td align="left">在京地址：</td>
	    <td align="left" colspan="3"><input type="text" name="bjAddr" size="60" value=""/></td>
	  </tr>
	  <tr>
	    <td align="left">学员描述：</td>
	    <td align="left" colspan="3"><input type="text" name="remark" size="60" value=""/></td>
	  </tr>
	  <tr>
	    <td colspan="6"><br />出门在外，如果发生意外，我们将通过下面的信息跟学院的家长联系</td>
	    </tr>
	   <tr>
	    <td align="left">家庭联系电话：</td>
	    <td align="left"><input type="text" name="homeNum" value=""/></td>
	    <td align="left">紧急联系人：</td>
	    <td align="left"><input type="text" name="emergNum" value=""/></td>
	  </tr>
	</table>
</form>

</html>