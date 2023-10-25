package tn.esprit.SkiStationProject.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.SkiStationProject.entities.Course;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CoursesServicesImplTest {
    @Autowired
    ICourseServices courseServices;

    @Test
    @Order(1)
    public void testRetrieveAllCourses(){
        List<Course> listCourses = courseServices.retrieveAllCourses();
        Assertions.assertEquals(2, listCourses.size());
    }
}
