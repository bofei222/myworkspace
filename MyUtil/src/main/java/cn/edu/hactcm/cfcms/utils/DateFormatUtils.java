package cn.edu.hactcm.cfcms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CFMS ：Computer files management system version ：1.0 2013-2-20 下午12:30:23
 */
public final class DateFormatUtils {
    /**
     * @return 返回的日期格式类似：2012年12月10日 星期一<br/>
     *         <br/>
     *         <b>Letter Date or Time Component Presentation Examples</b> <br/>
     *         G Era designator Text AD <br/>
     *         y Year Year 1996; 96 <br/>
     *         M Month in year Month July; Jul; 07 <br/>
     *         w Week in year Number 27 <br/>
     *         W Week in month Number 2 <br/>
     *         D Day in year Number 189 <br/>
     *         d Day in month Number 10 <br/>
     *         F Day of week in month Number 2 <br/>
     *         E Day in week Text Tuesday; Tue <br/>
     *         a Am/pm marker Text PM <br/>
     *         H Hour in day (0-23) Number 0 <br/>
     *         k Hour in day (1-24) Number 24 <br/>
     *         K Hour in am/pm (0-11) Number 0 <br/>
     *         h Hour in am/pm (1-12) Number 12 <br/>
     *         m Minute in hour Number 30 <br/>
     *         s Second in minute Number 55 <br/>
     *         S Millisecond Number 978 <br/>
     *         z Time zone General time zone Pacific Standard Time; PST;
     *         GMT-08:00 <br/>
     *         Z Time zone RFC 822 time zone -0800 <br/>
     *         <br/>
     *         <b>Date and Time Pattern Result</b> <br/>
     *         "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD at 12:08:56 PDT
     *         <br/>
     *         "EEE, MMM d, ''yy" Wed, Jul 4, '01 <br/>
     *         "h:mm a" 12:08 PM <br/>
     *         "hh 'o''clock' a, zzzz" 12 o'clock PM, Pacific Daylight Time
     *         <br/>
     *         "K:mm a, z" 0:08 PM, PDT <br/>
     *         "yyyyy.MMMMM.dd GGG hh:mm aaa" 02001.July.04 AD 12:08 PM <br/>
     *         "EEE, d MMM yyyy HH:mm:ss Z" Wed, 4 Jul 2001 12:08:56 -0700 <br/>
     *         "yyMMddHHmmssZ" 010704120856-0700 <br/>
     *         "yyyy-MM-dd'T'HH:mm:ss.SSSZ" 2001-07-04T12:08:56.235-0700 <br/>
     *         <br/>
     */
    public String getDateFormatyyyyMMddE() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E");
        String formatyyyyMMddEE = simpleDateFormat.format(new Date());
        return formatyyyyMMddEE;
    }

    /**
     * @return 返回的日期格式类似：2012-12-10 13:44:03
     */
    public String getDateFormatyyyyMMddHHmmss() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatyyyyMMddHHmmss = simpleDateFormat.format(new Date());
        return formatyyyyMMddHHmmss;
    }

    /**
     * @return 返回的日期格式类似：2012-12-10 13:44:03
     */
    public Date getDateFormatyyyyMMddHHmmss2() {
        String formatyyyyMMddHHmmss = null;
        SimpleDateFormat simpleDateFormat = null;
        Date date = null;
        try {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatyyyyMMddHHmmss = simpleDateFormat.format(new Date());
            date = simpleDateFormat.parse(formatyyyyMMddHHmmss);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @return 返回的日期格式类似：2012年12月10日 13时50分50秒
     */
    public String getDateFormatOverrideyyyyMMddHHmmss() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return simpleDateFormat.format(new Date());
    }

    /**
     * @param date:这是要格式化的日期
     * @return 返回的日期格式类似：2012-12-10
     */
    public String getDateFormatyyyyMMdd(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * @param milliseconds:传入的毫秒值
     * @return 返回一个按照想要格式转换后的字符串。
     */
    public String getDateFormatyyyyMMddHHmmssFromMilliseconds(Long milliseconds) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = df.format(milliseconds);
        return dateTime;
    }

    /**
     * 如果字符串是否和条件的那么就返回毫秒值
     * 
     * @param timeString
     * @return
     */
    @SuppressWarnings("null")
    public long getMillisecondsByTimeString(String timeString) {
        if (timeString != null || timeString.trim() != null) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
            Date d = null;
            try {
                d = sf.parse(timeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return d.getTime();
        }
        return -1;
    }
}