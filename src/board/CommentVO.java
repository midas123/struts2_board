package board;

import java.util.Date;


public class CommentVO {
	
	private int no;
	private String commenter;
	private String comment;
	private String passwd;
	private Date regdate;
	private int commentNum;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getCommmentNum() {
		return commentNum;
	}
	public void setCommmentNum(int commmentNum) {
		this.commentNum = commmentNum;
	}
	
}
