package crm.post.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import crm.post.dao.Dao;
import crm.post.domain.CrmPost;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Override
	public List<CrmPost> findall() {
		// TODO Auto-generated method stub
		return (List<CrmPost>) getHibernateTemplate().find("from CrmPost");
	}

	@Override
	public void addpost(CrmPost cp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(cp);
	}

	@Override
	public CrmPost findbyid(String postId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(CrmPost.class, postId);
	}

	@Override
	public void update(CrmPost cp) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(cp);
	}

}
