package crm.stud.service;

import java.util.List;
import java.util.Set;
import crm.clazz.domain.CrmClass;
import crm.course.domain.CrmCourseType;
import crm.stud.domain.CrmStudent;

public interface Service {

	List<CrmStudent> findall();

	List<CrmClass> findallclass();

	List<CrmCourseType> findallcourse();

	Set<CrmClass> findcoursebyid(String string);

}
