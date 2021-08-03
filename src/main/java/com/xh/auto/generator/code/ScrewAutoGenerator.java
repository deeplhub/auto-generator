package com.xh.auto.generator.code;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.xh.auto.generator.properties.MybatisPlusGeneratorProperties;
import com.xh.auto.generator.properties.ScrewConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * Title: 数据库设计文档生成工具类
 * Description:
 *
 * @author H.Yang
 * @date 2021/8/2
 */
@Slf4j
public class ScrewAutoGenerator {

    public static String autoScrewGeneratorScrew(MybatisPlusGeneratorProperties properties) {
        try {
            ScrewConfig screwConfig = properties.getScrewConfig();
            // 创建 screw 的配置
            Configuration config = Configuration.builder()
                    .version(screwConfig.getVersion())  // 版本
                    .description(screwConfig.getDescription()) // 描述
                    .dataSource(buildDataSource(properties.getDatasource())) // 数据源
                    .engineConfig(buildEngineConfig(screwConfig)) // 引擎配置
                    .produceConfig(buildProcessConfig()) // 处理配置
                    .build();

            // 执行 screw，生成数据库文档
            new DocumentationExecute(config).execute();

            return "SUCCESS";
        } catch (Exception e) {
            log.error("自动生成文档失败", e);
            return "ERROR";
        }
    }

    /**
     * 生成文件配置
     */
    private static EngineConfig buildEngineConfig(ScrewConfig screwConfig) {
        // 生成文件配置
        EngineConfig engineConfig = EngineConfig.builder()
                // 生成文件路径，自己mac本地的地址，这里需要自己更换下路径
                .fileOutputDir(screwConfig.getFileOutputDir())
                // 打开目录
                .openOutputDir(screwConfig.getOpen())
                // 文件类型
                .fileType(screwConfig.getFileType())
                // 生成模板实现
                .produceType(screwConfig.getProduceType())
                .fileName(screwConfig.getFileName()) // 自定义文件名称
                .build();

        return engineConfig;
    }

    /**
     * 创建数据源
     */
    private static DataSource buildDataSource(DataSourceConfig datasource) {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setDriverClassName(datasource.getDriverName());
        hikariDataSource.setJdbcUrl(datasource.getUrl());
        hikariDataSource.setUsername(datasource.getUsername());
        hikariDataSource.setPassword(datasource.getPassword());

        // 创建数据源
        return new HikariDataSource(hikariDataSource);
    }

    /**
     * 创建 screw 的处理配置，一般可忽略
     * 指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
     */
    private static ProcessConfig buildProcessConfig() {
        return ProcessConfig.builder()
                .designatedTableName(Collections.<String>emptyList())  // 根据名称指定表生成
                .designatedTablePrefix(Collections.<String>emptyList()) //根据表前缀生成
                .designatedTableSuffix(Collections.<String>emptyList()) // 根据表后缀生成
//                .ignoreTableName(Arrays.asList("test_user", "test_group")) // 忽略表名
//                .ignoreTablePrefix(Collections.singletonList("test_")) // 忽略表前缀
//                .ignoreTableSuffix(Collections.singletonList("_test")) // 忽略表后缀
                .build();
    }
}
