package com.example.redis;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RedisService {
    private RedisTemplate redisTemplate;

    public List<RedisView> getInformation(){
        final String redisKey = "sample";

        List<RedisView> redisViewList = new ArrayList<>();
        ListOperations<String, RedisView> listOperations = redisTemplate.opsForList();

        if (listOperations.size(redisKey) != 0) {
            System.out.println("Redis 조회");
            return listOperations.range(redisKey,0,listOperations.size(redisKey));
        } else {
            System.out.println("디비 조회");

            RedisView redisView = new RedisView("박종진","seccc410",32);
            redisViewList.add(redisView);

            redisView = new RedisView("김주은","zjvmf19",32);
            redisViewList.add(redisView);

            listOperations.rightPushAll(redisKey,redisViewList);

            return null;
        }
    }
}
