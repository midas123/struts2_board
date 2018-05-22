package board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.io.IOException;


public class deleteAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private boardVO paramClass;
	private boardVO resultClass;

	private int currentPage;
	
	private String fileUploadPath = "C:\\Users\\user1\\Desktop\\upload\\";
	
	private int no;
	
	private int commentNum;
	private CommentVO commentClass;
	
	public deleteAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		paramClass = new boardVO();
		resultClass = new boardVO();
		
		resultClass = (boardVO) sqlMapper.queryForObject("selectOne", getNo());
		
		File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
		deleteFile.delete();
		
		paramClass.setNo(getNo());
	
		sqlMapper.update("deleteBoard", paramClass);
	
		return SUCCESS;
	}


	public String execute2() throws Exception {
		commentClass = new CommentVO();
		resultClass = new boardVO();
		paramClass = new boardVO();


		commentClass.setCommmentNum(getCommentNum());
		
		sqlMapper.update("deleteComment", commentClass);
		paramClass.setNo(getNo());
		sqlMapper.update("updateComCount",paramClass);

		return SUCCESS;
		
	}
	
	
	
	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public CommentVO getCommentClass() {
		return commentClass;
	}

	public void setCommentClass(CommentVO commentClass) {
		this.commentClass = commentClass;
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

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public int getNo() {
		return no;
	}

	public static void setReader(Reader reader) {
		deleteAction.reader = reader;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		deleteAction.sqlMapper = sqlMapper;
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

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public void setNo(int no) {
		this.no = no;
	}

	
	
}
