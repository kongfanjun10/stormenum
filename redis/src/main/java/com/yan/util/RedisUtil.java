package com.yan.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by yan on 2019/2/18.
 */
public class RedisUtil {

    //服务器ip地址
    private static String REDIS_HOST = "127.0.0.1";

    //Redis端口号
    private static int REDIS_PORT = 6379;

    //Redis密码
    //private static String redisAuth = "123456";

    //Redis实例最大连接数,默认值为 8,(-1代表无限制,如果破pool分配完MAX_ACTIVE实例 状态为exhausted)
    private static int REDIS_MAX_ACTIVE = 100;

    //一个pool中最多有多少idle(空闲)的实例,默认值 8
    private static int REDIS_MAX_IDLE = 8;

    //等待连接最大时间(毫秒),默认值 -1(用不超时),(超过MAX_WAIT抛出JedisConnectionException)
    private static int REDIS_MAX_WAIT = 10000;

    //连接超时时间,默认值 0 用不超时
    private static int REDIS_TIME_OUT = 0;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
    private static boolean REDIS_TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    /**
     * 初始化redis连接池配置
     */
    static{
        try {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(REDIS_MAX_IDLE);
            jedisPoolConfig.setMaxWaitMillis(REDIS_MAX_WAIT);
            jedisPoolConfig.setMaxTotal(REDIS_MAX_IDLE);
            jedisPoolConfig.setTestOnBorrow(REDIS_TEST_ON_BORROW);
            jedisPool = new JedisPool(jedisPoolConfig,REDIS_HOST,REDIS_PORT,REDIS_TIME_OUT);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取Redis实例
     */
    public static synchronized Jedis getJedis(){
        try {
            if (jedisPool != null)
            {
                Jedis resource = jedisPool.getResource();
                return resource;
            }
            else
            {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放Redis资源(关流)
     */
    public static void closeJedisResource(final Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }

    /**
     * 设置key过期时间
     */
    public static void expire(String key,int seconds){
        if(seconds <= 0){
            return;
        }
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key,seconds);
    }

}
