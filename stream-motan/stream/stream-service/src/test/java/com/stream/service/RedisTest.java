package com.stream.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends AbstractConfigTest{
	
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void testName() throws Exception {
		String key = "name";
		String value = "name01";
		redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keyb = key.getBytes();
                byte[] valueb = value.getBytes();
                // 判断当前值是否已经存在
                if (connection.exists(keyb)) {
                    // 删除原数据
                    connection.del(keyb);
                }
                connection.set(keyb, valueb);
                return 1L;
            }
        });
	}
	
}
