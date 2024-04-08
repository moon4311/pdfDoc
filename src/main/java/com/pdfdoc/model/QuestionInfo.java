package com.pdfdoc.model;

/**
 * 문항 정보
 * Page > QuestionInfo
 */
public class QuestionInfo {

	//문항번호
	private String questionNo;

	//페이지
	private int page;
	
	//문항 숫자 위치
	private Rectangle questionNoPosition;
	
	//문항 위치
	private Rectangle questionPosition;
	
	//보기 1~5 위치
	private Choice choice;
	
	//문제내용
	private String questionStr;
	
	private String questionType = "주관식";
	
	
	public QuestionInfo(String t, Rectangle small) {
		this.questionNo = t;
		this.questionNoPosition = small;
		
	}
	
	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public Choice getChoice() {
		return choice;
	}


	public void setChoice(Choice choice) {
		this.choice = choice;
		questionType = "객관식";
	}

	public Rectangle getQuestionNoPosition() {
		return questionNoPosition;
	}

	public void setQuestionNoPosition(Rectangle questionNoPosition) {
		this.questionNoPosition = questionNoPosition;
	}

	public String getQuestionStr() {
		return questionStr;
	}


	public void setQuestionStr(String questionStr) {
		this.questionStr = questionStr;
	}


	@Override
	public String toString() {
		
		if("객관식".equals(questionType)) {
			return "== Question == \n" + questionNo + "[객관식] "+page+"page ," + questionNoPosition + choice +"}";
		}else {
			return "== Question == \n" + questionNo +"[주관식]"+page+"page ," + questionNoPosition + "}";
		}
		
	}
	
	
	

}
