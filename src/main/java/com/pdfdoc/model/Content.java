package com.pdfdoc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 문서 정보
 */
public class Content {

	private String fileName;
	
	private List<Page> pageList;
	
	// 문항정보
	private List<QuestionInfo> questionList;

	public Content() {
		this.questionList = new ArrayList<QuestionInfo>();
		
	}
	
	
	public String getFileName() {
		return fileName;
	}




	public List<Page> getPageList() {
		return pageList;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setPageList(List<Page> pageList) {
		this.pageList = pageList;
	}
	public void addPage(Page page) {
		this.pageList.add(page);
	}


	public List<QuestionInfo> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<QuestionInfo> questionList) {
		this.questionList = questionList;
	}
	
	public void addQuestionList(List<QuestionInfo> questionList) {
		this.questionList.addAll(questionList);
	}

	@Override
	public String toString() {
		return "Content [fileName=" + fileName + "\n questionList=" + questionList + "]";
	}
	
	

}
