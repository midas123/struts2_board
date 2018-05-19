package board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class ReplyArticleAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private boardVO paramClass;
	private boardVO resultClass;
	
	private int currentPage;
	
	private int no;
	private String subject;
	private String name;
	private String password;
	private String content;
	private String file_orgName;
	private String file_savName;
	
	private String replysubject;
	private int ref;
	private int ref_level;
	private int ref_step;
	
	Calendar today = Calendar.getInstance();
	
	private File Upload;
	private String uploadContentType;
	private String uploadFileName;
	private String fileUploadPath = "C:\\Users\\user1\\Desktop\\upload\\";
	
	public ReplyArticleAction() throws IOException {
		// TODO Auto-generated constructor stub
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String form() throws Exception {
		
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		paramClass = new boardVO();
		resultClass = new boardVO();
		
		paramClass.setSubject(getSubject());
		paramClass.setName(getName());
		paramClass.setPassword(getPassword());
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());
		
		paramClass.setRef(getRef());
		paramClass.setRef_level(getRef_level()+1);
		paramClass.setRef_step(getRef_step()+1);
		
		sqlMapper.insert("insertReplyArticle", paramClass);
		
		if(getUpload() != null) {
			resultClass = (boardVO) sqlMapper.queryForObject("selectLastNo");
		
			String file_name = "file_" + resultClass.getNo();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1, getUploadFileName().length());
			
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
		
			paramClass.setNo(resultClass.getNo());
			paramClass.setFile_orgname(getUploadFileName());
			paramClass.setFile_savname(file_name+"."+file_ext);
		
			sqlMapper.update("updateFile", paramClass);
		}
		
		return SUCCESS;
	}
	
	public String goWriteForm() throws Exception {
		replysubject ="[답변]";
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public boardVO getParamClass() {
		return paramClass;
	}

	public boardVO getResultClass() {
		return resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getNo() {
		return no;
	}

	public String getSubject() {
		return subject;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getContent() {
		return content;
	}

	public String getFile_orgName() {
		return file_orgName;
	}

	public String getFile_savName() {
		return file_savName;
	}

	public Calendar getToday() {
		return today;
	}

	public File getUpload() {
		return Upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public static void setReader(Reader reader) {
		writeAction.reader = reader;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		writeAction.sqlMapper = sqlMapper;
	}

	public void setParamClass(boardVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(boardVO resultClass) {
		this.resultClass = resultClass;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setFile_orgName(String file_orgName) {
		this.file_orgName = file_orgName;
	}

	public void setFile_savName(String file_savName) {
		this.file_savName = file_savName;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public void setUpload(File upload) {
		Upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public int getRef() {
		return ref;
	}

	public int getRef_level() {
		return ref_level;
	}

	public int getRef_step() {
		return ref_step;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public void setRef_level(int ref_level) {
		this.ref_level = ref_level;
	}

	public void setRef_step(int ref_step) {
		this.ref_step = ref_step;
	}

	public String getReplysubject() {
		return replysubject;
	}

	public void setReplysubject(String replysubject) {
		this.replysubject = replysubject;
	}
	
	
	
	
}
