package crm.staff.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import crm.staff.domain.CrmStaff;

public interface Dao {

	List<CrmStaff> findall();

	CrmStaff findbyid(String staffId);

	void update(CrmStaff cs);

	void addstaff(CrmStaff cs);

	int getCount(DetachedCriteria criteria);
	
	int getCount();

	List<CrmStaff> searchlimit(DetachedCriteria criteria, int currentpage, int pagesize);

	List<CrmStaff> searchlimit(int currentpage, int pagesize);

}
