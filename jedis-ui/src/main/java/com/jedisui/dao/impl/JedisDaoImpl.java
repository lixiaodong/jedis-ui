package com.jedisui.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

import com.jedisui.dao.JedisDao;
import com.jedisui.support.RedisBaseSupport;

@Repository
public class JedisDaoImpl extends RedisBaseSupport<String, String> implements
		JedisDao {
	public Set<String> searchKeys(String pattern) {
		return getValueOperations().getOperations().keys(pattern);
	}

	public Set<String> keys(String pattern) {
		return getValueOperations().getOperations().keys(pattern);
	}

	/**
	 * get hash ,set ,list,string
	 */
	public String get(String key) {
		try {
			return getValueOperations().get(key);
		} catch (InvalidDataAccessApiUsageException e) {
			try {
				Map<Object, Object> maps = getHashOperations().entries(key);
				String value = "key=" + key;
				value += "\n[\n";
				for (Object k : maps.keySet().toArray()) {
					value += k + "=" + getHashOperations().get(key, k);
					value += ",\n";
				}
				value += "\n]";
				return value;
			} catch (InvalidDataAccessApiUsageException ex) {
				try {
					Set<String> members = getSetOperations().members(key);
					String value = "\n[\n";
					for (String member : members) {
						value += member + ",\n";
					}
					value += "]";
					return value;
				} catch (InvalidDataAccessApiUsageException e2) {
					String value = "\n[\n";
					List<String> values = getListOperations().range(key, 0, -1);
					for (String string : values) {
						value += string + ",\n";
					}
					value += "]";
					return value;
				}
			}
		}
	}

	public long ttl(String key) {
		return getValueOperations().getOperations().getExpire(key);
	}

}
