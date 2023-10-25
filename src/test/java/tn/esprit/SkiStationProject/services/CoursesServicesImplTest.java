package tn.esprit.SkiStationProject.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.SkiStationProject.entities.Course;
import tn.esprit.SkiStationProject.entities.enums.Support;
import tn.esprit.SkiStationProject.entities.enums.TypeCourse;
import tn.esprit.SkiStationProject.repositories.CourseRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CoursesServicesImplTest {
    @Autowired
    ICourseServices courseServices;

    @Autowired
    CourseRepository courseRepository;

    @Test
    @Order(1)
    public void testRetrieveAllCourses(){
        long rowCount = courseRepository.count();

        List<Course> listCourses = courseServices.retrieveAllCourses();

        Assertions.assertEquals(rowCount, listCourses.size());
    }

    @Test
    @Order(2)
    public void testAddCourse(){
        Course course = new Course();
        course.setLevel(2);
        course.setPrice(22.04F);
        course.setSupport(Support.SKI);
        course.setTimeSlot(200);
        course.setTypeCourse(TypeCourse.INDIVIDUAL);

        Course savedCourse = courseServices.addCourse(course);
        assertEquals(course, savedCourse);
    }

    @Test
    @Order(3)
    public void testUpdateCourse() {
        Course course = courseServices.retrieveCourse(5L);
        course.setPrice(780.5F);
        course.setTimeSlot(1000);
        
        Course updated = courseServices.updateCourse(course);
        assertEquals(course, updated);
    }

    @Test
    @Order(4)
    public void testRetrieveCourse() {
        Long id = 5L;
        Course course = courseServices.retrieveCourse(id);

        assertEquals(id, course.getId());
    }
}
