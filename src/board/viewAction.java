package board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;
import java.io.IOException;

import java.net.URLEncoder;


public class viewAction extends ActionSupport {

	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private boardVO paramClass = new boardVO();
	private boardVO resultClass = new boardVO();

	private int currentPage;
	private int ref;
	private int ref_level;
	private int ref_step;
	
	private int no;
	private String password;

	private String fileUploadPath = "C:\\Users\\user1\\Desktop\\upload\\";
	
	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;
	
	public viewAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass.setNo(getNo());
		sqlMapper.update("updateReadHit", paramClass);
		resultClass = (boardVO) sqlMapper.queryForObject("selectOne", getNo());
		
		return SUCCESS;
		
	}
	
	public String download() throws Exception {
		resultClass = (boardVO) sqlMapper.queryForObject("selectOne", getNo());
	
		File fileInfo = new File(fileUploadPath + resultClass.getFile_savname());
		System.out.println(fileInfo);
		setContentLength(fileInfo.length());
		setContentDisposition("attachment;filename="+URLEncoder.encode(resultClass.getFile_orgname(), "UTF-8"));
		System.out.println(contentDisposition);
		setInputStream(new FileInputStream(fileUploadPath + resultClass.getFile_savname()));
		
		return SUCCESS;
	}
	
	public String checkForm() throws Exception {
		return SUCCESS;
	}
	
	public String checkAction() throws Exception {
		paramClass.setNo(getNo());
		paramClass.setPassword(getPassword());
		
		resultClass = (boardVO) sqlMapper.queryForObject("selectPassword", paramClass);
		
		if(resultClass == null)
			return ERROR;
		
		
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

	public String getPassword() {
		return password;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public static void setReader(Reader reader) {
		viewAction.reader = reader;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		viewAction.sqlMapper = sqlMapper;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public void setContentLength(long contenLength) {
		this.contentLength = contenLength;
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
	
	
	
	
}
