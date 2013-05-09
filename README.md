jedis-ui
========
  Jedis-ui is a search key tool for redis,It's easy to use.
  You just need to search a key using pattern.
  Please let me know if you have any question.
  my email:jettylee@live.cn
  
Install application:
1.download jedis-ui project.
2.modify spring.xml file.
  update host-name to your own ip addr and choose a database.
  <bean id="redisConnectionFactory"
  	class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory" destroy-method="destroy"
		p:host-name="127.0.0.1" p:port="6379" p:poolConfig-ref="jedisPoolConfig" p:database="0" />
  
