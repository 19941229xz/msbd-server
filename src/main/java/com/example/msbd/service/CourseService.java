package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Course;


public interface CourseService {



	public Object getAllCourse(PageParam<Course> pageParam);

    public boolean removeCourseById(int id);

    public Object addCourse(Course course);

    public boolean updateCourse(Course course);

    public Course getCourseById(int id);


}