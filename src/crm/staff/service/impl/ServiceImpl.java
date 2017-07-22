package crm.staff.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.sun.xml.internal.ws.util.xml.CDATA;

import crm.dep.domain.CrmDepartment;
import crm.domain.pageBean;
import crm.post.domain.CrmPost;
import crm.staff.dao.Dao;
import crm.staff.domain.CrmStaff;
import crm.staff.service.Service;

public class ServiceImpl implements Service {

	private Dao daoSta;
	private crm.post.service.Service servicePost;
	private crm.dep.service.Service serviceDep;

	@Override
	public List<CrmStaff> findall() {
		// TODO Auto-generated method stub
		return daoSta.findall();
	}

	public Dao getDaoSta() {
		return daoSta;
	}

	public void setDaoSta(Dao daoSta) {
		this.daoSta = daoSta;
	}

	@Override
	public CrmStaff findbyid(String staffId) {
		// TODO Auto-generated method stub
		return daoSta.findbyid(staffId);
	}

	@Override
	public List<CrmPost> findcps() {
		// TODO Auto-generated method stub
		return getServicePost().findall();
	}

	@Override
	public List<CrmDepartment> findcds() {
		// TODO Auto-generated method stub
		return getServicePost().findcds();
	}

	public crm.post.service.Service getServicePost() {
		return servicePost;
	}

	public void setServicePost(crm.post.service.Service servicePost) {
		this.servicePost = servicePost;
	}

	@Override
	public void update(CrmStaff cs) {
		// TODO Auto-generated method stub
		daoSta.update(cs);
	}

	@Override
	public void addstaff(CrmStaff cs) {
		// TODO Auto-generated method stub
		daoSta.addstaff(cs);
	}

	@Override
	public CrmDepartment findinnerbyid(String depId) {
		// TODO Auto-generated method stub
		return servicePost.findinnerbyid(depId);

	}

	@Override
	public void findcd(String depId) {
		// TODO Auto-generated method stub
		servicePost.findinnerbyid(depId);

	}
	//////////////////////////////
	/*
	 * @Override public List<CrmStaff> search(CrmStaff cs) { // TODO
	 * Auto-generated method stub return daoSta.search(cs); }
	 */

	@Override
	public pageBean searchbypage(CrmStaff cs, int currentpage, int pagesize) {
		// TODO Auto-generated method stub

		if (cs != null) {
			DetachedCriteria criteria = getCriteria(cs);
			int c = daoSta.getCount(criteria);
			int totalpage = (int) Math.ceil(c * 1.0 / pagesize);
			pageBean pb = new pageBean();
			pb.setCurrpage(currentpage);
			pb.setCount(c);
			pb.setTotalpage(totalpage);
			pb.setPagesize(pagesize);
			pb.setCss(daoSta.searchlimit(criteria, currentpage, pagesize));
			return pb;

		} else {
			pageBean pb = searchbypage(currentpage, pagesize);
			return pb;
		}

	}

	@Override
	public pageBean searchbypage(int currentpage, int pagesize) {
		// TODO Auto-generated method stub
		int c = daoSta.getCount();
		int totalpage = (int) Math.ceil(c * 1.0 / pagesize);
		pageBean pb = new pageBean();
		pb.setCurrpage(currentpage);
		pb.setCount(c);
		pb.setTotalpage(totalpage);
		pb.setPagesize(pagesize);
		pb.setCss(daoSta.searchlimit(currentpage, pagesize));

		return pb;
	}

	public DetachedCriteria getCriteria(CrmStaff cs) {
		
		
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println(cs.toString());
		System.out.println("+++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++");
		
		

		DetachedCriteria criteria = DetachedCriteria.forClass(cs.getClass());

		String staffName = cs.getStaffName();

		if (staffName != null && !"".equals(staffName)) {
			criteria.add(Restrictions.like("staffName", "%" + staffName + "%"));
		}

		CrmPost crmPost = cs.getCrmPost();
		if (crmPost != null) {
			String postId = crmPost.getPostId();
			if (postId != null && !"".equals(postId)&&!"--choose--".equals(postId)) {
				criteria.add(Restrictions.eq("crmPost.postId", postId));
			}
		}

		if (crmPost != null && crmPost.getCrmDepartment() != null&&!"--choose--".equals(crmPost.getPostId())) {
			String depId = crmPost.getCrmDepartment().getDepId();

			// criteria.add(Restrictions.eq("crmPost.crmDepartment.depId",
			// depId));
			// 根据部门编号，查询部门的所有职务
			Set<CrmPost> posts = serviceDep.findbyid(depId).getCrmPosts();

			List<String> postIds = new ArrayList<>();
			for (CrmPost p : posts) {
				postIds.add(p.getPostId());
			}

			if (depId != null && !"".equals(depId)) {
				criteria.add(Restrictions.in("crmPost.postId", postIds));
			}
		}

		return criteria;
	}

	public crm.dep.service.Service getServiceDep() {
		return serviceDep;
	}

	public void setServiceDep(crm.dep.service.Service serviceDep) {
		this.serviceDep = serviceDep;
	}

}
