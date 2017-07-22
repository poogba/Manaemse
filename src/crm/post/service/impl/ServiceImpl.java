package crm.post.service.impl;

import java.util.List;
import crm.dep.domain.CrmDepartment;
import crm.post.dao.Dao;
import crm.post.domain.CrmPost;
import crm.post.service.Service;

public class ServiceImpl implements Service {
	
	private Dao dao;
	
	private crm.dep.service.Service serviceDep;

	@Override
	public List<CrmPost> findall() {
		// TODO Auto-generated method stub
		return dao.findall();
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public CrmPost findbyid(String postId) {
		// TODO Auto-generated method stub
		return dao.findbyid(postId);
	}

	@Override
	public List<CrmDepartment> findcds() {
		// TODO Auto-generated method stub
		return serviceDep.findall();
	}

	public crm.dep.service.Service getServiceDep() {
		return serviceDep;
	}

	public void setServiceDep(crm.dep.service.Service serviceDep) {
		this.serviceDep = serviceDep;
	}

	@Override
	public void addpost(CrmPost cp) {
		// TODO Auto-generated method stub
		dao.addpost(cp);
	}

	@Override
	public void update(CrmPost cp) {
		// TODO Auto-generated method stub
		dao.update(cp);
	}

	@Override
	public CrmDepartment findinnerbyid(String depId) {
		// TODO Auto-generated method stub
		
		return serviceDep.findbyid(depId);
		
	}
 
}
