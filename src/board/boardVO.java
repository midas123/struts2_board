package board;

import java.util.Date;

public class boardVO {

	private int no;
	private String subject;
	private String name;
	private String password;
	private String content;
	private String file_orgname;
	private String file_savname;
	private int readhit;
	private Date regdate;
	
	private int ref;
	private int ref_level;
	private int ref_step;
	private int comment_count;
	
	private String search;
	
	
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
	public String getFile_orgname() {
		return file_orgname;
	}
	public String getFile_savname() {
		return file_savname;
	}
	public int getReadhit() {
		return readhit;
	}
	public Date getRegdate() {
		return regdate;
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
	public void setFile_orgname(String file_orgname) {
		this.file_orgname = file_orgname;
	}
	public void setFile_savname(String file_savname) {
		this.file_savname = file_savname;
	}
	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	
	
	
	
	
}
