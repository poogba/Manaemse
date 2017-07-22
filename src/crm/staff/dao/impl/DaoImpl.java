package crm.staff.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import crm.staff.dao.Dao;
import crm.staff.domain.CrmStaff;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Override
	public List<CrmStaff> findall() {
		// TODO Auto-generated method stub
		return (List<CrmStaff>) getHibernateTemplate().find("from CrmStaff");
	}

	@Override
	public CrmStaff findbyid(String staffId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CrmStaff.class, staffId);
	}

	@Override
	public void update(CrmStaff cs) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(cs);
	}

	@Override
	public void addstaff(CrmStaff cs) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(cs);
	}

	/*@Override
	public List<CrmStaff> search(CrmStaff cs) {
		// TODO Auto-generated method stub
		
		String sql="from CrmStaff cs where 1=1";
		
		if (!"".equals(cs.getStaffName())) {
			sql+=" and cs.staffName="+"'"+cs.getStaffName()+"'";
		}
		if (cs.getCrmPost().getPostId()!=null&&!"--choose--".equals(cs.getCrmPost().getPostId())) {
			sql+=" and cs.crmPost.postId="+"'"+cs.getCrmPost().getPostId()+"'";
		}
		if (!"".equals(cs.getCrmPost().getCrmDepartment().getDepId())) {
			sql+=" and cs.crmPost.crmDepartment.depId="+"'"+cs.getCrmPost().getCrmDepartment().getDepId()+"'";
		}
		
		return (List<CrmStaff>) getHibernateTemplate().find(sql);
	}*/
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return findall().size();
	}

	@Override
	public List<CrmStaff> searchlimit(int currentpage, int pagesize) {
		// TODO Auto-generated method stub
		final String hql ="from CrmStaff";
		return (List<CrmStaff>) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = ses.createQuery(hql);
				query.setFirstResult((currentpage-1)*pagesize);
				query.setMaxResults(pagesize);
				
				return query.getResultList();				
			}
		});
	}

	@Override
	public List<CrmStaff> searchlimit(DetachedCriteria criteria, int currentpage, int pagesize) {
		// TODO Auto-generated method stub
		return (List<CrmStaff>) getHibernateTemplate().findByCriteria(criteria, (currentpage-1)*pagesize, pagesize);
	}


	@Override
	public int getCount(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

}
