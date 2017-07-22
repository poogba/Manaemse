package crm.course.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import crm.course.domain.CrmCourseType;

public interface Dao {

	List<CrmCourseType> findall();

	void add(CrmCourseType cct);

	CrmCourseType findbyid(String courseTypeId);

	void update(CrmCourseType cct);

	int getCount(DetachedCriteria criteria);

	List<CrmCourseType> search(DetachedCriteria criteria, int currpage, int pagesize);

	int getCount();

	List<CrmCourseType> searchbypage(int currpage, int pagesize);

}
