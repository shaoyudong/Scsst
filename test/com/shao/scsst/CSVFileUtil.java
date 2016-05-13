package com.shao.scsst;

import java.io.BufferedReader;  
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;  
import java.util.ArrayList;  
  
public class CSVFileUtil {  
    // CSV文件编码  
    public static final String ENCODE = "UTF-8";  
  
    private FileInputStream fis = null;  
    private InputStreamReader isw = null;  
    private BufferedReader br = null;  
  
     
    public CSVFileUtil(String filename) throws Exception {  
        fis = new FileInputStream(filename);  
        isw = new InputStreamReader(fis, ENCODE);  
        br = new BufferedReader(isw);
    }  
  
    // ==========以下是公开方法=============================  
    /** 
     * 从CSV文件流中读取一个CSV行。 
     * 
     * @throws Exception 
     */  
    public String readLine() throws Exception {  
  
        StringBuffer readLine = new StringBuffer();  
        boolean bReadNext = true;  
  
        while (bReadNext) {  
            //  
            if (readLine.length() > 0) {  
                readLine.append("\r\n");  
            }  
            // 一行  
            String strReadLine = br.readLine();  
  
            // readLine is Null  
            if (strReadLine == null) {  
                return null;  
            }  
            readLine.append(strReadLine);  
  
            // 如果双引号是奇数的时候继续读取。考虑有换行的是情况。  
            if (countChar(readLine.toString(), '"', 0) % 2 == 1) {  
                bReadNext = true;  
            } else {  
                bReadNext = false;  
            }  
        }  
        
        return readLine.toString();  
    }  
    
    /**
     * 关闭文件流
     */
  
    public void close() throws IOException{
    	br.close();
        isw.close();
        fis.close();
    }
    
    
  
    // ==========以下是内部使用的方法=============================  
     
    private int countChar(String str, char c, int start) {  
        int i = 0;  
        int index = str.indexOf(c, start);  
        return index == -1 ? i : countChar(str, c, index + 1) + 1;  
    }  
  
}  