package com.xh.auto.generator.properties;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2021/7/31
 */
@Data
@Component
@ConfigurationProperties(prefix = "mybatis-plus")
public class MybatisPlusGeneratorProperties {

    private DataSourceConfig datasource = new DataSourceConfig();

    private GlobalConfig globalConfig = new GlobalConfig();

    private PackageConfig packageConfig = new PackageConfig();

    private StrategyConfig strategyConfig = new StrategyConfig();

    private ScrewConfig screwConfig = new ScrewConfig();
}
