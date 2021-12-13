package com.malfurion.malfurionserver.common.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.malfurion.malfurionserver.common.utils.SecurityUtils;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        String username = null;
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("deleted",0, metaObject);
        this.setFieldValByName("version", 0, metaObject);
        try {
            username = SecurityUtils.getUsername();
        } catch (Exception e) {
            e.printStackTrace();
            username = "sys";
        } finally {
            this.setFieldValByName("createBy", username, metaObject);
            this.setFieldValByName("updateBy", username, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        String username = null;
        try {
            username = SecurityUtils.getUsername();
        } catch (Exception e) {
            e.printStackTrace();
            username = "sys";
        } finally {
            this.setFieldValByName("updateBy", username, metaObject);
        }
    }
}
