package crm.dep.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import crm.dep.dao.Dao;
import crm.dep.domain.CrmDepartment;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Override
	public void addDep(CrmDepartment cd) {
		this.getHibernateTemplate().save(cd);	
	}

	@Override
	public List<CrmDepartment> findall() {
		return (List<CrmDepartment>) getHibernateTemplate().find("from CrmDepartment");
	}

	@Override
	public CrmDepartment findbyid(String depId) {
		return this.getHibernateTemplate().get(CrmDepartment.class, depId);
	}

	@Override
	public void saveEdit(CrmDepartment cd) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(cd);
	}

}
