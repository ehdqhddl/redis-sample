package com.example.redis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@AllArgsConstructor
@RestController
public class RedisController {
    private RedisService redisService;
    RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/redis")
    public List<RedisView> getInformation(){
        return redisService.getInformation();
    }
}
