package com.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.entity.Course;
import com.entity.Teacher;
import com.entity.Title;

public class DatabaseUtils {
    // 封装为私有属性，防止外部直接将属性修改
    private static List<Teacher> teachers;
    private static List<Title> titles;
    private static List<Course> courses;

    //静态方法块，静态代码块按顺序执行，随着类的加载而执行，且只执行一次
    static {
        // 模拟职称
        Title t1 = new Title(1, "讲师");
        Title t2 = new Title(2, "副教授");
        Title t3 = new Title(3, "教授");
        titles = List.of(t1, t2, t3);
        // 模拟课程
        Course c1 = new Course(1, "Web开发技术");
        Course c2 = new Course(2, "Java程序设计");
        Course c3 = new Course(3, "数据库原理");
        Course c4 = new Course(4, "软件项目管理");
        courses = List.of(c1, c2, c3, c4);
        // 模拟2个教师
        Teacher teach1 = new Teacher(1, "唐晨阳", List.of(c1, c4), t3, new Date());
        Teacher teach2 = new Teacher(2, "刘春枝", List.of(c2, c3), t2, new Date());
        teachers = List.of(teach1, teach2);
    }

    /**
     * 获取全部职称
     * @return
     */
    public static List<Title> listTitles() {
        return titles;
    }

    /**
     * 获取全部课程
     * @return
     */
    public static List<Course> listCourses() {
        return courses;
    }

    /**
     * 获取全部教师
     * @return
     */
    public static List<Teacher> listTeachers() {
        return teachers;
    }

    // 获取指定ID的教师
    public static Teacher getTeacher(int id) {
        //只有当方法链的第一个对象为方法且steam()为单独一行时才会显示提示
        return listTeachers()
                .stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}