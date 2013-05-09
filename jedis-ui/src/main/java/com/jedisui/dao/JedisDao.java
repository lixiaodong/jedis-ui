package com.jedisui.dao;

import java.util.Set;



public interface JedisDao {
	public Set<String> searchKeys(String pattern);
	
	public String get(String key);
	
	public Set<String> keys(String pattern);
	
	public long ttl(String key);
	
}
