package crm.post.service;

import java.util.List;

import crm.dep.domain.CrmDepartment;
import crm.post.domain.CrmPost;

public interface Service {

	List<CrmPost> findall();

	CrmPost findbyid(String postId);

	List<CrmDepartment> findcds();

	void addpost(CrmPost cp);

	void update(CrmPost cp);

	CrmDepartment findinnerbyid(String depId);


}
