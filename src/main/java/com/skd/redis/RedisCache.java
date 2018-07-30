/**  
 * @Title: RedisCache.java
 * @Package com.skd.redis
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月26日
 */
package com.skd.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * ClassName: RedisCache
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月26日
 */

public class RedisCache implements Cache {
	
	private RedisTemplate<String, Object> redisTemplate;
	private String name;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public Object getNativeCache() {
		// TODO Auto-generated method stub
		return this.redisTemplate;
	}

	public ValueWrapper get(Object key) {
		// TODO Auto-generated method stub
		System.out.println("get key：" + key.toString());
		final String keyf = key.toString();
		Object object = null;
		object = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] key = keyf.getBytes();
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				return toObject(value);
			}
		});
		return (object != null ? new SimpleValueWrapper(object) : null);
	}

	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		System.out.println("put key:"+ key.toString());
		final String keyf = key.toString();
		final Object valuef = value;
		final long liveTime = 86400;
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = keyf.getBytes();
				byte[] valueb = toByteArray(valuef);
				connection.set(keyb, valueb);
				if (liveTime > 0) {
					connection.expire(keyb, liveTime);
				}
				return 1L;
			}
		});
	}

	private byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bytes;
	}

	private Object toObject(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			ois.close();
			bis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

	public void evict(Object key) {
		// TODO Auto-generated method stub
		System.out.println("del key");
		final String keyf = key.toString();
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.del(keyf.getBytes());
			}
		});
	}

	public void clear() {
		// TODO Auto-generated method stub
		System.out.println("clear key");
		redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

	public <T> T get(Object key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ValueWrapper putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.cache.Cache#getId()
	 */
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.cache.Cache#getObject(java.lang.Object)
	 */
	public Object getObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.cache.Cache#getReadWriteLock()
	 */
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.cache.Cache#getSize()
	 */
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.cache.Cache#putObject(java.lang.Object, java.lang.Object)
	 */
	public void putObject(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.cache.Cache#removeObject(java.lang.Object)
	 */
	public Object removeObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
