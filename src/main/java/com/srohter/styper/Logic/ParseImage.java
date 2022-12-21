package com.srohter.styper.Logic;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class ParseImage {
    private String datapath;
    public ParseImage(String pathtodata){
        this.datapath=pathtodata;
    }
    public char[] parse(){
        ITesseract tesseract = new Tesseract();
        System.setProperty("TESSDATA_PREFIX", datapath);
        tesseract.setDatapath(datapath);
        tesseract.setLanguage("eng");
        File imageFile = new File("src/main/resources/com/srohter/styper/text.png");
        try {
            String text = tesseract.doOCR(imageFile);
            return text.toCharArray();
        } catch (Exception e ) {  //TesseractException
            System.out.println("Null image entered: make sure that there is an image uploaded");
        }
        return null;
    }
}
