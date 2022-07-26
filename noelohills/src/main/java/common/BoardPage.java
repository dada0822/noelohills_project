package common;

public class BoardPage {
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		
		String pagingStr = "";
		
		// ��ü ������ �� ���
		int totalPages = (int)(Math.ceil((double)totalCount / pageSize));
		
		// ���� ������ ��� �ٷΰ��� ���
		// 1~5 ������ -> 1, 6~10 ������ -> 6
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
		
		if (pageTemp != 1) {
			pagingStr = "<a href='" + reqUrl + "?pageNum=1'>[ù ������] </a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageTemp - 1) + "'>[���� ���] </a>";
		}
		
		// �� �������� ��ȣ ���
		int blockCount = 1;
		
		while(blockCount <= blockPage && pageTemp <= totalPages) {
			if(pageTemp == pageNum) {
				pagingStr += "&nbsp; " + pageTemp + "&nbsp;";
			} else {
				pagingStr += "&nbsp; <a href='" + reqUrl + "?pageNum=" + pageTemp + "'>" + pageTemp + "</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}
		
		// ���� ������ ��� �ٷΰ��� ���
		if (pageTemp <= totalPages) {
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageTemp + "'>[���� ���] </a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages + "'>[������ ������] </a>";
		}
		return pagingStr;
	}
}