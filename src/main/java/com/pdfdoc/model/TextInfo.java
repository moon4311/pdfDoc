package com.pdfdoc.model;

import java.util.List;

import org.apache.pdfbox.text.TextPosition;

public class TextInfo {

	//문자열
	private String text;
	
	//문자열 위치
	private Rectangle position;
	
	//글자별 위치
	private List<TextPosition> textPositionList;
	
	public TextInfo(String t,List<TextPosition> tpList) {
		this.text = t;
		this.textPositionList = tpList;
		
		for (TextPosition tp : tpList) {
			
			if(this.position == null) {
				this.position = new Rectangle(tp.getX(), tp.getY(), tp.getEndX(), tp.getEndY());
			}
			
			if( position.get(2) < tp.getEndX())
				position.set(2, tp.getEndX());

			if( position.get(3) < tp.getEndY())
				position.set(3, tp.getEndY());
            
        }
		
		// TODO Auto-generated constructor stub
	}

	public String getText() {
		return text;
	}

	public Rectangle getPosition() {
		return position;
	}


	public List<TextPosition> getTextPositionList() {
		return textPositionList;
	}

	@Override
	public String toString() {
		return "TextInfo [" + text + ", " + position + "]";
	}


	
	
	
	
}
