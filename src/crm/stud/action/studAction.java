package crm.stud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.clazz.domain.CrmClass;
import crm.course.domain.CrmCourseType;
import crm.stud.domain.CrmStudent;
import crm.stud.service.Service;

public class studAction extends ActionSupport implements ModelDriven<CrmStudent> {

	private static final long serialVersionUID = 1L;

	private CrmStudent student = new CrmStudent();
	
	private Service serviceStu;
	
	private List<CrmStudent> csts;
	private List<CrmClass> ccs;
	private List<CrmCourseType> ccts;


	@Override
	public CrmStudent getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	
	
	public String findall(){
		csts = serviceStu.findall();
		return "findall";
	}
	
	public String preadd(){
		ccs = serviceStu.findallclass();
		ccts = serviceStu.findallcourse();
		return "preadd";
	}
	
	
	public String changecourse(){
		
		
		
		
		Set<CrmClass> ccs = serviceStu.findcoursebyid(student.getCrmClass().getCrmCourseType().getCourseTypeId());
		System.out.println(ccs);
		/*Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
			
			@Override
			public boolean shouldSkipField(FieldAttributes arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean shouldSkipClass(Class<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		}).create();*/
		
		
		
		/*HttpServletResponse res = ServletActionContext.getResponse();
		try {
			PrintWriter out = res.getWriter();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return NONE;
	}
	
	

	public CrmStudent getStudent() {
		return student;
	}

	public void setStudent(CrmStudent student) {
		this.student = student;
	}

	public Service getServiceStu() {
		return serviceStu;
	}

	public void setServiceStu(Service serviceStu) {
		this.serviceStu = serviceStu;
	}


	public List<CrmStudent> getCsts() {
		return csts;
	}


	public void setCsts(List<CrmStudent> csts) {
		this.csts = csts;
	}


	public List<CrmClass> getCcs() {
		return ccs;
	}


	public void setCcs(List<CrmClass> ccs) {
		this.ccs = ccs;
	}


	public List<CrmCourseType> getCcts() {
		return ccts;
	}


	public void setCcts(List<CrmCourseType> ccts) {
		this.ccts = ccts;
	}


}
