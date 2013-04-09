/**
 * create by :lixiaodong
 * create time:2013-1-6
 */
package com.jedisui.support;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @author lixiaodong
 * @time 下午6:26:36
 * @date 2013-1-6
 */
public class RedisBaseSupport<K,V> {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<K, V> redisTemplate;
	
	private Class<?> entityClass;
	/**
	 * Get generic class
	 * @return Class<T>
	 */
	@SuppressWarnings("unchecked")
	protected Class<V> getEntityClass() {
		if (entityClass == null) {
			entityClass = (Class<V>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[1];
		}
		return (Class<V>) entityClass;
	}

	/**
	 * Operation for value
	 * @return
	 */
	public ValueOperations<String, String> getValueOperations(){
		return  stringRedisTemplate.opsForValue();
	}
	/**
	 * Operation for set
	 * @return
	 */
	public SetOperations<String, String> getSetOperations(){
		return  stringRedisTemplate.opsForSet();
	}
	/**
	 * Operation for list
	 * @return
	 */
	public ListOperations<String, String> getListOperations(){
		return stringRedisTemplate.opsForList();
	}
	
	/**
	 * Operation for hash
	 * @return
	 */
	public HashOperations<K,Object, Object> getHashOperations(){
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		return redisTemplate.opsForHash();
	}
	/**
	 * RedisTemplate
	 * @return RedisTemplate<K, V>
	 */
	public RedisTemplate<K, V> getRedisTemplate(){
		this.redisTemplate.setKeySerializer(new StringRedisSerializer());
		this.redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		return this.redisTemplate;
	}
	
	/**
	 * Save hash
	 * @param key
	 * @param object
	 */
	public void saveHashObject(K key, V object) {
		HashOperations<K, Object, Object> ops = getRedisTemplate().opsForHash();
		getRedisTemplate().setKeySerializer(new StringRedisSerializer());
		Field[] fields = object.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				ops.put(key, field.getName(),FieldUtils.readDeclaredField(object, field.getName(),true));
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get hash object
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public V getHashObject(K key){
		Object obj = null;
		try {
			obj = getEntityClass().newInstance();
			Field []fields = getEntityClass().getDeclaredFields();
			for (Field field : fields) {
				if(!"serialVersionUID".equals(field.getName())){
					Object value = getRedisTemplate().opsForHash().get(key, field.getName());
					if(value != null){
						FieldUtils.writeDeclaredField(obj, field.getName(), value,true);
					}
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return (V)obj;
	}
	
}
