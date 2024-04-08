package com.pdfdoc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import com.pdfdoc.model.QuestionInfo;
import com.pdfdoc.model.Rectangle;
import com.pdfdoc.model.TextInfo;
import com.pdfdoc.survival.math.PatternStr;

/**
 * Page별 단어 추출
 */
public class GetTextPositions extends PDFTextStripper {
    
    private String allText;
    
    
    //문자 목록
    private List<TextInfo> textList;
    //문항 목록
    private List<QuestionInfo> questionList;
    
    private List<Rectangle> choiceList;
    
    public GetTextPositions() throws IOException {
    	allText = "";
    	textList = new ArrayList<TextInfo>();
    	questionList = new ArrayList<QuestionInfo>();
    	choiceList = new ArrayList<Rectangle>();
    	
    }
    
    //단어 단위
    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException {

    	Rectangle small = null;

        for (TextPosition tp : textPositions) {

        	if(small==null)
        		small = new Rectangle(string, tp);
        	else {
        		small.setMax(2, (float)Math.ceil(tp.getEndX()) );
        		small.setMax(3, (float)Math.ceil(tp.getY()) );
        	}
        	
        	String s = tp.getUnicode();
        	
        	// 보기문자( ① ② ③ ④ ⑤ )일 경우 choiceList 에 추가
        	if(addChoiceList(tp,s)){ }
        }
        
        //문항번호 판단
    	if( isQuestionNo( string ) ) {
    		String qNo = string.replace(".", "");
    		
    		QuestionInfo qi = new QuestionInfo(qNo, small);
    		questionList.add(qi);
    		return;
    	}
    	
    	allText += string + " ";
    	TextInfo ti = new TextInfo(string, textPositions);
    	textList.add(ti);
        
    }
    
    
    // 문항번호여부 
    private boolean isQuestionNo(String s) {
    	
//    	int fontSize = Math.round( tp.getFontSize());
//    	PDFont font = tp.getFont();
//    	String fontName = font.getName();
    	//font 113 이면서 T2 폰트의 1~9로 시작하는 문자열
//    	return ( fontSize == 113 && fontName.equals("T2") && betweenC(s,49,57)  );
    	return Pattern.matches(PatternStr.QUESTION_NO, s);
    }
    
    // 보기문자여부
    private boolean addChoiceList(TextPosition tp,String s) {
    	if(betweenC(s,9312,9316)) {
    		choiceList.add(new Rectangle(s, tp));
    		return true; 
    	}
    	return false;
    	
    }
    
    private boolean betweenC(String s, int min , int max) {
    	int c = s.charAt(0);
    	return c>=min && c<=max ;
    }
    
	public String getAllText() {
		return allText;
	}

	public List<TextInfo> getTextList() {
		return textList;
	}
	
	public List<QuestionInfo> getQuestionList() {
		return questionList;
	}
	public List<Rectangle> getChoiceList() {
		return choiceList;
	}

}
