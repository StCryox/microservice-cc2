package io.swagger.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.concurrent.TimeUnit;

@Repository
public class PaymentRedisRepository implements RedisRepository {
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;

    @Override
    public void save(String idempotencyKey, String paymentStatus) {
        template.opsForValue().set(idempotencyKey, paymentStatus);
        template.expire(idempotencyKey,60, TimeUnit.MINUTES);
    }

    @Override
    public String findByKey(String idempotencyKey) {
       return (String) template.opsForValue().get(idempotencyKey);
    }

    @Override
    public boolean keyExist(String key) {
        return template.hasKey(key);
    }

    @Override
    public void remove(String key) {
        template.delete(key);
    }

}
