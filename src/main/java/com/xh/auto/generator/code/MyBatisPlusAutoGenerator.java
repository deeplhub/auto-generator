package com.xh.auto.generator.code;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.xh.auto.generator.properties.MybatisPlusGeneratorProperties;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Title: MyBatisPlus代码生成器
 * Description:
 *
 * @author H.Yang
 * @date 2021/7/31
 */
@Slf4j
public class MyBatisPlusAutoGenerator {
    // 代码生成器
    private static AutoGenerator mpg = new AutoGenerator();

    /**
     * 自动生成代码
     *
     * @param properties 配置对象
     * @return
     */
    public static String autoCodeGenerator(MybatisPlusGeneratorProperties properties) {
        try {
            MyBatisPlusAutoGenerator generator = new MyBatisPlusAutoGenerator();
            // 全局配置
            mpg.setGlobalConfig(generator.globalConfig(properties.getGlobalConfig()));
            // 数据源配置
            mpg.setDataSource(properties.getDatasource());
            // 包配置
            mpg.setPackageInfo(properties.getPackageConfig());
            // 策略配置
            mpg.setStrategy(properties.getStrategyConfig());
            mpg.execute();

            return "SUCCESS";
        } catch (Exception e) {
            log.error("自动生成代码失败", e);
            return "ERROR";
        }
    }

    /**
     * 自动生成代码
     *
     * @param properties 配置对象
     * @param tableName  表名称
     * @return
     */
    public static String autoCodeGenerator(MybatisPlusGeneratorProperties properties, String tableName) {
        try {
            MyBatisPlusAutoGenerator generator = new MyBatisPlusAutoGenerator();
            // 全局配置
            mpg.setGlobalConfig(generator.globalConfig(properties.getGlobalConfig()));
            // 数据源配置
            mpg.setDataSource(properties.getDatasource());
            // 包配置
            mpg.setPackageInfo(properties.getPackageConfig());

            Set<String> tableNames = new HashSet<>();
            tableNames.add(tableName);
            // 策略配置
            mpg.setStrategy(generator.strategyConfig(properties.getStrategyConfig(), tableNames));
            mpg.execute();

            return "SUCCESS";
        } catch (Exception e) {
            log.error("自动生成代码失败", e);
            return "ERROR";
        }
    }

    /**
     * 自动生成代码
     *
     * @param properties 配置对象
     * @param tableNames 表名称
     * @return
     */
    public static String autoCodeGenerator(MybatisPlusGeneratorProperties properties, Set<String> tableNames) {
        try {
            MyBatisPlusAutoGenerator generator = new MyBatisPlusAutoGenerator();
            // 全局配置
            mpg.setGlobalConfig(generator.globalConfig(properties.getGlobalConfig()));
            // 数据源配置
            mpg.setDataSource(properties.getDatasource());
            // 包配置
            mpg.setPackageInfo(properties.getPackageConfig());
            // 策略配置
            mpg.setStrategy(generator.strategyConfig(properties.getStrategyConfig(), tableNames));
            mpg.execute();

            return "SUCCESS";
        } catch (Exception e) {
            log.error("自动生成代码失败", e);
            return "ERROR";
        }
    }

    private GlobalConfig globalConfig(GlobalConfig globalConfig) {

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        globalConfig.setEntityName("%s" + globalConfig.getEntityName());//实体命名方式  默认值：null 例如：%sEntity 生成 UserEntity
        globalConfig.setMapperName("%s" + globalConfig.getMapperName());//mapper 命名方式 默认值：null 例如：%sDao 生成 UserDao
        globalConfig.setXmlName("%s" + globalConfig.getXmlName());//Mapper xml 命名方式   默认值：null 例如：%sDao 生成 UserDao.xml
        globalConfig.setServiceName("%s" + globalConfig.getServiceName());//service 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
        globalConfig.setServiceImplName("%s" + globalConfig.getServiceImplName());//service impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        globalConfig.setControllerName("%s" + globalConfig.getControllerName());//controller 命名方式默认值：null 例如：%sAction 生成 UserAction

        return globalConfig;
    }

    private StrategyConfig strategyConfig(StrategyConfig strategyConfig, Set<String> tableNames) {

        String[] array = tableNames.toArray(new String[tableNames.size()]);
        strategyConfig.setInclude(array);

        return strategyConfig;
    }


    /**
     * 获取当前数据库中所有表
     *
     * @param datasource 数据源配置
     * @return
     */
    public static Set<String> listTableName(DataSourceConfig datasource) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet results = null;
        Set<String> set = new HashSet<>();
        try {
            String sql = StrUtil.format("SELECT table_name, table_comment FROM information_schema.tables WHERE table_schema='{}' AND table_type='base table'", datasource.getSchemaName());
            conn = datasource.getConn();
            preparedStatement = conn.prepareStatement(sql);
            results = preparedStatement.executeQuery();
            while (results.next()) {
                String tableName = results.getString("table_name");
                set.add(tableName);
            }
        } catch (SQLException e) {
            log.error("", e);
        } finally {
            closeObj(conn);
            closeObj(preparedStatement);
            closeObj(results);
        }
        return set;
    }

    private static void closeObj(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Connection) {
                ((Connection) obj).close();
            }
            if (obj instanceof PreparedStatement) {
                ((PreparedStatement) obj).close();
            }
            if (obj instanceof ResultSet) {
                ((ResultSet) obj).close();
            }
        } catch (SQLException e) {
            log.error("", e);
        }
    }
}
