package com.kou.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author JIAJUN KOU
 * 自定义实现处理 时间自动填充 处理器
 */

//丢到IOC容器里面
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始填充--------->");
        //设置字段值（第一个参数：字段名）
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新操作------>");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
