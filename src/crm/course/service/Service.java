package crm.course.service;

import java.util.List;

import crm.course.domain.CrmCourseType;
import crm.course.domain.pageBean;

public interface Service {

	List<CrmCourseType> findall();

	void add(CrmCourseType cct);

	CrmCourseType findbyid(String courseTypeId);

	void update(CrmCourseType cct);

	pageBean searchbypage(CrmCourseType cct, int currpage, int pagesize, int tS, int tE, double lCS, double lCE);

}
