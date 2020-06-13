package cn.itheima.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisSpringTest {
    
    private ApplicationContext applicationContext;
    
    @Before
    public void setUp() throws Exception {
        String configLocation = "classpath:ApplicationContext.xml";
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
    }
    @Test
    public void testJedisSpring() throws Exception {
        JedisPool jedisPool = (JedisPool) applicationContext.getBean("jedisPool");
        
        Jedis jedis = jedisPool.getResource();
        //存
        jedis.set("key4", "bbb");
        //取
        System.out.println(jedis.get("key4"));
    }
}
