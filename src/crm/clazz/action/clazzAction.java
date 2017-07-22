package crm.clazz.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import crm.clazz.domain.CrmClass;
import crm.clazz.service.Service;
import crm.course.domain.CrmCourseType;

public class clazzAction extends ActionSupport implements ModelDriven<CrmClass> {

	private static final long serialVersionUID = 1L;

	private CrmClass cc = new CrmClass();
	private Service serviceClz;
	private List<CrmClass> ccs;
	private List<CrmCourseType> ccts;
	private File upload;
	private String uploadFileName;
	private String fileName;
	private InputStream inputStream;

	@Override
	public CrmClass getModel() {
		// TODO Auto-generated method stub
		return cc;
	}

	public String findall() {
		ccs = getServiceClz().findall();
		return "findall";
	}

	public String preadd(){
		
		ccts = getServiceClz().listccts();
		return "preadd";
	}
	
	
	
	public String add(){
		serviceClz.add(cc);
		return "add";
	}
	
	public String predit(){
		cc=serviceClz.findbyid(cc.getClassId());
		ccts=serviceClz.listccts();
		return "predit";
	}
	
	public String update(){
		serviceClz.update(cc);
		return "update";
	}
	
	
	public String preupload(){
		cc = serviceClz.findbyid(cc.getClassId());
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("cef", cc);
		return "preupload";
	}
	
	
	public String upload(){
		
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		String childPath = getChildPath(path);

		upload.renameTo(new File(path+File.separator+childPath,uploadFileName));
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		cc = (CrmClass) session.getAttribute("cef");
		
		cc.setUploadPath(path+File.separator+childPath+File.separator+uploadFileName);
		cc.setUploadTime(new Date());
		cc.setUploadFilename(uploadFileName);
		
		serviceClz.update(cc);
		session.removeAttribute("cef");
		
		return "upload";
	}
	
	public String download(){
		
		//String path = ServletActionContext.getServletContext().getRealPath("/upload");
		
		cc= serviceClz.findbyid(cc.getClassId());
		
		try {
		
			inputStream = new FileInputStream(cc.getUploadFilename());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "download";
	}
	
	
	
	public String getChildPath(String path){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String childPath = sdf.format(new Date());
		
		File file = new File(path,childPath);
		if(!file.exists()){
			file.mkdirs();
		}
		
		return childPath;
	}
	
	public CrmClass getCc() {
		return cc;
	}

	public void setCc(CrmClass cc) {
		this.cc = cc;
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

	public Service getServiceClz() {
		return serviceClz;
	}

	public void setServiceClz(Service serviceClz) {
		this.serviceClz = serviceClz;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
