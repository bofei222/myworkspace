package com.bf.fileutil;
import java.sql.Timestamp;
/**
 * @author bofei
 * @date 2017年8月24日 下午5:35:07 
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    
    /** 
     * 获取精确到秒的时间戳 
     * @return 
     */  
    public static int getSecondTimestamp(Date date){  
        if (null == date) {  
            return 0;  
        }  
        String timestamp = String.valueOf(date.getTime());  
        int length = timestamp.length();  
        if (length > 3) {  
            return Integer.valueOf(timestamp.substring(0,length-3));  
        } else {  
            return 0;  
        }  
    } 
    
    /** 
     * 时间戳转换成日期格式字符串 
     * @param seconds 精确到秒的字符串 
     * @param formatStr 
     * @return 
     */  
    public static Timestamp timeStamp2Date(String seconds,String format) {  
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
            return null;  
        }  
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }   
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
//        return sdf.format(new Date(Long.valueOf(seconds+"000")));  
        return new Timestamp(Long.valueOf(seconds + "000"));
    }  
    /** 
     * 日期格式字符串转换成时间戳 
     * @param date 字符串日期 
     * @param format 如：yyyy-MM-dd HH:mm:ss 
     * @return 
     */  
    public static String date2TimeStamp(String date_str,String format){  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            return String.valueOf(sdf.parse(date_str).getTime()/1000);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
      
    /** 
     * 取得当前时间戳（精确到秒） 
     * @return 
     */  
    public static String timeStamp(){  
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);  
        return t;  
    }  

    public static void main(String[] args) {  
//        System.out.println(getSecondTimestamp(new Timestamp(System.currentTimeMillis())));
//        System.out.println(new Timestamp());
        
        String timeStamp = timeStamp();  
        System.out.println("timeStamp="+timeStamp); //运行输出:timeStamp=1470278082
        System.out.println(System.currentTimeMillis());//运行输出:1470278082980
        //该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数
        
       
        System.out.println(timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss"));//运行输出:date=2016-08-04 10:34:42
        
//        String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");  
//        System.out.println(timeStamp2);  //运行输出:1470278082
    }  
}