package com.kou;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kou.mapper.UserMapper;
import com.kou.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author JIAJUN KOU
 *
 * mybatis-plus的条件构造器测试类
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询name不为空的用户，并且邮箱不为空，年龄大于等于20
     */
    @Test
    void contextLoads(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",20);//ge就是大于等于
        userMapper.selectList(wrapper).forEach(System.out::println);
    }


    /**
     * 查询name=Tom的用户
     */
    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Tom");
        System.out.println(userMapper.selectOne(wrapper));
    }

    /**
     * 查询between and 查询20到30岁之间的用户
     */
    @Test
    void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        System.out.println(userMapper.selectCount(wrapper));
    }


    /**
     * 模糊查询
     */
    @Test
    void test4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name","e")//不包含名字中有e的
                .likeRight("name","J");//J开头的用户
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     * 内查询
     */
    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id 在子查询中查询出来的
        //有一种拼接sql的感觉
        wrapper.inSql("id",
                "select id from user where id<3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    /**
     * 通过updateTime降序排序
     */
    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //注意这个排序字段要是数据库中的字段，不是实体类中的
        wrapper.orderByDesc("update_time");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
