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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.CommentVO;


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
	
	//댓글
	private String commenter;
	private String comment;
	private int commentNum;
	private String passwd;
	private Date regdate;
	private List<CommentVO> commentlist = new ArrayList<CommentVO>();
	private CommentVO commentClass = new CommentVO();
	private CommentVO commentResultClass = new CommentVO();
	

	
	public viewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass.setNo(getNo());
		sqlMapper.update("updateReadHit", paramClass);
		resultClass = (boardVO) sqlMapper.queryForObject("selectOne", getNo());
		
		commentClass.setNo(getNo());
		commentlist = sqlMapper.queryForList("selectcommentAll", commentClass);
		
		return SUCCESS;
		
	}
	
	public String download() throws Exception {
		resultClass = (boardVO) sqlMapper.queryForObject("selectOne", getNo());
	
		File fileInfo = new File(fileUploadPath + resultClass.getFile_savname());
		setContentLength(fileInfo.length());
		setContentDisposition("attachment;filename="+URLEncoder.encode(resultClass.getFile_orgname(), "UTF-8"));
		setInputStream(new FileInputStream(fileUploadPath + resultClass.getFile_savname()));
		
		return SUCCESS;
	}
	
	public String checkForm() throws Exception {
		return SUCCESS;
	}
	
	public String checkForm2() throws Exception {
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
	
	public String checkAction2() throws Exception {
		commentClass.setCommmentNum(getCommentNum());
		commentClass.setPasswd(getPasswd());
		
		commentResultClass = (CommentVO) sqlMapper.queryForObject("selectPassword2",commentClass);
		
		if(commentResultClass == null)
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

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
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

	public List<CommentVO> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<CommentVO> commentlist) {
		this.commentlist = commentlist;
	}

	public CommentVO getCommentClass() {
		return commentClass;
	}

	public void setCommentClass(CommentVO commentClass) {
		this.commentClass = commentClass;
	}

	public CommentVO getCommentResultClass() {
		return commentResultClass;
	}

	public void setCommentResultClass(CommentVO commentResultClass) {
		this.commentResultClass = commentResultClass;
	}
	
	
	
	
}
