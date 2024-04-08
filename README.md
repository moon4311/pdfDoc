사용법.

//응답값 선언 
Content cont = null;

1) 파일경로를 이용하는 방법  (document.close() 포함 )
try {
	cont = PdfReader.read(INPUT_PATH, command.getFilePath());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

2) PDDocument를 이용하는 방법 ( document.close() 필요 )

File sourceFile = new File(INPUT_PATH, command.getFilePath());
PDDocument document = PDDocument.load(sourceFile);

try {
	cont = PdfReader.read(document);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally{
    document.close();
}
