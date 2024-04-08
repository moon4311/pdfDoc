package com.pdfdoc.survival.math;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pdfdoc.model.Page;

public class SurvivalMathExam {

	private Map<String,Object> numberInfo = new HashMap();
	
	// 문항번호_폰트
	private final String QUESTION_NO_FONT = "T2";
	// 문항번호_사이즈
	private final float QUESTION_NO_FONT_SIZE= 113;
	
	// 문제내용_폰트
	private final String QUESTION_TEXT_FONT = "T15";
	// 문제내용_사이즈
	private final float QUESTION_TEXT_FONT_SIZE= 96;
	
	// 보기_폰트
	private final String QUESTION_CHOICE_FONT = "T11";
	// 보기_사이즈
	private final float QUESTION_CHOICE_FONT_SIZE= 96;
	
	
	private List<Page> pageList;
	
	
	
	public SurvivalMathExam() {
		// TODO Auto-generated constructor stub
	}
	
}
