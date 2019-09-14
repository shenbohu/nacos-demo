package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 查找条件
        User user = new User();
        user.setId(1);
       // user.setUsername("wangzuxian");
       // user.setPassword("12");
        List<User> byCondition = mapper.findByCondition(user);
        System.out.println(byCondition);
        sqlSession.close();
    }
    @Test
    public void text2() throws Exception{
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> byIds = mapper.findByIds(list);
        System.out.println(byIds);

    }


    @Test
    public void text3() throws Exception{
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> findselect = mapper.findselect("%z%");
        System.out.println(findselect);
        sqlSession.close();


    }

}
