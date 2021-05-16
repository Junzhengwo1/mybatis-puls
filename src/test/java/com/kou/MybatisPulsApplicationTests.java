package com.kou;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kou.mapper.UserMapper;
import com.kou.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPulsApplicationTests {

    //这个mapper继承了父类，所以里面的方法全可用。这个是框架提供的
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //这里面有个参数 叫做条件构造器
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }

        Collections.swap(users,(users.size()-1),0);
        for (User user : users) {
            System.out.println(user);
        }


    }


    @Test
    void TestInsert(){
        User user = new User();
        user.setName("王");
        user.setAge(25);
        user.setEmail("abd@a.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);//返回的1 表示插入数据成功
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(5l);
        user.setName("天后3");
        user.setAge(21);
        //这个地方要记住，虽然叫做updateById但是参数传的是一个对象。
        int i = userMapper.updateById(user);
        System.out.println(i);//受影响的行数
    }



    @Test
    void testSelectFind(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(2, 3, 4));
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 条件查询 map
     */
    @Test
    void testSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","王");
        userMapper.selectByMap(map).forEach(System.out::println);
    }
    /**
     * 测试分页查询
     */
    @Test
    void testPageSelect(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        /*
        getRecords()获取查询的值
         */
        page.getRecords().forEach(System.out::println);
        long total = page.getTotal();
        long current = page.getCurrent();
        long size = page.getSize();
        System.out.println(total);
        System.out.println(current);
        System.out.println(size);
    }

    /**
     * 删除操作测试
     *
     * 根据id删除用户
     */
    @Test
    void testDelete(){
        int i = userMapper.deleteById(1379989085297045507l);
        System.out.println(i);
    }

    /**
     * 通过id批量删除
     */
    @Test
    void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(1379989085297045505l,1379989085297045506l));
    }

    /**
     * 通过 条件删除  即通过Map删除
     */
    @Test
    void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","王");
        userMapper.deleteByMap(map);
    }

    /**
     * 逻辑删除
     *
     * 虽然是执行的删除语句，本质是走的更新操作
     */
    @Test
    void testLOGJIDelete(){
        userMapper.deleteById(3l);
    }

}
