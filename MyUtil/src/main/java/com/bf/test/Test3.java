package com.bf.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bofei
 * @date 2017年8月24日 下午5:18:10 
 */
public class Test3 {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = sdf.format(timestamp);
        try {
            Date date = sdf.parse(string);
            System.out.println(date);
            System.out.println(new Timestamp(Long.valueOf(date.getTime())));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
