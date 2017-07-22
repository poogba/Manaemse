package crm.stud.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import crm.stud.dao.Dao;
import crm.stud.domain.CrmStudent;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Override
	public List<CrmStudent> findall() {
		// TODO Auto-generated method stub
		return (List<CrmStudent>) getHibernateTemplate().find("from CrmStudent");
	}

}
