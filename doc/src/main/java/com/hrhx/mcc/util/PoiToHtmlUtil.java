package com.hrhx.mcc.util;  
  
import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.util.List;  
  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.transform.OutputKeys;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
  
import org.apache.commons.io.FileUtils;  
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.hwpf.HWPFDocument;  
import org.apache.poi.hwpf.converter.PicturesManager;  
import org.apache.poi.hwpf.converter.WordToHtmlConverter;  
import org.apache.poi.hwpf.usermodel.Picture;  
import org.apache.poi.hwpf.usermodel.PictureType;  
import org.w3c.dom.Document;  
  
public class PoiToHtmlUtil {  
    
   public static void main(String[] args) {
    
}
    /** 
     *  
     * @param path 所在的文件夹 
     * @param inFileName 输入Word文档 
     * @param outFileName 输出Html文档 
     * @throws Throwable 
     */  
    public static void wordToHtml(String path,String inFileName,String outFileName) throws Throwable {  
          
        InputStream input = new FileInputStream(path + inFileName);  
        HWPFDocument wordDocument = new HWPFDocument(input);  
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());  
          
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {  
            public String savePicture(byte[] content, PictureType pictureType,  
                    String suggestedName, float widthInches, float heightInches) {  
                return suggestedName;  
            }  
        });  
          
        wordToHtmlConverter.processDocument(wordDocument);  
        List<Picture> pics = wordDocument.getPicturesTable().getAllPictures();  
        if (pics != null) {  
            for (int i = 0; i < pics.size(); i++) {  
                Picture pic = (Picture) pics.get(i);  
                try {  
                    pic.writeImageContent(new FileOutputStream(path  
                            + pic.suggestFullFileName()));  
                } catch (FileNotFoundException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
          
        Document htmlDocument = wordToHtmlConverter.getDocument();  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        DOMSource domSource = new DOMSource(htmlDocument);  
        StreamResult streamResult = new StreamResult(outStream);  
  
        TransformerFactory tf = TransformerFactory.newInstance();  
        Transformer serializer = tf.newTransformer();  
        serializer.setOutputProperty(OutputKeys.ENCODING, "gb2312");  
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");  
        serializer.setOutputProperty(OutputKeys.METHOD, "html");  
        serializer.transform(domSource, streamResult);  
        outStream.close();  
  
        String content = new String(outStream.toByteArray());  
  
//        FileUtils.write(new File(path, outFileName), content, "gb2312");
    }  
    /** 
     *  
     * @param path 所在的文件夹 
     * @param inFileName 输入Excel文档 
     * @param outFileName 输出Html文档 
     * @throws Throwable 
     */  
    @SuppressWarnings("rawtypes")  
    public static String  excelToHtml(String path,String inFileName) throws Throwable {  
          
        InputStream input = new FileInputStream(path +"/"+ inFileName);  
        HSSFWorkbook excelBook = new HSSFWorkbook(input);  
        ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());  
          
        //去掉Excel头行  
        excelToHtmlConverter.setOutputColumnHeaders(false);  
        //去掉Excel行号  
        excelToHtmlConverter.setOutputRowNumbers(false);  
          
        excelToHtmlConverter.processWorkbook(excelBook);  
        List pics = excelBook.getAllPictures();  
        if (pics != null) {  
            for (int i = 0; i < pics.size(); i++) {  
                Picture pic = (Picture) pics.get(i);  
                try {  
                    pic.writeImageContent(new FileOutputStream(path  
                            + pic.suggestFullFileName()));  
                } catch (FileNotFoundException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
          
        Document htmlDocument = excelToHtmlConverter.getDocument();  
  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        DOMSource domSource = new DOMSource(htmlDocument);  
        StreamResult streamResult = new StreamResult(outStream);  
        TransformerFactory tf = TransformerFactory.newInstance();  
        Transformer serializer = tf.newTransformer();  
        serializer.setOutputProperty(OutputKeys.ENCODING, "gb2312");  
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");  
        serializer.setOutputProperty(OutputKeys.METHOD, "html");  
        //excelToHtmlConverter.OutputColumnHeaders = false;  
        serializer.transform(domSource, streamResult);  
        outStream.close();  
  
        String content = new String(outStream.toByteArray());  
        //去掉Excel中的列A B C D  
        //content = StringUtil.regexReplaceStr(content,"<thead>[^<]*[^d]*[^i]*[^v]*[^>]*</thead>", "");  
        //去掉Excel中的行1 2 3  
        //content = StringUtil.regexReplaceStr(content,"<th class=\"rownumber\">.*?</th>","<th class=\"rownumber\"></th>");  
        return content;  
        //FileUtils.write(new File(path, outFileName), content, "gb2312");  
    }  
}  