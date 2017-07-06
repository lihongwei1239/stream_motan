package org.stream.common.redis;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends AbstractConfigTest{
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void testName() throws Exception {
		String key = "name";
		String value = "name01";
		if(redisTemplate.hasKey(key)){
			String result = redisTemplate.opsForValue().get(key).toString();
		}else{
			redisTemplate.opsForValue().set(key, value);
		}
	}
	
}
