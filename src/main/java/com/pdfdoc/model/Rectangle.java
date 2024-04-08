package com.pdfdoc.model;

import java.util.Arrays;

import org.apache.pdfbox.text.TextPosition;

/**
 * 문자열
 */
public class Rectangle {

	public final static int X = 0;
	public final static int Y = 1;
	public final static int END_X = 2;
	public final static int END_Y = 3;
	
	
	private String name;
	private TextPosition tp;
	private float[] arr = new float[4];
	
	public Rectangle() {}
	
	public Rectangle(float a, float b, float c, float d) {
		arr[X] =a;
		arr[Y] =b;
		arr[END_X] =c;
		arr[END_Y] =d;
	}
	
	public Rectangle(String n, TextPosition tp) {
		name = n;
		this.tp = tp;
		
		arr[X] = (float) Math.floor( tp.getX() );
		arr[Y] = (float) Math.ceil( tp.getY() - tp.getYScale());
		arr[END_X] = (float) Math.ceil(tp.getEndX()); // tp.getWidth();
		arr[END_Y] =  (float) Math.ceil(tp.getY());   // tp.getEndY();  //tp.getY() ;
	}
	
	public float[] get() {
		return arr;
	}
	
	public float get(int i) {
		return arr[i];
	}
	
	public void set(int i , float x) {
		arr[i] = x;
	}
	
	public void setMax(int i , float x) {
		arr[i] = Math.max(arr[i], x);
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public TextPosition getTp() {
		return tp;
	}

	@Override
	public String toString() {
		return name + "[" + Arrays.toString(arr) + "]\n";
	}
	
	
	
}
