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

public class writeAction extends ActionSupport {
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
	
	private int ref;
	private int ref_level;
	private int ref_step;
	
	//댓글
	private String commenter;
	private String comment;
	private String passwd;
	private Date regdate;
	
	private CommentVO commentClass;
	
	
	
	Calendar today = Calendar.getInstance();
	
	//Upload에는 boardWrite.jsp에서 업로드한 파일의 임시파일 경로가 담겨있다.
	private File Upload;
	private String uploadContentType;
	private String uploadFileName;
	//private String fileUploadPath = "C:\\Users\\user1\\Desktop\\upload\\";
	private String fileUploadPath = "C:\\Users\\yk\\Desktop\\upload\\";
	
	public writeAction() throws IOException {
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
		
		//boardWrite.jsp에서 사용자가 입력한 값을 받아 객체에 담는다.
		paramClass.setSubject(getSubject());
		paramClass.setName(getName());
		paramClass.setPassword(getPassword());
		paramClass.setContent(getContent());
		paramClass.setRegdate(today.getTime());
		
		paramClass.setRef(getRef());
		paramClass.setRef_level(getRef_level());
		paramClass.setRef_step(getRef_step());
		
		//객체를 DB에 삽입한다.
		sqlMapper.insert("insertBoard", paramClass);
		

		
		//업로드 파일을 첨부 했을 경우 실행
		if(getUpload() != null) {
			//DB에서 num 칼럼에서 최대값에 해당하는 게시글을 가져와 객체에 담는다.
			resultClass = (boardVO) sqlMapper.queryForObject("selectLastNo");
		
			//파일명 + num값
			String file_name = "file_" + resultClass.getNo();
			//파일 확장자를 가져온다
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1, getUploadFileName().length());
			//파일의 경로와 이름을 file객체에 담는다
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			//임시파일을 복사 후 설정한 이름과 경로(서버 컴퓨터)에 저장한다.원본이름을 그대로 저장하면 파일중복이 발생할 수 있다.
			FileUtils.copyFile(getUpload(), destFile);
			
			paramClass.setNo(resultClass.getNo());
			paramClass.setFile_orgname(getUploadFileName());
			paramClass.setFile_savname(file_name+"."+file_ext);
			
			//DB에 파일의 원본이름과 새로 설정한 이름을 업데이트한다.
			sqlMapper.update("updateFile", paramClass);
		}
		
		return SUCCESS;
	}
	
public String execute2() throws Exception{
	paramClass = new boardVO();

		commentClass = new CommentVO();
		
		commentClass.setNo(getNo());
		commentClass.setCommenter(getCommenter());
		commentClass.setComment(getComment());
		commentClass.setPasswd(getPasswd());
		commentClass.setRegdate(today.getTime());
		
		paramClass.setNo(getNo());
		
		sqlMapper.insert("insertComment", commentClass); 
		sqlMapper.update("updateComCount",paramClass);
		
		return SUCCESS;
	}

public String idcheck() throws Exception {
	
	return SUCCESS;
}

public String emailcheck() throws Exception {
	
	return SUCCESS;
}

public String joinform() throws Exception {
	
	return SUCCESS;
}

public String agree() throws Exception {
	
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

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public CommentVO getCommentClass() {
		return commentClass;
	}

	public void setCommentClass(CommentVO commentClass) {
		this.commentClass = commentClass;
	}
	
	
	
	
}
