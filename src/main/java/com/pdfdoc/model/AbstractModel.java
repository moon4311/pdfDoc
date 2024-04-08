package com.pdfdoc.model;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;

public class AbstractModel {

	public static final COSBase getCOS(COSDictionary d, COSName key) {
		return d.getCOSObject(key);
	}
	
	public static final COSObject getObj(COSDictionary d, COSName key) {
		return (COSObject) getCOS(d,key);
	}
	
	public static final String getName(COSDictionary d, COSName key) {
		COSName n = d.getCOSName(key);
		return n == null ? null : n.getName();
	}
	
	public static final String getString(COSDictionary d, COSName key) {
		return d.getString(key);
	}
	
	public static final int getInt(COSDictionary d, COSName key) {
		return d.getInt(key);
	}
	
	public static final COSDictionary getDict(COSDictionary d, COSName key) {
		return d.getCOSDictionary(key);
	}
	
}
