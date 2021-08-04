package com.xh.auto.generator.entrance;

import com.xh.auto.generator.code.ScrewAutoGenerator;
import com.xh.auto.generator.properties.MybatisPlusGeneratorProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2021/8/4
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScrewAutoGeneratorEntrance {

    @Resource
    private MybatisPlusGeneratorProperties mybatisPlusGeneratorProperties;

    @Test
    public void autoScrewGeneratorScrew() {
        String result = ScrewAutoGenerator.autoScrewGeneratorScrew(mybatisPlusGeneratorProperties);
        log.info(result);
    }
}
