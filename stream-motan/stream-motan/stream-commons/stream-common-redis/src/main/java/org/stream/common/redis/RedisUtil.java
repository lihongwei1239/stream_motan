package org.stream.common.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	
	/** Redis模板注入 */
    @Resource
    private RedisClusterConfiguration redisClusterConfiguration;
    private JedisConnectionFactory jedisConnectionFactory;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    //重构连接池
    private void init(){
        jedisConnectionFactory=new JedisConnectionFactory(redisClusterConfiguration);
        jedisConnectionFactory.afterPropertiesSet();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
    }

}
