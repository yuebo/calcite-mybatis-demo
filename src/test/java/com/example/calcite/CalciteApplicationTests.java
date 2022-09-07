package com.example.calcite;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class CalciteApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() throws Exception {
        Integer count = userMapper.findList().size();
        log.info("{}",count);
    }

}
