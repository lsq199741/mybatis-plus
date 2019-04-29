package org.luo.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

public class MyGenerator {
    public static void main(String[] args) {

        // 生成文件输出路径
        String outputDir = "/Users/luoshuqiang/Desktop/springboot/mybatis-plus";
        // 作者
        String authorName = "shuqiang";
        // 包名全路径
        String packageNameAllPath = "org.luo";
        // 模块名
        String moduleName = "mybatisplus";
        // 接口是否以I开头
        boolean serviceNameStartWithI = false;
        // 对应表
        String[] tableName = {"sys_user","sys_user_role","sys_role","sys_role_permission","sys_permission"};

        String dbUrl = "jdbc:mysql://localhost:3306/springboot?useSSL=false&useUnicode=true&characterEncoding=UTF8&allowPublicKeyRetrieval=true&serverTimezone=GMT";
        String dbUserName = "root";
        String dbPassword = "Lsq123!@#";
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        DbType dbType = DbType.MYSQL;


        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageNameAllPath)
                .setModuleName(moduleName)
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setXml("mapper.xml")
                .setEntity("model.entity");

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(dbType)
                .setDriverName(dbDriver)
                .setUrl(dbUrl)
                .setUsername(dbUserName)
                .setPassword(dbPassword);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) // 是否大写命名
                .setRestControllerStyle(true) // 生成 @RestController 控制器
                .setEntityLombokModel(true) // 是否为lombok模型
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel) // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
                .setControllerMappingHyphenStyle(true) // 驼峰转连字符
                .setInclude(tableName); // 需要包含的表名


        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setAuthor(authorName)
                .setOutputDir(outputDir)
                .setIdType(IdType.AUTO)
                .setFileOverride(true)
                .setOpen(false);
        if (!serviceNameStartWithI) {
            globalConfig.setServiceName("%sService");
        }



        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new VelocityTemplateEngine());


        autoGenerator.execute();
    }
}
