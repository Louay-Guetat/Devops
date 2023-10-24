package tn.esprit.SkiStationProject.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.SkiStationProject.entities.Course;
import tn.esprit.SkiStationProject.entities.enums.Support;
import tn.esprit.SkiStationProject.entities.enums.TypeCourse;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testGetAllOrderByInscriptionsNumberSQL() {
        List<Course> courses = courseRepository.getAllOrderByInscriptionsNumberSQL();
        assertEquals(2, courses.size());
    }

    @Test
    public void testGetAllOrderByInscriptionsNumberJPQL() {
        List<Course> courses = courseRepository.getAllOrderByInscriptionsNumberJPQL();
        assertEquals(2, courses.size());
    }

    @Test
    public void testGetCoursesBySupportAndTypeCourse() {
        Support support = Support.SKI;
        TypeCourse typeCourse = TypeCourse.COLLECTIVE_CHILDREN;

        List<Course> courses = courseRepository.getcourbysupportskiettypecourcollectif_enfant(support, typeCourse);
        assertEquals(1, courses.size());
    }
}
