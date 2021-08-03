package com.xh.auto.generator.entrance;


import cn.hutool.json.JSONUtil;
import com.xh.auto.generator.code.MyBatisPlusAutoGenerator;
import com.xh.auto.generator.code.ScrewAutoGenerator;
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

    @Test
    public void autoCodeGenerator() {
        log.info(JSONUtil.toJsonStr(mybatisPlusGeneratorProperties));
        String result = MyBatisPlusAutoGenerator.autoCodeGenerator(mybatisPlusGeneratorProperties);
        log.info(result);
    }

    @Test
    public void autoCodeGeneratorAllTable() {
        log.info(JSONUtil.toJsonStr(mybatisPlusGeneratorProperties));
        Set<String> set = MyBatisPlusAutoGenerator.listTableName(mybatisPlusGeneratorProperties.getDatasource());
        String result = MyBatisPlusAutoGenerator.autoCodeGenerator(mybatisPlusGeneratorProperties, set);
        log.info(result);

    }

    @Test
    public void autoScrewGeneratorScrew() {
        String result = ScrewAutoGenerator.autoScrewGeneratorScrew(mybatisPlusGeneratorProperties);
        log.info(result);
    }

}
