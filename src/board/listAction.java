package board;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

import board.pagingAction;
import board.CommentVO;

public class listAction extends ActionSupport {
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private List<boardVO> list = new ArrayList<boardVO>();
	
	private int currentPage = 1;
	private int totalCount;
	private int blockCount =10;
	private int blockPage =5;
	private String pagingHtml;
	private pagingAction page;
	
	private int ref;
	private int ref_step =0;
	private int ref_level=0;
	
	private int comment_count;

	public listAction() throws IOException{
		// TODO Auto-generated constructor stub
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper =SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		list = sqlMapper.queryForList("selectAll");
		totalCount = list.size();
		
		//boardList.jsp 하단에 출력될 페이징 넘버와 이전,다음 문자를 html 형태로 가져온다.
		page = new pagingAction(currentPage, totalCount, blockCount, blockPage);
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		//pagingAction의 startcount와 endcount로 한 페이지에서 출력될 게시글을 선택한다.
		if(page.getEndCount() <totalCount)
			//배열 인덱스 넘버이므로 1을 더한다.
			lastCount = page.getEndCount() + 1;
		list = list.subList(page.getStartCount(), lastCount);
		
		
		
		
		return SUCCESS;
	}
	

	public static Reader getReader() {
		return reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public List<boardVO> getList() {
		return list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public pagingAction getPage() {
		return page;
	}

	public static void setReader(Reader reader) {
		listAction.reader = reader;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		listAction.sqlMapper = sqlMapper;
	}

	public void setList(List<boardVO> list) {
		this.list = list;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public void setPage(pagingAction page) {
		this.page = page;
	}

	public int getRef_step() {
		return ref_step;
	}

	public int getRef_level() {
		return ref_level;
	}

	public void setRef_step(int ref_step) {
		this.ref_step = ref_step;
	}

	public void setRef_level(int ref_level) {
		this.ref_level = ref_level;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}	
	
	
	

}
