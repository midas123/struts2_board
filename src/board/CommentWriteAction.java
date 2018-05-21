package board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import board.CommentVO;


public class CommentWriteAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private String commenter;
	private String comment;
	private String passwd;
	private Date regdate;
	
	private int no;
	private CommentVO commentClass;
	
	Calendar today = Calendar.getInstance();
	
public CommentWriteAction() throws IOException {
	// TODO Auto-generated constructor stub
	reader = Resources.getResourceAsReader("sqlMapConfig.xml");
	sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
	reader.close();

}
	
	
	public String execute() throws Exception{
		
		commentClass = new CommentVO();
		
		commentClass.setNo(getNo());
		commentClass.setCommenter(getCommenter());
		commentClass.setComment(getComment());
		commentClass.setPasswd(getPasswd());
		commentClass.setRegdate(today.getTime());

		sqlMapper.insert("insertComment", commentClass); 
		
		return SUCCESS;
	}


	public static Reader getReader() {
		return reader;
	}


	public static void setReader(Reader reader) {
		CommentWriteAction.reader = reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		CommentWriteAction.sqlMapper = sqlMapper;
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


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
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


	public Calendar getToday() {
		return today;
	}


	public void setToday(Calendar today) {
		this.today = today;
	}
	
	
	
}
