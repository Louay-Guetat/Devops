package tn.esprit.SkiStationProject.services;

import java.util.List;

import tn.esprit.SkiStationProject.entities.Course;

public interface ICourseServiceTest {
    
    List<Course> retrieveAllCourses();

    Course  addCourse(Course  course);

    Course updateCourse(Course course);

    Course retrieveCourse(Long numCourse);

}
