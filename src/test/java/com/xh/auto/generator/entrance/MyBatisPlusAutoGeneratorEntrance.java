package com.xh.auto.generator.entrance;


import com.xh.auto.generator.code.MyBatisPlusAutoGenerator;
import com.xh.auto.generator.properties.MybatisPlusGeneratorProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2021/7/31
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisPlusAutoGeneratorEntrance {

    @Resource
    private MybatisPlusGeneratorProperties mybatisPlusGeneratorProperties;

    /**
     * 指定表生成
     */
    @Test
    public void autoCodeGenerator() {
        String result = MyBatisPlusAutoGenerator.autoCodeGenerator(mybatisPlusGeneratorProperties, "cloudlink_rates");
        log.info(result);
    }

    /**
     * 生成指定库的所有表
     */
    @Test
    public void autoCodeGeneratorAllTable() {
        Set<String> set = MyBatisPlusAutoGenerator.listTableName(mybatisPlusGeneratorProperties.getDatasource());
        String result = MyBatisPlusAutoGenerator.autoCodeGenerator(mybatisPlusGeneratorProperties, set);
        log.info(result);

    }


}
