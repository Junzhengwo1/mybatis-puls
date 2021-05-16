package com.kou.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author JIAJUN KOU
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //这边自增id 需要数据库也要设置成自增
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //意思就是在插入的时候更新
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //在更新操作的时候更新
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //乐观锁需要配置的 version
    @Version
    private Integer version;

    //逻辑删除注解
    @TableLogic
    private Integer deleted;

}
