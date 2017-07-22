package crm.clazz.service.impl;

import java.util.List;
import crm.clazz.dao.Dao;
import crm.clazz.domain.CrmClass;
import crm.clazz.service.Service;
import crm.course.domain.CrmCourseType;

public class ServiceImpl implements Service {
	
	
	private Dao daoClz;
	
	private crm.course.service.Service serviceCrs;

	@Override
	public List<CrmClass> findall() {
		// TODO Auto-generated method stub
		return daoClz.findall();
	}

	public Dao getDaoClz() {
		return daoClz;
	}

	public void setDaoClz(Dao daoClz) {
		this.daoClz = daoClz;
	}

	@Override
	public List<CrmCourseType> listccts() {
		// TODO Auto-generated method stub
		return serviceCrs.findall();
	}

	public crm.course.service.Service getServiceCrs() {
		return serviceCrs;
	}

	public void setServiceCrs(crm.course.service.Service serviceCrs) {
		this.serviceCrs = serviceCrs;
	}

	@Override
	public void add(CrmClass ccs) {
		// TODO Auto-generated method stub
		daoClz.add(ccs);
	}

	@Override
	public CrmClass findbyid(String classId) {
		// TODO Auto-generated method stub
		return daoClz.findbyid(classId);
	}

	@Override
	public void update(CrmClass cc) {
		// TODO Auto-generated method stub
		daoClz.update(cc);
	}

}
