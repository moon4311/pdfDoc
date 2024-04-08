package com.pdfdoc;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		
		PdfReader reader = new PdfReader();
		reader.read("/home/hc/input/temp/","2024학년도 모의고사 수학 서바이벌 14회차 문제지.pdf");
		
	}

}
