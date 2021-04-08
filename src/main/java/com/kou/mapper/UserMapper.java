package com.kou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kou.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author JIAJUN KOU
 *
 * 可以这样说，到这一步的时候，所有的CRUD就算是编写完成了，因为只需要用对象调用方法即可。
 *
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
