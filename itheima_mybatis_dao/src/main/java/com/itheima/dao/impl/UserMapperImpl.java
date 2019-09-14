//package com.itheima.dao.impl;
//
//import com.itheima.dao.UserMapper;
//import com.itheima.domain.User;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.util.List;
//
//public class UserMapperImpl  {
//
//    public List<User> findAll() throws Exception {
//        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession();
//        List<User> userList = sqlSession.selectList("userMapper.findAll");
//        return userList;
//    }
//}
