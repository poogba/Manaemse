package crm.clazz.dao;

import java.util.List;

import crm.clazz.domain.CrmClass;

public interface Dao {

	List<CrmClass> findall();

	void add(CrmClass ccs);

	CrmClass findbyid(String classId);

	void update(CrmClass cc);

}
