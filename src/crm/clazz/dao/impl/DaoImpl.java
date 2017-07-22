package crm.clazz.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import crm.clazz.dao.Dao;
import crm.clazz.domain.CrmClass;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Override
	public List<CrmClass> findall() {
		// TODO Auto-generated method stub
		return (List<CrmClass>) getHibernateTemplate().find("from CrmClass");
	}

	@Override
	public void add(CrmClass ccs) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(ccs);
	}

	@Override
	public CrmClass findbyid(String classId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CrmClass.class, classId);
	}

	@Override
	public void update(CrmClass cc) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(cc);
	}

}
