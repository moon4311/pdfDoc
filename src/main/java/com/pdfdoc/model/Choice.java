package com.pdfdoc.model;

import java.util.Arrays;

/**
 * 보기 정보 ① ② ③ ④ ⑤
 * Page > QuestionInfo > Choice 
 */
public class Choice {

	private String questionNo;
	
	private Rectangle choiceGroup;	// 보기 그룹 값
	private Rectangle[] choices = new Rectangle[5] ;	//보기 1,2,3,4,5
	
	public Choice() {
	}
	
	public float getMinX() {
		return getMin(0);
	}
	
	public float getMinY() {
		return getMin(1);
	}
	
	public float getMin(int i) {
		float min = Math.min(choices[0].get(i), choices[1].get(i));
		min = Math.min(min, choices[2].get(i));
		min = Math.min(min, choices[3].get(i));
		min = Math.min(min, choices[4].get(i));
		return min;
	}
	
	public String getQuestionNo() {
		return questionNo;
	}
	
	public void setQuestionNo(String q) {
		questionNo = q;
	}
	
	
	public Rectangle getChoiceGroup() {
		return choiceGroup;
	}


	// TODO 
	// 현재 : 전각문자 기준으로 사각형 그림
	// 변경 : 각 보기의 값의 사각형을 기준 잡을 것..?
	public void setChoiceGroup() {
		
		float x = choices[0].get(0);	// 보기 1번 의 x값
		float y = choices[0].get(1);	// 보기 1번 의 y값
		
		float endX = choices[4].get(2);	// 보기 5번의 endX 값
		float endY = choices[4].get(3);	// 보기 5번의 endX 값
		
		this.choiceGroup = new Rectangle(x,y,endX,endY);
		
	}
	

	public Rectangle[] getChoices() {
		return choices;
	}

	public void setChoices(int i, Rectangle r) {
		choices[i] = r;
	}

	@Override
	public String toString() {
		return "==Choice== \n" + Arrays.toString(choices);
	}

}
