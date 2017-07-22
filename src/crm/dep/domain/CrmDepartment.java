package crm.dep.domain;
// Generated 2017-6-7 11:09:42 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * CrmDepartment generated by hbm2java
 */
public class CrmDepartment implements java.io.Serializable {

	private String depId;
	private String depName;
	private Set crmPosts = new HashSet(0);

	public CrmDepartment() {
	}

	public CrmDepartment(String depId) {
		this.depId = depId;
	}

	public CrmDepartment(String depId, String depName, Set crmPosts) {
		this.depId = depId;
		this.depName = depName;
		this.crmPosts = crmPosts;
	}

	public String getDepId() {
		return this.depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set getCrmPosts() {
		return this.crmPosts;
	}

	public void setCrmPosts(Set crmPosts) {
		this.crmPosts = crmPosts;
	}

	@Override
	public String toString() {
		return "CrmDepartment [depId=" + depId + ", depName=" + depName + "]";
	}

	

}
