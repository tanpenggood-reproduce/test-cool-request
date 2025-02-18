package com.example.demo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Types;
import java.util.Collections;


@Slf4j
@SpringBootTest(classes = {Application.class})
public class MpGenerator {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Test
    public void generateCode() throws Exception {
        log.info("start.");
        generate("t_user");
        generate("t_role");
        log.info("done.");
    }

    void generate(String tableNames) {
        FastAutoGenerator.create(url, userName, password)
                .globalConfig(builder -> {
                    builder.author("tanpenggood").enableSpringdoc().disableOpenDir().outputDir("src/main/java");
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);
                }))
                .packageConfig(builder -> {
                    builder.parent("com.example.demo")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> builder
                        .addInclude(tableNames)
                        .addTablePrefix("t")
                        .entityBuilder().disableSerialVersionUID().enableChainModel().enableLombok().idType(IdType.ASSIGN_ID)
                        .controllerBuilder().enableRestStyle()
                        .serviceBuilder().superServiceClass(IService.class).superServiceImplClass(ServiceImpl.class)
                        .mapperBuilder().superClass(BaseMapper.class).mapperAnnotation(Mapper.class).disableMapperXml())
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
