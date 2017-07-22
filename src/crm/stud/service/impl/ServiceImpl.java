package crm.stud.service.impl;

import java.util.List;
import java.util.Set;

import crm.clazz.domain.CrmClass;
import crm.course.domain.CrmCourseType;
import crm.stud.dao.Dao;
import crm.stud.domain.CrmStudent;
import crm.stud.service.Service;

public class ServiceImpl implements Service {
	
	
	private Dao daoStu;
	private crm.clazz.service.Service serviceClz;
	private crm.course.service.Service serviceCrs;
	
	
	@Override
	public List<CrmStudent> findall() {
		// TODO Auto-generated method stub
		return daoStu.findall();
	}

	@Override
	public List<CrmCourseType> findallcourse() {
		// TODO Auto-generated method stub
		return serviceCrs.findall();
	}

	@Override
	public List<CrmClass> findallclass() {
		// TODO Auto-generated method stub
		return serviceClz.findall();
	}

	public Dao getDaoStu() {
		return daoStu;
	}
	
	public void setDaoStu(Dao daoStu) {
		this.daoStu = daoStu;
	}
	public crm.clazz.service.Service getServiceClz() {
		return serviceClz;
	}

	public void setServiceClz(crm.clazz.service.Service serviceClz) {
		this.serviceClz = serviceClz;
	}


	public crm.course.service.Service getServiceCrs() {
		return serviceCrs;
	}


	public void setServiceCrs(crm.course.service.Service serviceCrs) {
		this.serviceCrs = serviceCrs;
	}

	@Override
	public Set<CrmClass> findcoursebyid(String string) {
		// TODO Auto-generated method stub
		return serviceCrs.findbyid(string).getCrmClasses();
	}


}
