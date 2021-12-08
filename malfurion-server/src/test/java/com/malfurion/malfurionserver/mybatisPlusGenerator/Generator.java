package com.malfurion.malfurionserver.mybatisPlusGenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;


//代码自动生成器
public class Generator {

    public static void main(String[] args) {

        //代码生成器
        AutoGenerator mpg = new AutoGenerator();


        //配置策略

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");///Users/octane/Projects/Malfurion/Malfurion-Server

        gc.setOutputDir(projectPath + "/src/main/java");

        gc.setAuthor("octane");
        gc.setOpen(false);
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService");//正则匹配去掉Service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/malfurion?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimeZone=Asia/Shanghai&useSSL=false");
        dsc.setUsername("root");
        dsc.setPassword("1234ever.A");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //配置要生成的包
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.malfurion.malfurionserver.system");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //策略配置
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.malfurion.malfurionserver.common.core.domain.entity.SuperEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setLogicDeleteFieldName("deleted");
        // 公共父类
        strategy.setSuperControllerClass("com.malfurion.malfurionserver.common.core.controller.SuperController");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("create_by", "create_time", "update_by", "update_time");
        strategy.setInclude("user,tag,category,article_info,article_content,article_comment,article_mark".split(","));

        //自动填充策略
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);

        //乐观锁
        strategy.setLogicDeleteFieldName("version");
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute();//执行

    }
}
