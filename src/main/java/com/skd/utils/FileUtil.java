/**  
 * @Title: FileUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月4日
 */
package com.skd.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ClassName: FileUtil
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月4日
 */
public class FileUtil {
	//生成文件路径
    private static String path = "D:\\";
    
    //文件路径+名称
    private static String filenameTemp;
	
	/**  
     * 文件转化为字节数组  
     *   
     * @param file  
     * @return  
     */    
    public static byte[] getBytesFromFile(File file) {    
        byte[] ret = null;    
        try {    
            if (file == null) {    
                // log.error("helper:the file is null!");    
                return null;    
            }    
            FileInputStream in = new FileInputStream(file);    
            ByteArrayOutputStream out = new ByteArrayOutputStream(4096);    
            byte[] b = new byte[4096];    
            int n;    
            while ((n = in.read(b)) != -1) {    
                out.write(b, 0, n);    
            }    
            in.close();    
            out.close();    
            ret = out.toByteArray();    
        } catch (IOException e) {    
            // log.error("helper:get bytes from file process error!");    
            e.printStackTrace();    
        }    
        return ret;    
    }    
    /**  
     * 把字节数组保存为一个文件  
     *   
     * @param b  
     * @param outputFile  
     * @return  
     */    
    public static File getFileFromBytes(byte[] b, String outputFile) {    
        File ret = null;    
        BufferedOutputStream stream = null;    
        try {    
            ret = new File(outputFile);    
            FileOutputStream fstream = new FileOutputStream(ret);    
            stream = new BufferedOutputStream(fstream);    
            stream.write(b);    
        } catch (Exception e) {    
            // log.error("helper:get file from byte process error!");    
            e.printStackTrace();    
        } finally {    
            if (stream != null) {    
                try {    
                    stream.close();    
                } catch (IOException e) {    
                    // log.error("helper:get file from byte process error!");    
                    e.printStackTrace();    
                }    
            }    
        }    
        return ret;    
    }  
  
    /**
     * 创建文件
     * @param fileName  文件名称
     * @param filecontent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static boolean createFile(String fileName,String filecontent){
        Boolean bool = false;
        filenameTemp = path+fileName+".bat";//文件路径+名称+文件类型
        File file = new File(filenameTemp);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
                bool = true;
                System.out.println("success create file,the file is "+filenameTemp);
                //创建文件成功后，写入内容到文件里
                writeFileContent(filenameTemp, filecontent,true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bool;
    }
    
    /**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath,String newstr,boolean append) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";
        
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            
            //文件原有内容
            if(append){
            	for(int i =0;(temp =br.readLine())!=null;i++){
            		buffer.append(temp);
            		// 行与行之间的分隔符 相当于“\n”
            		buffer = buffer.append(System.getProperty("line.separator"));
            	}
            }
            buffer.append(filein);
            
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }
    
    /**
     * 删除文件
     * @param fileName 文件名称
     * @return
     */
    public static boolean delFile(String fileName){
        Boolean bool = false;
        filenameTemp = path+fileName+".txt";
        File file  = new File(filenameTemp);
        try {
            if(file.exists()){
                file.delete();
                bool = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return bool;
    }

}
