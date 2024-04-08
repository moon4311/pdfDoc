package com.pdfdoc.model;

import java.util.List;

import org.apache.pdfbox.pdmodel.PDPage;

/**
 * Page 별 정보
 */
public class Page {

	//페이지 번호
	private int pageNo;

	//PDF 페이지 정보
	private PDPage pdPage;
	
	private int section; //단 정보
	
	public Page(int pageNo, PDPage pdPage) {
		this.pageNo = pageNo;
		this.pdPage	= pdPage;
		// TODO Auto-generated constructor stub
	}
	

	public int getPageNo() {
		return pageNo;
	}

	public PDPage getPdPage() {
		return pdPage;
	}
	
	public float getWidth() {
		return pdPage.getMediaBox().getWidth();
	}

	public float getHeight() {
		return pdPage.getMediaBox().getHeight();
	}

}
