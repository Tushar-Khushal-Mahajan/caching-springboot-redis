package com.cashe_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);

		// Use String Serializer for keys
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());

		// Use JSON Serializer for values
		template.setValueSerializer(new JdkSerializationRedisSerializer()); // because employee is Serializable entity
		template.setHashValueSerializer(new JdkSerializationRedisSerializer()); // otherwise we can use new
																				// GenericJackson2JsonRedisSerializer()

		template.afterPropertiesSet();
		return template;
	}
}
