package board;

public class pagingAction {

	private int currentPage;
	private int totalCount;
	private int totalPage;
	private int blockCount; // 한 페이지의  게시물의 수
	private int blockPage; // 한 화면에 보여줄 페이지 수
	private int startCount; // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount; // 한 페이지에서 보여줄 게시글의 끝 번호
	private int startPage;
	private int endPage;
	
	private StringBuffer pagingHtml;

	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage) {
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		//전체 게시글수/페이지당 게시글 수 -> 소수점 올림한 값을 toalPage에 담는다.
		totalPage= (int) Math.ceil((double) totalCount/ blockCount);
		
		//전체 게시글 수가 0일 경우를 대비해서
		if(totalPage ==0) {
			totalPage = 1;
		}
		
		if(currentPage>totalPage) {
			currentPage = totalPage;
		}
		
		startCount = (currentPage -1) * blockCount;
		endCount = startCount + blockCount -1;
	
		startPage = (int) ((currentPage -1) / blockPage) * blockPage +1;
		endPage = startPage + blockPage -1;
		
		if(endPage >totalPage) {
			endPage = totalPage;
		}
		
		pagingHtml = new StringBuffer();
		if(currentPage > blockPage) {
			pagingHtml.append("<a href=listAction.action?currentPage="+ (startPage -1) + ">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		}
		
		pagingHtml.append("&nbsp;|&nbsp;");
		
		
		for(int i = startPage; i <= endPage; i++) {
			if(i >totalPage) {
				break;
			}
			
			if(i== currentPage) {
				pagingHtml.append("&nbsp;<b> <font color='red'>");
				pagingHtml.append(i);
				pagingHtml.append("</font></b>");
			} else {
				pagingHtml.append("&nbsp;<a href='listAction.action?currentPage=");
				pagingHtml.append(i);
				pagingHtml.append("'>");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
			
			pagingHtml.append("&nbsp;");
		}
		pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
		
		if(totalPage - startPage >= blockPage) {
			pagingHtml.append("<a href=listAction.action?currentPage=" + (endPage + 1) + ">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setPagingHtml(StringBuffer pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	
	
	
	
	
	
}
