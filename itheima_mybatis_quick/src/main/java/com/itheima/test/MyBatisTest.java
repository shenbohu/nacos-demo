package com.itheima.test;


import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    public SqlSession sqlSession() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建核心构造器  创建SqlSessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得 session 回话对象
        SqlSession sqlSession = build.openSession();
        return sqlSession;

    }

    @Test
    public void test1() throws IOException {
       // List<User> user = sqlSession().selectList("userMapper.findAll");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession();
        List<User> user = sqlSession.selectList("userMapper.findAll");
        System.out.println(user);
        sqlSession().close();

    }

    @Test
    public void test2() throws IOException {
//        //获取核心配置对象
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        // 创建核心构造器
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        // 创建
//        SqlSessionFactory build = builder.build(resourceAsStream);
//        SqlSession sqlSession = build.openSession();
        // 模拟 user 对象
        // MyBatis 事务默认不提交  更新需要提交事务
       User user = new User();
        user.setUsername("liu");
        user.setPassword("saaaa");
        System.out.println(user);

        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession(true);
        sqlSession.insert("userMapper.save",user);
       // sqlSession.commit();
        sqlSession.close();

    }

       @Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("wangzuxian");
        user.setPassword("12");
        System.out.println(user);
        // 获取核心配置
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建核心构造器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建session 工厂
        SqlSessionFactory build = builder.build(resourceAsStream);
        // 获取SqlSession 回话对象
        SqlSession sqlSession = build.openSession();

        sqlSession.update("userMapper.update",user);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test4() throws IOException {
     // 获取核心配置
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建核心构造器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建 session 工厂
        SqlSessionFactory build = builder.build(resourceAsStream);
        // 创建session 会话对象
        SqlSession sqlSession = build.openSession(true); // 设置true可以自动提交
        sqlSession.delete("userMapper.delete",0);
       // sqlSession.commit();
        sqlSession.close();

    }
        @Test
    public void test5() throws IOException {
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession();
            User s = sqlSession.selectOne("userMapper.findAllByid", 1);
            System.out.println(s);
            sqlSession.close();

        }
}


