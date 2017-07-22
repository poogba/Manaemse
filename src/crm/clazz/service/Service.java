package crm.clazz.service;

import java.util.List;

import crm.clazz.domain.CrmClass;
import crm.course.domain.CrmCourseType;

public interface Service {

	List<CrmClass> findall();

	List<CrmCourseType> listccts();

	void add(CrmClass cc);

	CrmClass findbyid(String classId);

	void update(CrmClass cc);

}
