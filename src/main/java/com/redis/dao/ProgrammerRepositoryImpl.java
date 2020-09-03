package com.redis.dao;

import com.redis.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

    private static final String REDIS_LIST_KEY = "ProgrammersList";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //******STRING***********
    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        redisTemplate.opsForValue().set(idKey, programmer);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return (String) redisTemplate.opsForValue().get(idKey);
    }
    //******STRING***********

    //******LIST***********
    @Override
    public void addProgrammersToList(Programmer programmer) {
       redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, programmer);
    }

//    @Override
//    public Collection<Programmer> getProgrammersListMembers() {
//        List<Object> result = redisTemplate.opsForList().range(REDIS_LIST_KEY, 0, -1);
//
//        if (result == null || result.size() == 0) {
//            return Collections.emptySet();
//        }
//        List<Programmer> programmers = new ArrayList<>(result.size());
//        for (Iterator<Object> it = result.iterator(); it.hasNext(); ) {
//            Programmer programmer = (Programmer) it.next();
//            programmers.add(programmer);
//        }
//        return Collections.unmodifiableCollection(programmers);
//    }

    @Override
    public Collection<Programmer> getProgrammersListMembers() {
       return redisTemplate.opsForList().range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getProgrammersListCount() {
        return redisTemplate.opsForList().size(REDIS_LIST_KEY);
    }
    //******LIST***********
}
