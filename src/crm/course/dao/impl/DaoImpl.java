package crm.course.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import crm.course.dao.Dao;
import crm.course.domain.CrmCourseType;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Override
	public List<CrmCourseType> findall() {
		// TODO Auto-generated method stub
		return (List<CrmCourseType>) getHibernateTemplate().find("from CrmCourseType");
	}

	@Override
	public void add(CrmCourseType cct) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(cct);
	}

	@Override
	public CrmCourseType findbyid(String courseTypeId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
	}

	@Override
	public void update(CrmCourseType cct) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(cct);
	}

	@Override
	public int getCount(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByCriteria(criteria).size();
	}

	@Override
	public List<CrmCourseType> search(DetachedCriteria criteria, int currpage, int pagesize) {
		// TODO Auto-generated method stub
		return (List<CrmCourseType>) getHibernateTemplate().findByCriteria(criteria, (currpage-1)*pagesize, pagesize);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return findall().size();
	}

	@Override
	public List<CrmCourseType> searchbypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		
		final String hql ="from CrmCourseType";
		
		return getHibernateTemplate().execute(new HibernateCallback<List<CrmCourseType>>() {

			@Override
			public List<CrmCourseType> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				query.setFirstResult((currpage-1)*pagesize);
				query.setMaxResults(pagesize);
				
				return query.getResultList();
			}
		});
	}

}
