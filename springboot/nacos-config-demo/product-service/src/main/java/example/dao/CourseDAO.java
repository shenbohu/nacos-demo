package example.dao;

import example.pojo.Course;
import org.springframework.stereotype.Repository;

/**
 * CourseDAO继承基类
 */
@Repository
public interface CourseDAO extends MyBatisBaseDao<Course, String> {
}