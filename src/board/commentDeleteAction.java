package board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;


public class commentDeleteAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private int currentPage;
	private int no;
	
	private int commentNum;
	private CommentVO commentClass;
	
	
	public commentDeleteAction() throws IOException{
		// TODO Auto-generated constructor stub
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	
	}
	
	public String execute() throws Exception {
		commentClass = new CommentVO();
		
		commentClass.setCommmentNum(getCommentNum());
		
		sqlMapper.update("deleteComment", commentClass);
		
		return SUCCESS;
		
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		commentDeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		commentDeleteAction.sqlMapper = sqlMapper;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
	
	
}
