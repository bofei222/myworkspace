package cn.itheima.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
    @Test
    public void testJedis1()  throws Exception{
        //
        Jedis jedis = new Jedis("192.168.100.128", 6379);
        
        jedis.set("key2", "2");
        
        System.out.println(jedis.get("key2"));
        
        jedis.close();
    }
    @Test
    public void testJedisPool() throws Exception {
        // 创建连接池
        JedisPool pool = new JedisPool("192.168.100.128", 6379);
        // 获取连接
        Jedis jedis = pool.getResource();
        // 存
        jedis.set("key3", "aaa");
        // 取
        System.out.println(jedis.get("key3"));
        // 关 关闭后连接会自动回到连接池供他人使用，若一直不关闭，连接被耗尽后死机
        jedis.close();
        // 关闭 连接池
        pool.close();
    }
}
