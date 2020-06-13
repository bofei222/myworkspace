package log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
* @author 作者 bofei
* @version 创建时间：2017年7月25日 上午11:33:32 
* 类说明 
*/
public class Program {
    public static void main(String[] args) {
        // 类名.class
        Logger logger = LoggerFactory.getLogger(Program.class);
        // 输出字符串
        logger.debug("this is a debug msg");
        // 占位符
        logger.debug("hi，welcome {}，today is {}","admin","Sunday");
    }
}
