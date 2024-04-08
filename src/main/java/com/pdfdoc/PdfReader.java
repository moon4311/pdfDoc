package com.pdfdoc;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;

import com.pdfdoc.model.Choice;
import com.pdfdoc.model.Content;
import com.pdfdoc.model.QuestionInfo;
import com.pdfdoc.model.Rectangle;

public class PdfReader {

	public static Content read(String filePath,String fileName) throws IOException {
		
		Content cont = null;
		PDDocument document = null;
		try {
			File pdfFile = new File(filePath, fileName);
			document = PDDocument.load(pdfFile) ;
			cont = read( document );
			cont.setFileName(fileName);
			
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			document.close();
		}
		
		return cont;
	}
	
	
	public static Content read(PDDocument document) throws IOException {
		
//		List<Page> pageList = new ArrayList<Page>();
		Content cont = new Content();
		
		try {
			
			int pageSize = document.getNumberOfPages();
			for(int i=0;i<pageSize;i++) {
				GetTextPositions stripper = new GetTextPositions();
				stripper.setSortByPosition(false);
				stripper.setStartPage(i); // 설정에 따라 변경
				stripper.setEndPage(i);
				stripper.getText(document);
				
//				Page page = new Page(i+1,document.getPage(i) );
				
				
				for(QuestionInfo qInfo : stripper.getQuestionList()) {
					qInfo.setPage(i);
				}
				
				questionChoiceMapping( stripper );
				cont.addQuestionList(stripper.getQuestionList());
//				pageList.add(page);
			}
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cont;
	}
	
	private static void questionChoiceMapping( GetTextPositions stripper) {
		List<QuestionInfo> questionList = stripper.getQuestionList();
		
		// 보기 낱개
		List<Rectangle> choiceElementList = stripper.getChoiceList();

		int i = 0;
		int q = 0;
		Choice ch = new Choice();
		for(Rectangle r : choiceElementList) {
			ch.setChoices(i++, r);
			if(i==5){
				ch.setChoiceGroup();
				questionList.get(q).setChoice(ch);
				ch = new Choice();
				i=0;
				q++;
			}
		}
		questionList.stream().forEach(o-> System.err.println(o));
		
	}
	
	
	// 이미지
	private void getXObjects(PDResources res)throws IOException {
		for(COSName objName : res.getXObjectNames()) {
			PDXObject obj = res.getXObject(objName);
			
			String type = obj.getCOSObject().getCOSName(COSName.SUBTYPE).getName();
			String name = obj.getCOSObject().getCOSName(COSName.NAME).getName();
			System.out.println(type + " : " + name);
			if("Image".equals(type)) {
//				PDImageXObject img = (PDImageXObject) obj;
//				BufferedImage image = img.getImage()/* your image */;
//				String filePath = "image_"+name+".png";
//				ImageIO.write(image, "png", new File(filePath));
			}else {
			}
		}
	}
	
}
