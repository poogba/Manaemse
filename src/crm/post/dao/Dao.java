package crm.post.dao;

import java.util.List;

import crm.post.domain.CrmPost;

public interface Dao {

	List<CrmPost> findall();

	void addpost(CrmPost cp);

	CrmPost findbyid(String postId);

	void update(CrmPost cp);

}
