# redis-udemy
Lessons learned on Redis

# Things to Explore
1. What is connection pooling? How would you implement your own connection pool?
   Explore - https://commons.apache.org/proper/commons-pool/apidocs/org/apache/commons/pool2/impl/GenericObjectPool.html
2. Difference between Jedis, Lettuce and Redisson
3. RedisTemplate and various operations
4. Serializers that can be used while working with Redis database
5. Where should annotations be applied? Interface vs Impl's -> http://kim.saabye-pedersen.org/2013/05/spring-annotation-on-interface-or-class.html
6. Why is lettuce the default Java Client Library on Spring Data Redis? Pros/Cons?

# Exceptions encountered while working on this project
1. Bean creation exception -> NoClassDefFoundError -> java.lang.NoClassDefFoundError:redis/clients/jedis/JedisPoolConfig -> Resolved by excluding lettuce from spring-data-redis dependency and adding redis.clients -> jedis dependency