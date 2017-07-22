package crm.course.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import crm.course.dao.Dao;
import crm.course.domain.CrmCourseType;
import crm.course.domain.pageBean;
import crm.course.service.Service;

public class ServiceImpl implements Service {

	private Dao daoCrs;

	@Override
	public List<CrmCourseType> findall() {
		// TODO Auto-generated method stub

		return daoCrs.findall();
	}

	public Dao getDaoCrs() {
		return daoCrs;
	}

	public void setDaoCrs(Dao daoCrs) {
		this.daoCrs = daoCrs;
	}

	@Override
	public void add(CrmCourseType cct) {
		// TODO Auto-generated method stub
		daoCrs.add(cct);
	}

	@Override
	public CrmCourseType findbyid(String courseTypeId) {
		// TODO Auto-generated method stub
		return daoCrs.findbyid(courseTypeId);
	}

	@Override
	public void update(CrmCourseType cct) {
		// TODO Auto-generated method stub
		daoCrs.update(cct);
	}

	public DetachedCriteria getCriteria(CrmCourseType cct, int tS, int tE, double lCS, double lCE) {

		DetachedCriteria criteria = DetachedCriteria.forClass(CrmCourseType.class);
		

		String courseName = cct.getCourseName();
		if (courseName != null && !"".equals(courseName)) {
			criteria.add(Restrictions.like("courseName", "%" + courseName + "%"));
		}

		String remark = cct.getRemark();
		if (remark != null && !"".equals(remark)) {
			criteria.add(Restrictions.like("remark", "%" + remark + "%"));
		}

		if (tS != 0 && tE != 0) {
			criteria.add(Restrictions.between("total", tS, tE));
		}

		if (tS != 0 && tE == 0) {
			criteria.add(Restrictions.ge("total", tS));
		}

		if (tS == 0 && tE != 0) {
			criteria.add(Restrictions.le("total", tE));
		}

		if (lCS != 0 && lCE!= 0) {
			criteria.add(Restrictions.between("courseCost", lCS, lCE));
		}

		if (lCS != 0 && lCE == 0) {
			criteria.add(Restrictions.ge("courseCost", lCS));
		}

		if (lCS == 0 && lCE != 0) {
			criteria.add(Restrictions.le("courseCost", lCE));
		}

		return criteria;
	}

	@Override
	public pageBean searchbypage(CrmCourseType cct, int currpage, int pagesize, int tS, int tE, double lCS, double lCE) {
		// TODO Auto-generated method stub

		if (cct != null) {
			DetachedCriteria criteria = getCriteria(cct, tS, tE, lCS, lCE);
			int count = daoCrs.getCount(criteria);
			int totalpage = (int) Math.ceil(count * 1.0 / pagesize);
			pageBean pb = new pageBean();
			pb.setCurrpage(currpage);
			pb.setCount(count);
			pb.setTotalpage(totalpage);
			pb.setPagesize(pagesize);
			pb.setCcts(daoCrs.search(criteria,currpage,pagesize));
			return pb;
		}else {
			pageBean pb = searchbypage(currpage, pagesize);
			return pb;
		}

	}

	private pageBean searchbypage(int currpage, int pagesize) {
		// TODO Auto-generated method stub
		
		int c = daoCrs.getCount();
		int totalpage = (int) Math.ceil(c * 1.0 / pagesize);
		pageBean pb = new pageBean();
		pb.setCurrpage(currpage);
		pb.setCount(c);
		pb.setTotalpage(totalpage);
		pb.setPagesize(pagesize);
		pb.setCcts(daoCrs.searchbypage(currpage, pagesize));
		return pb;

	}

}
